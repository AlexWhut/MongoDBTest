document.getElementById("loginForm").addEventListener("submit", async function(event) {
    event.preventDefault(); // Evita recargar la página

    const username = document.querySelector("input[name='username']").value;
    const password = document.querySelector("input[name='password']").value;

    const response = await fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ username, password })
    });

    const data = await response.json();

    if (response.ok) {
        localStorage.setItem("username", username); // Guarda el usuario en el almacenamiento local
        window.location.href = "main.html"; // Redirige a main.html
    } else {
        alert("Error: " + data.message);
    }
});