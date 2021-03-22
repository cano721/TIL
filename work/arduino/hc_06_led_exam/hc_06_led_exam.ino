#include <SoftwareSerial.h>
#define rxPin 2
#define txPin 3

int led= 13;
String mystr = "";
SoftwareSerial swSerial(rxPin,txPin); // (2,3)
void setup() {
  Serial.begin(9600);
  swSerial.begin(9600);
  pinMode(led,OUTPUT);
}

void loop() {
  delay(100);
  while(swSerial.available()){
    char myChar = swSerial.read();
    mystr = mystr + myChar;
  }
  if(!mystr.equals("")){
    Serial.println("input data:"+mystr);
  }

  if(mystr=="on"){
    digitalWrite(led,1);
  }
  if(mystr=="off"){
    digitalWrite(led,0);
  }
  mystr="";//mystr을 초기화
}
