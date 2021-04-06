import paho.mqtt.client as mqtt
import RPi.GPIO as GPIO



def on_connect(client, userdata, flags, rc):
    print("connect.." + str(rc))
    if rc == 0:
        client.subscribe("mydata/led")
    else:
        print("fail")


def on_message(client, userdata, msg):
    myval = msg.payload.decode("utf-8")
    print(msg.topic + " " + str(myval))

    GPIO.setmode(GPIO.BCM)
    LED = 20
    GPIO.setup(LED, GPIO.OUT, initial=GPIO.LOW)
    if myval == "led_on":
        GPIO.output(LED,GPIO.HIGH)
    elif myval == "led_off":
        GPIO.output(LED,GPIO.LOW)



mqttClient = mqtt.Client()
mqttClient.on_connect = on_connect

mqttClient.on_message = on_message

mqttClient.connect("172.30.1.52", 1883, 60)

mqttClient.loop_forever()
