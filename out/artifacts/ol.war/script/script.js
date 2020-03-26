const getForm = document.getElementById("get-form");
const postForm = document.getElementById("post-form");
const putForm = document.getElementById("put-form");
const deleteForm = document.getElementById("delete-form");

getForm.addEventListener("submit", function (e) {
    e.preventDefault();

    const xhr = new XMLHttpRequest();
    const url = "/ol/user";
    xhr.open("GET", url, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200 ) {
            let jsonData = JSON.parse(xhr.response);
            console.log(jsonData);
        } else if (xhr.readyState === 4 && xhr.status === 404) {
            console.log("404 Not Found");
        }
    };

    xhr.send();
});

postForm.addEventListener("submit", function (e) {
    e.preventDefault();

    const xhr = new XMLHttpRequest();
    const url = "/ol/user";
    xhr.open("POST", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 201 ) {
            let jsonData = JSON.parse(xhr.response);
            console.log(jsonData);
        } else if (xhr.readyState === 4 && xhr.status === 400) {
            console.log("400 Bad Request");
        }
    };

    let username = document.getElementById("post-username").value;
    let password = document.getElementById("post-password").value;

    let data = JSON.stringify({"username": username, "password": password});

    xhr.send(data);
});

putForm.addEventListener("submit", function (e) {
    e.preventDefault();

    const xhr = new XMLHttpRequest();
    const url = "/ol/user";
    xhr.open("PUT", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 204 ) {
            console.log("204 No Content");
        } else if (xhr.readyState === 4 && xhr.status === 404) {
            console.log("404 Not Found");
        }
    };

    let id = document.getElementById("put-id").value;
    let username = document.getElementById("put-username").value;
    let password = document.getElementById("put-password").value;

    let data = JSON.stringify({"id": id, "username": username, "password": password});

    xhr.send(data);
});

deleteForm.addEventListener("submit", function (e) {
    e.preventDefault();

    const xhr = new XMLHttpRequest();
    const url = "/ol/user";
    xhr.open("DELETE", url, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 204 ) {
            console.log("204 No Content");
        } else if (xhr.readyState === 4 && xhr.status === 404) {
            console.log("404 Not Found");
        }
    };

    let id = document.getElementById("delete-id").value;

    let data = JSON.stringify({"id": id});

    xhr.send(data);
});