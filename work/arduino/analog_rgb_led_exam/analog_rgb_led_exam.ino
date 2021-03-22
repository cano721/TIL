void setup() {
  Serial.begin(9600);
  pinMode(11,OUTPUT);
  pinMode(10,OUTPUT);
  pinMode(9,OUTPUT);
}

void loop() {
  //가변저항에서 값을 읽어오기 - 0~1023
  //led: 0~255
  int led = rand() % ((11-9)+1) +9;
  Serial.print(led);
  analogWrite(led,255);
  delay(1000);
  analogWrite(led,0);
  delay(1000);
}
