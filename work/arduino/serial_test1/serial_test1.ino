//시리얼통신테스트

void setup() {
  //시리얼통신 시작 - 시리얼통신을 위한 기본 준비를 시작하고 9600은 통신속도
  //시리얼 모니터랑 맞춰야함
  Serial.begin(9600);
  
}

void loop() {
  //Serial.println("Hello world~~");
 //Serial.available() - 값이 들어온게 있는지 확인(데이터 있으면 t,f)
  if(Serial.available()){
    //Serial.read() - pc에서 보낸 값을 1byte 단위로 읽어서 리턴
    Serial.println(Serial.read());
  }
  delay(1000);

}
