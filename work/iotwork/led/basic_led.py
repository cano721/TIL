import RPi.GPIO as GPIO
import time
#GPIO pinMode setting BCM: Pin number -> BCM mode, BOARD: pyysical pin Number
GPIO.setmode(GPIO.BCM)
LED = 21

#LED로 정의한 21번을 GPIO의 output핀으로 쓰겠다고 정의
GPIO.setup(LED,GPIO.OUT , initial = GPIO.LOW)
GPIO.output(LED,GPIO.HIGH) #21번으로 출력