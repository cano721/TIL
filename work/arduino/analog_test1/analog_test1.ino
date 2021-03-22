void setup() {
  pinMode(11,OUTPUT);
}

void loop() {
  //analogWrite(11,255); //8비트이므로 255까지 가능
  for(int i=0; i<256; i++){
   analogWrite(11,i);
   delay(10); 
  }
  for(int i=255; i>=0; i--){
   analogWrite(11,i);
   delay(10); 
  }
}
