#include <stdio.h>

int main_stest02() {
	char str[80];
	printf("���ڿ��Է�:");
	scanf_s("%s", str,sizeof(str));
	printf("���ڿ��Է�:%s\n",str);
	while (getchar() != '\n');
	scanf_s("%s", str, sizeof(str));
	printf("���ڿ��Է�:%s\n", str);
	return 0;
}