from flask import  Flask, render_template, request, Response
import RPi.GPIO as GPIO
import MyCamera

app = Flask(__name__)
GPIO.setmode(GPIO.BCM)
LED = 20
GPIO.setup(LED,GPIO.OUT,initial=GPIO.LOW)



# 만들어낸 프레임을 전송하는 역할을 하는 메소드
def show(camera):
    while True:
        frame = camera.getStreaming()
        yield (b'--frame\r\n'
               b'Content-Type: image/jpeg\r\n\r\n' + frame + b'\r\n')

@app.route("/show")
def showVideo():
    return Response(show(MyCamera.Camera()),mimetype="multipart/x-mixed-replace;boundary=frame")


@app.route("/<command>")
def action(command):
    if command == "on":
        GPIO.output(LED,GPIO.HIGH)
        message = "GPIO" + str(LED) + "ON"
    elif command =="off":
        GPIO.output(LED,GPIO.LOW)
        message = "GPIO" + str(LED) + "OFF"
    else:
        message = "Fail"

    msg = {
        "message": message,
        "status" : GPIO.input(LED)
    }
    return render_template("led.html",**msg)

if __name__ == "__main__":
    try:
        app.run(host="0.0.0.0",debug=True, threaded=True)
    except KeyboardInterrupt:
        print("exit")
        GPIO.cleanup()