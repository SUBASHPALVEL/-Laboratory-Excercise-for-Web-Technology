document.getElementById("registrationForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent form submission

    // Reset error messages
    document.getElementById("usernameError").textContent = "";
    document.getElementById("emailError").textContent = "";
    document.getElementById("passwordError").textContent = "";

    // Get form values
    var username = document.getElementById("username").value.trim();
    var email = document.getElementById("email").value.trim();
    var password = document.getElementById("password").value;

    // Validate form fields
    var isValid = true;
    if (username === "") {
        document.getElementById("usernameError").textContent = "Username is required";
        isValid = false;
    }
    if (email === "") {
        document.getElementById("emailError").textContent = "Email is required";
        isValid = false;
    } else if (!validateEmail(email)) {
        document.getElementById("emailError").textContent = "Invalid email format";
        isValid = false;
    }
    if (password === "") {
        document.getElementById("passwordError").textContent = "Password is required";
        isValid = false;
    }

    if (isValid) {
        // Perform registration logic
        alert("Registration successful!");
        // Additional code to handle registration process
    }
});

document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent form submission

    // Reset error messages
    document.getElementById("loginUsernameError").textContent = "";
    document.getElementById("loginPasswordError").textContent = "";

    // Get form values
    var username = document.getElementById("loginUsername").value.trim();
    var password = document.getElementById("loginPassword").value;

    // Validate form fields
    var isValid = true;
    if (username === "") {
        document.getElementById("loginUsernameError").textContent = "Username is required";
        isValid = false;
    }
    if (password === "") {
        document.getElementById("loginPasswordError").textContent = "Password is required";
        isValid = false;
    }

    if (isValid) {
        // Perform login logic
        alert("Login successful!");
        // Additional code to handle login process
    }
});

document.getElementById("profileForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent form submission

    // Reset error messages
    document.getElementById("fullNameError").textContent = "";
    document.getElementById("addressError").textContent = "";

    // Get form values
    var fullName = document.getElementById("fullName").value.trim();
    var address = document.getElementById("address").value.trim();

    // Validate form fields
    var isValid = true;
    if (fullName === "") {
        document.getElementById("fullNameError").textContent = "Full Name is required";
        isValid = false;
    }
    if (address === "") {
        document.getElementById("addressError").textContent = "Address is required";
        isValid = false;
    }

    if (isValid) {
        // Perform profile update logic
        alert("Profile updated successfully!");
        // Additional code to handle profile update process
    }
});

document.getElementById("paymentForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent form submission

    // Reset error messages
    document.getElementById("cardNumberError").textContent = "";
    document.getElementById("expiryDateError").textContent = "";

    // Get form values
    var cardNumber = document.getElementById("cardNumber").value.trim();
    var expiryDate = document.getElementById("expiryDate").value.trim();

    // Validate form fields
    var isValid = true;
    if (cardNumber === "") {
        document.getElementById("cardNumberError").textContent = "Card Number is required";
        isValid = false;
    }
    if (expiryDate === "") {
        document.getElementById("expiryDateError").textContent = "Expiry Date is required";
        isValid = false;
    }

    if (isValid) {
        // Perform payment logic
        alert("Payment successful!");
        // Additional code to handle payment process
    }
});

// Email validation helper function
function validateEmail(email) {
    var re = /\S+@\S+\.\S+/;
    return re.test(email);
}
