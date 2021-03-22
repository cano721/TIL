
#include <stdio.h>
#include <limits.h>
int main_type(void) {
	//부호가 없는 정수
	unsigned int i = 0;
	
	sizeof(unsigned int);
	sizeof(i);
	printf("%u\n", sizeof(unsigned int));
	printf("%u\n", sizeof(i));

	//%u => unsigned
	unsigned int max_value = UINT_MAX;
	unsigned int min_value = 0; //unsigned는 모두 최소값이 0
	signed int smax_value = INT_MAX;
	signed int smin_value = INT_MIN;
	printf("unsigned최대값=%u, 최소값=%u\n", max_value, min_value);
	printf("signed최대값=%d, 최소값=%d\n", smax_value, smin_value);
	return 0;
}