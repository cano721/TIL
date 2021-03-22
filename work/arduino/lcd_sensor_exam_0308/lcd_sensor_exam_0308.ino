//빛의 세기가 500이상이면
//lcd에 현재 측정한 온도와 습도를 쓰기
//[출력형태] temp:24
//humidity: 30

#include <DHT.h>
#include <LiquidCrystal.h>
LiquidCrystal lcd(12,11,4,5,6,7);
DHT mydht11(A0,DHT11);
void setup() {
  mydht11.begin();
  lcd.begin(16,2);
}

void loop() {
  delay(2000); //측정시 시간간격 2초
  int photorVal = analogRead(A1);
  int h = mydht11.readHumidity();//습도
  int t = mydht11.readTemperature();//온도
  if(photorVal>=500){
    lcd.setCursor(0,0);
    lcd.print("Temp: ");
    lcd.print(t);
    lcd.setCursor(0,1);
    lcd.print("Humidity: ");
    lcd.print(h);
  }
}
