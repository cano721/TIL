#include <stdio.h>
#include <stdlib.h>
int main_dm() {
	int* plist = NULL;
	//malloc리턴값 - 힙에 할당된 메모리영역 중 첫 번째 바이트의 주소 void*
	//malloc매개변수 - 요청할 메모리의 사이즈(바이트단위)
	//동적할당이므로 실행할때마다 주소가 바뀐다.
	plist = malloc(sizeof(int) * 3);//12byte 할당
	plist[0] = 10;
	plist[1] = 20;
	plist[2] = 30;

	*(((char*)plist) + 12) = 'A';
	free(plist);
	return 0;
}