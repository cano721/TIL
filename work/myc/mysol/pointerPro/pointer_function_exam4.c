#include <stdio.h>
void rotate(int*, int*, int*);
int main_exam4() {
	int a = 10, b = 20, c = 30;
	char ch; // 키보드로 입력하는 값을 저장
	printf("로테이션 시작\n");
	printf("%d %d %d", a,b,c);
	while (1) 
	{
		scanf_s("%c", &ch,1);
		//enter키 이외의 키보드 키가 눌려졌을때 반복문 종료
		if (ch != '\n') {
			break;
		}
		rotate(&a, &b, &c);
		printf("%d %d %d", a, b, c);
	}
	printf("프로그램 종료\n");
	return 0;
}

void rotate(int* a, int* b, int* c) {
		int temp = *c;
		*c = *a;
		*a = *b;
		*b = temp;
}