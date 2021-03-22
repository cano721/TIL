int push_btn = 8;
int btn_state = 0;
int led = 11;
int passled = 0;
void setup() {
  Serial.begin(9600);
  pinMode(push_btn,INPUT);
  pinMode(11,OUTPUT);
  pinMode(10,OUTPUT);
  pinMode(9,OUTPUT);
}

void loop() {
  btn_state = digitalRead(push_btn);
  
  int inputVal = analogRead(A0);
  int converVal = map(inputVal,0,1023,0,255);
  if(btn_state==HIGH){
    if(led ==9){
      passled = led;
      led = 11;
    }
    else{
      passled = led;
      led -= 1;
    }
  }
  analogWrite(led,converVal);
  analogWrite(passled,0);
  delay(1000);
}
