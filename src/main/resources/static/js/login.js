function sendData() {
    const inputEmail = document.getElementById("email");
    const inputPassword = document.getElementById("password");

    const userCredentials = {
        email: inputEmail.value,
        password: inputPassword.value
    };

    console.log(userCredentials);

    // Create an object with the data you want to send
    // const requestData = {
    //     data: data
    // };

    // Perform the AJAX POST request
    fetch("/api/v1/auth/authenticate", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            'Authorization': 'True'
        },
        body: JSON.stringify(userCredentials)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        })
        .then(data => {
            // Handle the response from the server
            console.log("Response from server:", data);
            redirectToHomePage();

        })
        .catch(error => {
            // Handle any errors that occurred during the request
            console.error("Error:", error);
        });
}

function redirectToHomePage() {
    // Redirect to the home page
    window.location.href = '/page/afterLogin';
}