/*
 * RGB,LED, 스위치, 가변저항
 * 스위치 : RGB 선택하기
 * 가변저항: RGB LED에 셋팅할 값
 * 스위치: PULL DOWN
 */
//RGB LED
int redpin = 11;
int greenpin = 10;
int bluepin = 9;
//PUSH 
int push_btn = 13;
//현재 설정할 Color
int selectionColor = 1;//R

void setup() {
  pinMode(redpin,OUTPUT);
  pinMode(greenpin,OUTPUT);
  pinMode(bluepin,OUTPUT);

  pinMode(push_btn,INPUT);
  Serial.begin(9600);
}

void loop() {
  //push버튼의 상태 저장
  int btn_state = digitalRead(push_btn);
  //가변저항값읽기
  int inputVal = analogRead(A0);
  //RGB LED에 셋팅할 값으로 변환
  int convertVal = map(inputVal,0,1023,0,255);

  Serial.println("현재가변저항의 바뀐 값:" +(String)convertVal);
  //push버튼을 누른 순서에 따라 RGB가 셋팅될 수 있도록
  if(btn_state==HIGH){
    if(selectionColor ==1){
      Serial.println("RED:"+(String)convertVal);
      analogWrite(redpin,convertVal);
      selectionColor ==2;
    }else if(selectionColor ==2){
      Serial.println("Green:"+(String)convertVal);
      analogWrite(greenpin,convertVal);
      selectionColor ==3;
    }else if(selectionColor ==3){
      Serial.println("blue:"+(String)convertVal);
      analogWrite(bluepin,convertVal);
      selectionColor ==1;
    }
    delay(1000);
  }
}
