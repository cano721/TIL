void setup() {
  Serial.begin(9600);
}

void loop() {
  //아날로그데이터를 읽기 - 0~1023사이값을 읽을 수 있다.
  int photoresistorVal = analogRead(A0);
  Serial.println(photoresistorVal);
  if(photoresistorVal>500){
    digitalWrite(13,HIGH);
  }else{
    digitalWrite(13,LOW);
  }
  delay(500);
}
