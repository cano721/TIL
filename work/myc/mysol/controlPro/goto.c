#include <stdio.h>
//비트연산자
int main_temp() {
	int num = 1;
label:
	printf("c프로그래밍:%d\n", num);
	num = num + 1;
	if (num == 10) goto out;
	goto label;
out:
	return 0;
}