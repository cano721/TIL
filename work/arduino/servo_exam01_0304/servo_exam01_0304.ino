// 스위치 2개를 이용해서 서보모터 각도를 제어
// 스위치 1개는 각도가 +20도
// 다른 1개는 각도가 -20
//풀업으로 구현
// 최대각도:180,최소각도:0
//메일로 제출
#include <Servo.h>
Servo myServo;
int push_btn1 = 7;
int push_btn2 = 4;
int btn1_state = 0, btn2_state = 0;
int angle = 0;
int pass_angle = 0;
void setup() {
  myServo.attach(6);
  pinMode(push_btn1,INPUT);
  pinMode(push_btn2,INPUT);
}

void loop() {
  btn1_state = digitalRead(push_btn1);
  btn2_state = digitalRead(push_btn2);
  if(btn1_state==LOW){
    if(angle != 180){
      pass_angle = angle;
      angle += 20;
    }
    else{
      pass_angle = angle;
    }
    for(int i = pass_angle; i <=angle; i++){
      myServo.write(i);
      delay(100);  
    }
  }
  if(btn2_state==LOW){
    if(angle != 0){
    pass_angle = angle;
    angle -= 20;
    }
    else{
      pass_angle = angle;
    }
    for(int i = pass_angle; i >=angle; i--){
      myServo.write(i);
      delay(100);  
    }
  }
}
