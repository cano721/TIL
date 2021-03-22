int push_btn = 12;
int btn_state = 0;
void setup() {
  Serial.begin(9600);
  pinMode(push_btn,INPUT);
}

void loop() {
  delay(1000);
  btn_state = digitalRead(push_btn);
  Serial.println(btn_state);
//  if(btn_state==HIGH){
//    Serial.println("push버튼 누름");
//  }else{
//    Serial.println("push버튼 해제");
//  }
}
