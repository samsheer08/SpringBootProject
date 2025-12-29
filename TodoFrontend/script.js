// Shared script for login, register, and todos pages
const SERVER_URL = "http://localhost:8080";
const token = localStorage.getItem("token");

// Login page logic
function login() {

}

// Register page logic
function register() {

}

// Todos page logic
function createTodoCard(todo) {

}

function loadTodos() {

}

function addTodo() {

}

function updateTodoStatus(todo) {

}

function deleteTodo(id) {

}

// Page-specific initializations
document.addEventListener("DOMContentLoaded", function () {
    if (document.getElementById("todo-list")) {
        loadTodos();
    }
});
