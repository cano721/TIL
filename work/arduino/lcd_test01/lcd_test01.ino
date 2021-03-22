#include <LiquidCrystal.h>
LiquidCrystal lcd(12,11,4,5,6,7);
int count;
void setup() {
  //가로로 2줄, 세로로 16글자로 표현
  lcd.begin(16,2);//1602 LCD
  lcd.print("Hello");
}

void loop() {
  lcd.setCursor(0,1);//(행,컬럼)
  //lcd.print("1234567");
//  for(int i=0;i<9;i++){
//    lcd.print(i);
//    delay(500);
//  }
  lcd.print(count++);
  delay(1000);
}
