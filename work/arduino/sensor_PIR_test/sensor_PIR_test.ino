void setup() {
  pinMode(8,INPUT);
  pinMode(13,OUTPUT);
  Serial.begin(9600);
}

void loop() {
  int value = digitalRead(8);
  Serial.println(value);
  if(value==1){
    digitalWrite(13,1);
    Serial.println("움직임이 감지됐습니다.");
  }else{
   digitalWrite(13,0);
  }
  delay(500);
}
