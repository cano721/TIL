#include <stdio.h>
void rotate(int*, int*, int*);
int main_exam4() {
	int a = 10, b = 20, c = 30;
	char ch; // Ű����� �Է��ϴ� ���� ����
	printf("�����̼� ����\n");
	printf("%d %d %d", a,b,c);
	while (1) 
	{
		scanf_s("%c", &ch,1);
		//enterŰ �̿��� Ű���� Ű�� ���������� �ݺ��� ����
		if (ch != '\n') {
			break;
		}
		rotate(&a, &b, &c);
		printf("%d %d %d", a, b, c);
	}
	printf("���α׷� ����\n");
	return 0;
}

void rotate(int* a, int* b, int* c) {
		int temp = *c;
		*c = *a;
		*a = *b;
		*b = temp;
}