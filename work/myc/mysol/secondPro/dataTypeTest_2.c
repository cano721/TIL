
#include <stdio.h>
#include <limits.h>
int main_type2(void) {
	//�Ǽ� - 123.0(double), 123.0f(float)
	printf("%f\n", 123.0);
	printf("%f\n", 123.0f);
	printf("%f\n", 2000000000.0f+20);
	printf("%f\n", 2000000000.0f+40);
	printf("%f\n", 2000000000.0f+60);
	
	printf("%f\n", 2000000000.0+20);
	printf("%f\n", 2000000000.0+40);
	printf("%f\n", 2000000000.0+60);

	//char
	char chardata = 'A';
	chardata = chardata + 1;
	printf("%c\n", chardata);
	printf("%d\n", chardata);

	//python -> Ʃ��,����Ʈ,��ųʸ�,Set
	//�ٸ������� �ڷḦ �ٷ�� �⺻ ���� �迭
	//c������ ���ڿ��� �ٷ궧 char�迭�� ó���� �Ѵ�.
	char mystrBuffer[10] = { 'H','i' };
	char mystrBuffer2[10] = { "hello" };
	puts(mystrBuffer);
	puts(mystrBuffer2);
	//gets_s(mystrBuffer2, sizeof(mystrBuffer2));
	return 0;
}