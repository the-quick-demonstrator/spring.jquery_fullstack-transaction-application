class Transaction {
    constructor(accountId, deposit, withdrawal) {
        this.accountId = accountId;
        this.deposit = deposit;
        this.withdrawal = withdrawal;
    }
}

function deposit(e) {
    e.preventDefault();
    const accountId = document.getElementById("account-id").value;
    const depositAmount = document.getElementById("amount").value;
    const transaction = new Transaction(accountId, depositAmount, 0)
    const transactionData = JSON.stringify(transaction);

    $.ajax({
        type: "PUT",
        crossDomain: true,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        url: "/account-controller/deposit",
        data: transactionData,
        dataType: "JSON",
        success: function (response) {
            alert(JSON.stringify(response));
        },
        error: function () {
            alert('Error while request..');
        }
    });
}


function withdrawal(e) {
    e.preventDefault();
    const accountId = document.getElementById("account-id").value;
    const withdrawalAmount = document.getElementById("amount").value;
    const transaction = new Transaction(accountId, 0, withdrawalAmount)
    const transactionData = JSON.stringify(transaction);

    $.ajax({
        type: "PUT",
        crossDomain: true,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        },
        url: "/account-controller/withdrawal",
        data: transactionData,
        dataType: "JSON",
        success: function (response) {
            alert(JSON.stringify(response));
        },
        error: function () {
            alert('Error while request..');
        }
    });
}