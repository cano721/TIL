#include <stdio.h>

int main(void) {
	int age = 0;
	printf("나이를 입력하세요:");
	//age라는 변수명으로 할당된 메모리의 주소에 저장된 값을 입력받은 값으로 변경
	scanf_s("%d", &age);
	//fflush 기존 저장된 버퍼를지워라(하지만 보안결함이 있음)
	
	//표준입력을 새로 받기 위해서 버퍼를 비우는 작업
	while (getchar() != '\n');
	char name[10] = { 0 }; //모든 char배열의 요소를 0으로 초기화
	printf("이름을 입력하세요:");
	gets_s(name, sizeof(name));
	printf("나이:%d, 이름:%s\n", age, name);
	return 0;

}