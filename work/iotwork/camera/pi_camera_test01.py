from picamera import PiCamera
from time import sleep

camera = PiCamera() # PiCamera객체 생성
camera.start_preview() # 미리보기 화면을 시작
sleep(10) # 최소 2초 정도는 이미지 캡처하기 전에 시간을 delay
# 카메라 센서가 빛을 감지하기 위한 시간
camera.stop_preview() # 미리보기 화면 정지
