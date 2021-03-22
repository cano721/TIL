//가변저항으로 led의 밝기 조절

int led =11;
void setup() {
  Serial.begin(9600);
}

void loop() {
  //가변저항에서 값을 읽어오기 - 0~1023
  //led: 0~255
  int inputVal = analogRead(A0);
  //Serial.println(inputVal);
  //converVal = inputVal/4;
  //converVal = inputVal *255/1023; 이렇게 해도 됨
  //입력값으로 전달되는 값의 범위를 이용해서
  //원하는 범위 값으로 변경할 수 있도록 지원하는 함수
  int converVal = map(inputVal,0,1023,0,255);
  Serial.print(inputVal);
  Serial.print("\t");
  Serial.println(converVal);
  analogWrite(led,converVal);
  delay(500);
}
