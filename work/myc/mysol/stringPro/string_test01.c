#include <stdio.h>

int main_stest01() {
	/*
	문자열은 char배열로 관리
	1. 문자열은 컴파일과정에서 첫 번째 문자의 주소로 바뀐다.
	2. 컴파일러는 문자열을 char배열에 따로 보관
	3. char변수의 주소 바뀌므로 직접 포인터 연산을 할 수 있다.
	4. 배열처럼 접근할 수 있다. 단, 배열처럼 직접 문자열을 바꾸면 안된다.
		char ch[5]
		ch[0] = 'A' --- X
	*/
	printf("주소값:%p,%s\n", "c programming", "c programming");
	printf("첫 번째 문자:%c\n", *"cprogramming");
	printf("두 번째 문자:%c\n",*("cprogramming"+1));
	printf("세 번째 문자:%c\n", "cprogramming"[2]);
	
	//문자열을 수정
	//문자열상수인 경우 읽기 전용 메모리 영역에 저장하므로 값을 바꿀 수 없다.
	char* mydata = "c programming";
	printf("mydata:%s\n", mydata);

	mydata = "java programming";
	printf("mydata:%s\n", mydata);
	return 0;
}