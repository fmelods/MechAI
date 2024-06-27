function handleLogin(event) {
    event.preventDefault();
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const errorMessage = document.getElementById("error-message");

    if (username === "mecanico" && password === "123") {
        window.location.href = "./mecanico.html";
    } else if (username === "cliente" && password === "123") {
        window.location.href = "./cliente.html";
    } else {
        errorMessage.textContent = "Dados incorretos, tente novamente";
    }
}

function handleCancel() {
    document.getElementById("authForm").reset();
    document.getElementById("error-message").textContent = "";
}