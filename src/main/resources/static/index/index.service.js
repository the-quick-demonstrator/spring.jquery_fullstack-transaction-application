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
    const depositAmount = document.getElementById("amount").value;
    const transaction = new Transaction(accountId, depositAmount, 0)
    const transactionData = JSON.stringify(transaction);
    const ajaxBody = getAjaxBodyPrototype();
    ajaxBody.type="PUT";
    ajaxBody.url="/accounts/deposit";
    ajaxBody.data=transactionData;
    $.ajax(ajaxBody);
}

function withdrawal(e) {
    e.preventDefault();
    const accountId = document.getElementById("account-id").value;
    const withdrawalAmount = document.getElementById("amount").value;
    const transaction = new Transaction(accountId, 0, withdrawalAmount)
    const transactionData = JSON.stringify(transaction);
    const ajaxBody = getAjaxBodyPrototype();
    ajaxBody.type="PUT";
    ajaxBody.url="/accounts/withdrawal";
    ajaxBody.data=transactionData;
    $.ajax(ajaxBody);
}