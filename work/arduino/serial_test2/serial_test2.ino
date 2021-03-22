int inputdata =0;
void setup() {
  Serial.begin(9600);
}

void loop() {
  int indata = 65;
  char chardata = 65;
  float floatdata = 65;

//  Serial.println(indata);
//  Serial.println(chardata);
//  Serial.println(floatdata);
  //delay(1000);
  if(Serial.available()>0){ // 읽어들인 데이터가 있다면
    inputdata = Serial.read();
    Serial.write(inputdata); //입력한 문자를 읽어서 리턴
    Serial.print(",");
    Serial.println(inputdata); //askii코드로 변환해서 출력
  }
}
