from picamera import PiCamera, Color
from time import sleep

camera = PiCamera() # PiCamera객체 생성
camera.rotation = 180
camera.start_preview() # 미리보기 화면을 시작

camera.annotate_text_size = 50
camera.annotate_background = Color('blue')
camera.annotate_foreground = Color('blue')
camera.annotate_text = " raspberry pi "

sleep(10)
camera.capture('/home/pi/iot/image.jpg')
camera.stop_preview() # 미리보기 화면 정지
