void setup() {
  Serial.begin(9600);
  pinMode(11,OUTPUT);
  pinMode(10,OUTPUT);
  pinMode(9,OUTPUT);
}

void loop() {
  int red = random(256); //0~255
  int green = random(256); //0~255
  int blue = random(256); //0~255

  Serial.print(red);
  Serial.print("\t");
  Serial.print(green);
  Serial.print("\t");
  Serial.print(blue);
  analogWrite(11,red);
  analogWrite(10,green);
  analogWrite(9,blue);
  delay(1000);//90%
}
