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