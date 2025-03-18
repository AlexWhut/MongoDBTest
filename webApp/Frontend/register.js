document.getElementById("registerForm").addEventListener("submit", async function(event) {
    event.preventDefault(); // Evita que la página se recargue

    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    const response = await fetch("http://localhost:8080/auth/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ username, password })
    });

    const data = await response.json();

    if (response.ok) {
        alert("Usuario registrado con éxito");
        window.location.href = "index.html"; // Redirige al login
    } else {
        alert("Error: " + data.message);
    }
});