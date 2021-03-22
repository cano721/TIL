void setup() {
  Serial.begin(9600);
}

void loop() {
  delay(1000);
  if(Serial.available()>1){ //test를 입력시
//    char data = Serial.read(); //첫 바이트만 읽기 때문에 t만 들어감
//    Serial.println(data); 
    //string을 읽어서 리턴
//    String stringdata = Serial.readString();
    String stringdata = Serial.readStringUntil("\n");
    Serial.println(stringdata);
    if(stringdata =="end"){
      Serial.println("OK");
    }else{
      Serial.println("Fail");
    }
  }

}
