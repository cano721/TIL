int red =3;
int green = 5;
int blue = 6;

void setup() {
  pinMode(10, OUTPUT); //10번핀 트리거로 사용
  pinMode(9, INPUT); //9번핀은 에코로 사용
  pinMode(red,OUTPUT);
  pinMode(green,OUTPUT);
  pinMode(blue,OUTPUT);
  
  Serial.begin(9600);
}

void loop() {
  //초음파 신호 보내기
  digitalWrite(10,LOW);
  delayMicroseconds(2);
  digitalWrite(10,HIGH);
  delayMicroseconds(10);
  digitalWrite(10,LOW);

  //초음파 신호 수신
  //초음파를 발생시키고 수신할때 까지 측정하기 위해서 사용 - 얼마의 시간이 걸렸는지 계산
  // low->high로 변하는 시점부터 측정을 하는 경우 pulseIn함수의 HIGH로 지정
  // high->low로 변하는 시점부터 측정 LOW로 정의
  // 마이크로초단위
  //거리 = 340(속력m/s) * duration /1000000(마이크로초단위로 변경)/2(편도로 바꾸기위해)*100(cm단위로 변경)
  double duration = pulseIn(9,HIGH);
  double distance = 340 * duration / 10000/2;
  //측정거리를 출력
  Serial.println(distance);
  int bright = random(256);
  if(distance<10){
    analogWrite(red,bright);
    analogWrite(blue,0);
    analogWrite(green,0);
  }
  else if(distance < 100){
     analogWrite(green,bright);
     analogWrite(blue,0);
    analogWrite(red,0);
  }
  else{
     analogWrite(blue,bright);
     analogWrite(red,0);
     analogWrite(green,0);
  }
  delay(1000);
}
