/**
 * 변수 사용법 
 * const는 재선언 불가 재할당 불가
 * let은 재선언 불가 재할당 가능
 * 
 * 예전버전
 * var 재선언 가능, 재할당 가능
 */
let a = 5;
const b = 2;
let myName = "hae";

// 콘솔 출력
console.log(a + b);
console.log(a * b);
console.log(a / b);
console.log("hello " + myName); // 결과 hello hae
myName = "haebum"
console.log("hello " + myName); // 결과 hello haebum


// 배열array
const dayOfWeek = ["mon", "tue", "wed", "thu", "fri", "sat"];
const nonesense = [1, 2, "hello", false, null, true, undefined, "hae"];

//get Item from Array
console.log(dayOfWeek[5]);

//Add one more day to the array
dayOfWeek.push("sun");
console.log(dayOfWeek);