#include <SoftwareSerial.h>
#define rxPin 2
#define txPin 3
//swSerail(rxPin,txPin)
String mystr = "";
SoftwareSerial swSerial(rxPin,txPin); // (2,3)
void setup() {
  Serial.begin(9600);
  swSerial.begin(9600);
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
  mystr="";//mystr을 초기화
}
