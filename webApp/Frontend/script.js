document.getElementById("loginForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const username = document.querySelector("input[name='username']").value;
    const password = document.querySelector("input[name='password']").value;

    const response = await fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ username, password })
    });

    if (response.ok) {
        const user = await response.json();
        localStorage.setItem("username", user.username);
        window.location.href = "main.html";
    } else {
        alert("Credenciales incorrectas");
    }
});
