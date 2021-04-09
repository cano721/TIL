from flask import Flask

app = Flask(__name__)


@app.route("/")
def hello():
    return "Hello Raspberry Pi Iot Project~~^^"

#flask를 실행하기 위한 기본 port 5000

app.run(host="0.0.0.0",port="8080", debug=True)