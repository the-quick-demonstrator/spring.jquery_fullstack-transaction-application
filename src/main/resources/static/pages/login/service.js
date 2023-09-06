class LoginForm {
    async isValidLogin() {
        let isValidLogin=false;
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        const endpoint = "/login/" + username + "/" + password;
        await $.ajax({
            type: "GET",
            dataType: "JSON",
            crossDomain: true,
            url: endpoint,
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            },
            success: function (response) {
                isValidLogin = true;
            },
            error: function (request, status, error) {
                alert('Invalid Login');
            }
        });
        return isValidLogin;
    }

    async modifyDomState(isLogin) {
        const loginForm = document.getElementById('form');
        const modal = document.querySelector('.container-msg-modal');
        const modalContent = document.querySelectorAll('.container-modal-content');
        const errorMsg = document.querySelector('.container-modal-content--error');
        const successMsg = document.querySelector('.container-modal-content--success');
        modal.classList.add('enabled')
        if(isLogin) {
          successMsg.classList.add('enabled')
        } else {
          errorMsg.classList.add('enabled')
        }

        setTimeout(function() {
          modal.classList.remove('enabled')
          loginForm.reset();
          modalContent.forEach(function(content) {
            content.classList.remove('enabled')
          });
        }, 3000)
    }

    async login() {
        const isValid =  await this.isValidLogin()
        await this.modifyDomState(isValid);
    }
}

async function login(event) {
    event.preventDefault();
    await new LoginForm().login();
}