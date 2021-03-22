#include <stdio.h>

int main_stest02() {
	char str[80];
	printf("문자열입력:");
	scanf_s("%s", str,sizeof(str));
	printf("문자열입력:%s\n",str);
	while (getchar() != '\n');
	scanf_s("%s", str, sizeof(str));
	printf("문자열입력:%s\n", str);
	return 0;
}