// 사전에 아두이노 라이브러리에 깃허브에서 dht,
//Adafruit_Sensor에 대한 헤더파일을 받아서 넣어둬야한다. 

#include <DHT.h>
DHT mydht11(A0,DHT11); // DHT를 제어하기 위해 DHT11객체 생성
void setup() {
  Serial.begin(9600);
  mydht11.begin();
}

void loop() {
  delay(2000);//측정시 2초이상 간격필요
  //DHT11온습도센서 읽기
  int h = mydht11.readHumidity();//습도
  int t = mydht11.readTemperature();//온도
  int ft = mydht11.readTemperature(true);//화씨 온도
  //센서를 출력하기
  Serial.print("Humidity: ");
  Serial.print(h);
  Serial.print("Temperature: ");
  Serial.print(t);
  Serial.print(" 'c ");
  Serial.print(ft);
  Serial.println(" 'f\t ");
  Serial.println("============================");
}
