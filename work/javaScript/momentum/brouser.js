document.title = "Hello! From js!"

// const title = document.getElementById("title"); // id값을 통해 HTML element를 반환
// title.innerText = "Got you"; // element안의 요소 변경 가능
// console.log(title);
// console.dir(title); // 보다 자세하게 elements 를 볼 수 있음
// console.log(title.id); // element안의 id값 반환

const hellos = document.getElementsByClassName("hello");

console.log(hellos);


// querySelector
// 찾은 element의 첫번째값 반환
const h1 = document.querySelector(".hello h1");
console.log(h1); 

// querySelectorAll
// 전체 반환 array 형태
const titles = document.querySelectorAll(".hello h1");
console.log(titles);


// event
function handleTitleClick(){
    h1.style.color = "blue";
}

h1.addEventListener("click", handleTitleClick);


// 글자 변경
function handleMouseEnter(){
    h1.innerText = "Mouse is here!";
}


function handleMouseLeave(){
    h1.innerText = "Mouse is gone!";
}

h1.addEventListener("mouseenter", handleMouseEnter); // h1에 커서 올리기
h1.addEventListener("mouseleave",handleMouseLeave); // h1에서 커서 떠나기

function handleWindowResize(){
    document.body.style.backgroundColor = "tomato";
}

function handleWindowCopy(){
    alert("copier!");
}

function handlwWindowOffline(){
    alert("SOS no WIFI");
}

function handleWindowOnline(){
    alert("good");
}

window.addEventListener("resize", handleWindowResize); // 브라우저 크기를 변경할때
window.addEventListener("copy", handleWindowCopy); // 카피행동을 할때
window.addEventListener("offline", handlwWindowOffline); // 오프라인될때(wifi 등이 끊긴경우)
window.addEventListener("online", handleWindowOnline); // 온라인될때

const h1 = document.querySelector("div.hello:first-child h1");

// event
function handleTitleClickV1(){
    const clickedClass = "clicked";
    if(h1.className === clickedClass){
        h1.className = "";
    }else {
        h1.className = clickedClass;
    }
}

// 기존에 있던 class이름은 지우지 않기
function handleTitleClickV2(){
    const clickedClass = "clicked";
    if(h1.classList.contains(clickedClass)){ //class내에 있는지 확인 boolean타입 반환
        h1.classList.remove(clickedClass); // 지우기
    }else {
        h1.classList.add(clickedClass); // 추가하기
    }
}

// toggle 이용
function handleTitleClickV3(){
    const clickedClass = "clicked";
    h1.classList.toggle(clickedClass); // 있다면 지우고, 없으면 추가해줌
}

h1.addEventListener("click", handleTitleClickV1);