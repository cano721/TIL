#include <stdio.h>
//��Ʈ������
int main_temp() {
	int num = 1;
label:
	printf("c���α׷���:%d\n", num);
	num = num + 1;
	if (num == 10) goto out;
	goto label;
out:
	return 0;
}