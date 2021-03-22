int time = 500;
int led[3] = {13,12,11};
int ledlength = sizeof(led)/sizeof(int);
int pin=0; //현재 불을 켜기 위해서 led번호를 저장할 변수
void setup() {
  Serial.begin(9600);
  for(int i=0; i<ledlength; i++){
    pinMode(led[i],OUTPUT);
  }
}

void loop() {
  if(Serial.available()>1){
    String data = Serial.readStringUntil("\n");
    if(data == "A0"){
      pin = led[0];
      Serial.println("A0입력");
    }else if(data == "A1"){
      pin = led[1];
      Serial.println("A1입력");
    }else if(data == "A2"){
       pin = led[2];
      Serial.println("A2입력");
  }
  led_alloff();
  led_on(pin);
  }//end available
}//end loop

//ledon - 전달받은 핀 번호에 해당하는 led on
void led_on(int pin){
  digitalWrite(pin,HIGH);
}
//-전달받은 핀 번호에 해당하는 led off
void led_off(int pin){
  digitalWrite(pin,LOW);
}
//모든 led off
void led_alloff(){
  for(int i=0; i<ledlength; i++){
    digitalWrite(led[i],LOW);
  }
}
