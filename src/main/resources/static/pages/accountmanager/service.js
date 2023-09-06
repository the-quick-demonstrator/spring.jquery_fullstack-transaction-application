class Account {
    constructor(id, username, password, balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
}

function create(e) {
    e.preventDefault();
    const id = document.getElementById("id").value;
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const balance = document.getElementById("balance").value;
    const account = new Account(id, username, password, balance);
    const data = JSON.stringify(account);
    console.log(data)

    $.ajax({
        type: "POST",
        crossDomain: true,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        url: "/accounts/create",
        data: data,
        dataType: "JSON ",
        success: function (response) {
            alert(JSON.stringify(response));
        },
        error: function () {
            alert('Error while request..');
        }
    });

}

function read(e) {
    e.preventDefault();
    const id = document.getElementById("id").value;

    $.ajax({
        type: "GET",
        crossDomain: true,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        url: "/accounts/read/".concat(id),
        dataType: "JSON",
        success: function (response) {
            alert(JSON.stringify(response));
        },
        error: function () {
            alert('Error while request..');
        }
    });
}


function readAll(e) {
    e.preventDefault();

    $.ajax({
        type: "GET",
        crossDomain: true,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        url: "/accounts/read-all",
        dataType: "JSON",
        success: function (response) {
            alert(JSON.stringify(response));
        },
        error: function () {
            alert('Error while request..');
        }
    });
}


function update(e) {
    e.preventDefault();
    const id = document.getElementById("id").value;
    const name = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const balance = document.getElementById("balance").value;
    const account = new Account(0, name, password, balance);
    const data = JSON.stringify(account);

    $.ajax({
        type: "PUT",
        crossDomain: true,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        url: "/accounts/update/".concat(id),
        data: data,
        dataType: "JSON",
        success: function (response) {
            alert(JSON.stringify(response));
        },
        error: function () {
            alert('Error while request..');
        }
    });
}


function destroy(e) {
    e.preventDefault();
    const id = document.getElementById("id").value;

    $.ajax({
        type: "DELETE",
        crossDomain: true,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        url: "/accounts/delete/".concat(id),
        dataType: "JSON",
        success: function (response) {
            alert(JSON.stringify(response));
        },
        error: function () {
            alert('Error while request..');
        }
    });
}