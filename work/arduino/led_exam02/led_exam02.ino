int time = 500;
int led[3] = {5,6,7};
int ledlength = sizeof(led)/sizeof(int);
void setup() {
  Serial.begin(9600);
  for(int i=0; i<ledlength; i++){
    pinMode(led[i],OUTPUT);
  }
}

void loop() {
  if(Serial.available()>1){
    String inputdata = Serial.readString();
    ledon(inputdata);
    ledoff(inputdata);
  }
}

void ledon(String inputdata){
    if(inputdata == "A0"){
      digitalWrite(led[0],1);
    }
    else if(inputdata == "A1"){
      digitalWrite(led[1],1);
  }else if(inputdata == "A2"){
      digitalWrite(led[2],1);
  }
  return;
}

void ledoff(String inputdata){
  if(inputdata == "B0"){
      digitalWrite(led[0],0);
    }
    else if(inputdata == "B1"){
      digitalWrite(led[1],0);
  }else if(inputdata == "B2"){
      digitalWrite(led[2],0);
  }
  return;
}
