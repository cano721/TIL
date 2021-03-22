
// the setup function runs once when you press reset or power the board
//헤더파일을 등록하거나 핀번호 설정
int time = 500;
int myarr[5] = {13,12,11,10,9};
int myarrlength = sizeof(myarr)/sizeof(int);

void setup() {
  //데이터초기화, 한 번만 실행되는 코드
  //아두이노는 기본적으로 전기신호들어오면 무조건 setup이 제일 먼저 호출
  for(int i=0; i<myarrlength; i++){
    pinMode(myarr[i],OUTPUT);
  }
}

// 전원이 들어오는 동안 무한으로 반복해서 실행되는 코드
// 실질적인 동작을 제어하는 코드가 정의
void loop() {
  // turn the LED on (HIGH is the voltage level)
  for(int i=0; i<myarrlength; i++){
    digitalWrite(myarr[i], 1);
    delay(time);
  }

  // turn the LED off by making the voltage LOW
  for(int i=0; i<myarrlength; i++){
    digitalWrite(myarr[myarrlength-1-i], 0);
    delay(time);
  }   
}
