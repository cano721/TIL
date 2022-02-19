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
var myName = "hae";


// // 콘솔 출력
console.log(a + b); // 7 더하기 연산
console.log(a - b); // 3 빼기 연산
console.log(a * b); // 10 곱하기 연산
console.log(a / b); // 2.5 나누기 연산
console.log(a ** b); // 25 제곱 연산
console.log(a % b); // 1 나머지 연산
console.log("hello " + myName); // 결과 hello hae
myName = "haebum"
console.log("hello",myName); // 결과 hello haebum


// 배열array
const dayOfWeek = ["mon", "tue", "wed", "thu", "fri", "sat"];
const nonesense = [1, 2, "hello", false, null, true, undefined, "hae"];

//get Item from Array
console.log(dayOfWeek[5]);
dayOfWeek[5] = "days";

//Add one more day to the array
dayOfWeek.push("sun");
delete dayOfWeek[5];
console.log(dayOfWeek);

// object
const player = {
    name: "haebum",
    points: 10,
    fat: true,
};
console.log(player);
console.log(player.name);
console.log(player["name"]);

// object 타입이 const여도 property 변경은 가능하다.
player.fat = false;
player.points = player.points + 15;

// object에 property 추가
player.lastName = "potato";
console.log(player);

// object에 property 삭제
delete player.lastName;
console.log(player);

// function
function sayHello(nameOfPerson, age){
    console.log("hello my name is",nameOfPerson, "and I'm",age);
}

sayHello("haebum", 10);
sayHello("nico", 20);
sayHello("lynn", 23);

function plus(a,b){
    console.log(a+b);
}

plus(1,3);
// argument를 2개 초과해서 보내도 앞에서부터 정해진 개수만 인식하여 함수 실행

const player2 = {
    name: "nico",
    sayHello: function(otherPersonName){
        console.log("hello!",otherPersonName);
    }
}

player2.sayHello("nico");

// return 반환값
const age = 96;
function calculateKrAge(ageOfForeigner){
    return ageOfForeigner+2;
}

const krAge = calculateKrAge(age);
console.log(krAge);

// 조건문

const age2 = prompt("How old are you?"); // 입력값 받는 팝업창을 띄워 입력값을 반환함

console.log(typeof age2); // 타입 확인 방법
console.log(parseInt(age2)); // string -> number 변환

const age = parseInt(prompt("How old are you?")); // 숫자가 맞으면 숫자, 아니면 NaN 반환
isNaN(); //NaN인지 판별하여 boolean값 반환 함수

if(isNaN(age)){
    // condition == true 일때 아래 조건 실행
    console.log("Please write a number");
} else if(age < 18){
    // 위의 조건에 해당하지 않으면서, 현재 조건에 해당할때 실행
    console.log("Yout are too young");
} else{
    // 위의 조건들이 다 해당하지 않을때 실행
    console.log("You can't drink");
}
// 연산자
// && === ||