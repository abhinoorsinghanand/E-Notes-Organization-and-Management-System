document.addEventListener("DOMContentLoaded", function() {
    function handleLogin(event) {
        event.preventDefault();

        // Retrieve form data
        var username = document.getElementById("exampleInputEmail1").value.trim();
        var password = document.getElementById("exampleInputPassword1").value;

        // Perform form validation
        if (!username || !password) {
            alert("Both username and password are required fields.");
            return;
        }

        // Make AJAX request to the server
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "LoginController", true); // Assuming LoginController is your servlet URL
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function() {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    // Response received from the server
                    var response = JSON.parse(xhr.responseText);
                    if (response.success) {
                        // Redirect to dashboard.html
                        window.location.href = "./dashboard.html";
                    } else {
                        // Display error message
                        alert("Credentials do not match");
                    }
                } else {
                    // Error handling
                    console.error("Request failed with status:", xhr.status);
                }
            }
        };

        // Send form data to the server
        xhr.send("username=" + encodeURIComponent(username) + "&password=" + encodeURIComponent(password));
    }

    // Add event listener to the login button
    document.getElementById("loginForm").addEventListener("submit", handleLogin);
});
