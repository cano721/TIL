int led = 11;
//가변저항테스트
void setup() {
  Serial.begin(9600);
}

void loop() {
  int inputVal = analogRead(A0);
  Serial.println(inputVal);
  //가변저항값이 500이 넘으면 led불이 켜지도록
  //500이하값이면 불이 꺼지도록
  if(inputVal > 500){
    analogWrite(led,255);
  }
  else{
    analogWrite(led,0);
  }
  delay(500);
}
