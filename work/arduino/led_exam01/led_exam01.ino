//1이라는 숫자가 입력되면 13번 led에 불이 켜지도록 설정,0이면 불이 꺼지도록
int inputdata =0;
void setup() {
  Serial.begin(9600);
  pinMode(13,OUTPUT);
}

void loop() {
  if(Serial.available()>0){
    inputdata = Serial.read();
    if(inputdata == 49){
      digitalWrite(13,1);
    }
    else if(inputdata == 48){
      digitalWrite(13,0);
    }
  }  
}
