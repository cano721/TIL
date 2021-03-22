
#include <Servo.h>
Servo myServo;
int push_btn = 8;
int btn_state = 0;
int angle = 0;

void setup() {
  Serial.begin(9600);
  pinMode(10, OUTPUT); //10번핀 트리거로 사용
  pinMode(9, INPUT); //9번핀은 에코로 사용
  myServo.attach(11);
  pinMode(push_btn,INPUT);
}

void loop() {
//초음파 신호 보내기
  digitalWrite(10,LOW);
  delayMicroseconds(2);
  digitalWrite(10,HIGH);
  delayMicroseconds(10);
  digitalWrite(10,LOW);
  
//거리측정
   double duration = pulseIn(9,HIGH);
  double distance = 340 * duration / 10000/2;
  
  btn_state = digitalRead(push_btn);
  if(btn_state ==HIGH){
    if(angle==0){
      angle = 90;
      myServo.write(angle);
    }
    else{
      angle = 0;
      myServo.write(angle);
    }
  }
  if(distance<= 100){
    Serial.println("출입문이 열립니다.");
    for(int i=0; i<=90; i++){
      myServo.write(i);
      delay(10);
    }
    delay(2000);
    Serial.println("출입문이 닫힙니다.");
     for(int i=90; i>=0; i--){
      myServo.write(i);
      delay(10);
    }
  }
  delay(1000);
}
