#include <stdio.h>
//포인터를 사용하는 경우와 포인터를 사용하지 않는 경우를 비교
void display(int);
void change(int);
void pointerChange(int*);
int main_fptest01() {
	int main_num = 100;
	printf("**************change호출전**************\n");
	display(main_num);
	change(main_num);
	printf("**************change호출후**************\n");
	display(main_num);
	pointerChange(&main_num);
	printf("**************pointerChange호출후**************\n");
	display(main_num);
	return 0;
}

void display(int num) { //num이라는 매개변수는 display내부에 선언된 지역변수
	printf("숫자:%d\n", num);
}

void change(int num) {//num이라는 매개변수는 change내부에 선언된 지역변수
	num = 200;
}

void pointerChange(int* num) {//call by reference
	*num = 200;
}