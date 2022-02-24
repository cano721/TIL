const toDoForm = document.getElementById("todo-form");
const toDoInput = toDoForm.querySelector("input");
const toDoList = document.getElementById("todo-list");

const TODOS_KEY = "toDos";

let toDos = [];

function saveToDos(){
    localStorage.setItem(TODOS_KEY, JSON.stringify(toDos));
}

// 삭제 버튼 함수
function deleteToDo(event){
    const li = event.target.parentElement;
    
    li.remove();
    toDos = toDos.filter(item => item.id !== parseInt(li.id));
    saveToDos();
}

// 입력값 todolist 추가 함수
function paintToDo(newTodo){
    const li = document.createElement("li");
    li.id = newTodo.id;
    const span = document.createElement("span");
    span.innerText = newTodo.text;
    const button = document.createElement("button");
    button.innerText = "❌";
    button.addEventListener("click", deleteToDo);
    li.appendChild(span);
    li.appendChild(button);
    toDoList.appendChild(li);
}

// 기본동작 중지 및 입력값 전달 함수
function handleToDoSubmit(event){
    event.preventDefault();
    const newTodo = toDoInput.value;
    toDoInput.value = "";
    const newTodoObj = {
        text:newTodo,
        id: Date.now(),
    };
    toDos.push(newTodoObj);
    paintToDo(newTodoObj);
    saveToDos();
}

toDoForm.addEventListener("submit", handleToDoSubmit);

const savedToDos = localStorage.getItem(TODOS_KEY);

if(savedToDos){
    const parsedToDos = JSON.parse(savedToDos);
    toDos = parsedToDos;
    parsedToDos.forEach(paintToDo);
}

// window 기준 이모지 넣기(윈도우키 + ;)

// parentElement로 element의 부모를 찾을 수 있음.

// JSON.stringify() 를 통해 json형태로 변환 가능
// json.parse() 를 통해 json을 분석하여 javaScript 값이나 객체로 생성

// forEach() 배열을 돌려주면서, 매개변수로 각각의 item을 제공함.

// => arrow function
// 내부에서 람다식처럼 사용 가능
// .forEach((item) => console.log("sdfsdf", item));

// filter()
// filter 조건에 true 값만 새로운 배열에 담아서 반환