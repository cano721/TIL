#include <stdio.h>
void print_test(char** p_args1, char** p_args2) {
	char* temp = *p_args1; // p_args1을 임시저장
	*p_args1 = *p_args2;
	*p_args2 = temp;
}

int main_pte2() {
	char* p_data1 = "c programming";
	char* p_data2 = "raspberryPi";
	printf("p_data1:%s, p_data2:%s\n", p_data1, p_data2);
	printf("p_data1:%p, p_data2:%p\n", p_data1, p_data2);
	printf("p_data1:%p, p_data2:%p\n", &p_data1, &p_data2);
	printf("p_data1:%c, p_data2:%c\n", *p_data1, *p_data2);
	print_test(&p_data1,&p_data2);
	printf("p_data1:%s, p_data2:%s\n", p_data1, p_data2);
	return 0;

}
