int push_btn = 12;
int led = 11;
int btn_state = 0;
void setup() {
  Serial.begin(9600);
  pinMode(push_btn,INPUT);
  pinMode(led,OUTPUT);
}

void loop() {
  delay(1000);
  btn_state = digitalRead(push_btn);
  Serial.println(btn_state);
  if(btn_state==HIGH){
    digitalWrite(led,0);
  }
  else{
    digitalWrite(led,1);
  }
}
