#include <Stdio.h>

int main_examfor01() {
	int sum= 0, even=0, odd=0;
	for (int i = 1; i <= 100; i++) {
		sum += i;
		if (i % 2 == 0) {
			even += i;
		}
		if (i % 2 == 1) {
			odd += i;
		}
	}
	printf("����:%d", sum);
	printf("¦��:%d", even);
	printf("Ȧ��:%d", odd);
}