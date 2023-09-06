class Transaction {
    constructor(accountId, deposit, withdrawal) {
        this.accountId = accountId;
        this.deposit = deposit;
        this.withdrawal = withdrawal;
    }
}

function getAjaxBodyPrototype() {
    return {
        crossDomain: true,
        type: "PUT",
        dataType: "JSON",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        success: function (response) {
            alert(JSON.stringify(response));
        },
        error: function () {
            alert('Error while request..');
        }
    };
}

function deposit(e) {
    e.preventDefault();
    const accountId = document.getElementById("account-id").value;
    const amount = document.getElementById("amount").value;
    const ajaxBody = getAjaxBodyPrototype();
    ajaxBody.url="/transactions/accounts/"+ accountId + "/deposit/" + amount;
    $.ajax(ajaxBody);
}

function withdrawal(e) {
    e.preventDefault();
    const accountId = document.getElementById("account-id").value;
    const amount = document.getElementById("amount").value;
    const ajaxBody = getAjaxBodyPrototype(accountId, amount);
    ajaxBody.url="/transactions/accounts/"+ accountId + "/withdrawal/" + amount;
    $.ajax(ajaxBody);
}