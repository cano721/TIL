
#include <stdio.h>
int main(){
	int a = 0, b = 0, c = 0, max = 0;
	printf("�� 3�� �Է�:");
	scanf_s("%d %d %d", &a,&b,&c);
	max = a < b ? b < c ? c : b
		: a < c ? c : a;
	printf("�ִ밪��: %d",max);
	return 0;
}