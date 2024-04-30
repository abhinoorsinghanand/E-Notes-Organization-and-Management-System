document.addEventListener("DOMContentLoaded", function() {
    // Your JavaScript code here
    function handleSignUp(event) {
        event.preventDefault();
    
        var name = document.getElementById("exampleInputName1").value.trim();
        var userName = document.getElementById("exampleInputEmail1").value.trim();
        var password = document.getElementById("exampleInputPassword1").value;
        var confirmPassword = document.getElementById("exampleInputConfirmPassword1").value;
    
        var nameRegex = /^[a-zA-Z\s]+$/; // letters and spaces only
        var usernameRegex = /^[a-zA-Z0-9_]+$/; // Letters, numbers, and underscores allowed
        var passwordRegex = /^(?=.*\d).{8,16}$/; // Minimum 8 characters, maximum 16 characters, at least 1 number
    
        if (!name) {
            alert("Name is required");
            console.log("name is working");
            return false; 
        } else if (!nameRegex.test(name)) {
            alert("Invalid name format");
            return false; 
        }
    
        if (!userName) {
            alert("Username is required");
            return false; 
        } else if (!usernameRegex.test(userName)) {
            alert("Invalid username format");
            return false; 
        }
    
        if (!password) {
            alert("Password is required");
            return false; 
        } else if (!passwordRegex.test(password)) {
            alert("Password must be 8-16 characters long and contain at least 1 number");
            return false; 
        }
    
        if (password !== confirmPassword) {
            alert("Passwords do not match");
            return false; 
        }
        return true; // Allow form submission
    }
    
    
    document.getElementById("signupForm").addEventListener("submit", handleSignUp);
    
    
});

