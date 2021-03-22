int push_btn = 12;
int led =11;
int btn_state = 0;
int ledon = 0;
void setup() {
  Serial.begin(9600);
  pinMode(push_btn,INPUT);
  pinMode(led,OUTPUT);
}

void loop() {
  delay(1000);
  btn_state = digitalRead(push_btn);
  Serial.println(ledon);
  if(btn_state==LOW){
    if(ledon == 1){
      ledon= 0;
      digitalWrite(led,ledon);
  }else if(ledon == 0){
    ledon = 1;
    digitalWrite(led,ledon);
  }
}
}
