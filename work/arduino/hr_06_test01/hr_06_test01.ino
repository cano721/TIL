#include <SoftwareSerial.h>
#define rxPin 2
#define txPin 3
//swSerial(rxPin,txPin)
SoftwareSerial swSerial(rxPin,txPin);//(2,3)
void setup() {
  Serial.begin(9600);
  swSerial.begin(9600);
  Serial.println("ready...");
}

void loop() {
  //시리얼 버퍼를 비우는 작업
  Serial.flush();
  Serial.println("command:");
  //사용자가 데이터를 입력할 때까지 대기 - 버퍼에 값이 들어올때까지 대기
  while(!Serial.available());
  //+++++++++hc-06에 명령어를 전송++++++++++
  while(Serial.available()){
    data = Serial.read(); //키보드로 입력하는 블루투스 명령어를 읽어서
    if(data==-1){
      break;
    }
    SwSerial.print(data);
    Serial.print(data);
    delay(1);
  }
  Serial.println();
  //HC-06(블루투스모듈)이 명령어를 받아서 처리할 시간
  delay(1000);
  Serial.println("return:");
  //+++++++++hc-06으로부터 전송된 데이터를 화면에 출력++++++++++
 while(swSerial.available()){
    data2 = swSerial.read(); //키보드로 입력하는 블루투스 명령어를 읽어서
    if(data2==-1){
      break;
    }
    SwSerial.print(data2);
    Serial.print(data2);
    delay(1);
  }
  Serial.println("\n\n\n");
}
