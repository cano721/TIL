int inputdata =0;
void setup() {
  Serial.begin(9600);
}

void loop() {
  if(Serial.available()>0){
    inputdata = Serial.read();
    Serial.write(inputdata);
    //print함수는 1값을 아스키코드로 해석해서 데이터 전송
    //write함수는 1을 그대로 전송 시리얼모니터에서 아스키로 해석해서 출력
    //print는 주로 시리얼통신으로 시리멀모니터에 데이터 출력해서 테스트하는 용도
    //write통신상에서 주고 받는 메시지를 전송할때 사용 -블루투스 지그비통신
    Serial.print(",");
    Serial.println(inputdata);
  }
}
