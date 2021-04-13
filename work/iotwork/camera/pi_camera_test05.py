from picamera import PiCamera, Color
from time import sleep

camera = PiCamera() # PiCamera객체 생성
camera.rotation = 180
camera.start_preview() # 미리보기 화면을 시작

#동영상 저장 시작
camera.start_recording("/home/pi/iot/video.h264")
sleep(10)
camera.stop_recording()
camera.stop_preview() # 미리보기 화면 정지
