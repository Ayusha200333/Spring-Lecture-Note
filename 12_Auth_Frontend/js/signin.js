$("#showPassword").on("change", function() {
    const pwd = $("#password");
    if (this.checked) {
        pwd.attr("type", "text");
    } else {
        pwd.attr("type", "password");
    }
});

$("#signinForm").on("submit", function(e) {
    e.preventDefault();
    const username = $("#username").val().trim();
    const password = $("#password").val();

    if (!username || !password) {
        alert("Please fill in all fields.");
        return;
    }

    $.ajax({
        url: "http://localhost:8080/auth/login",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({ username, password }),
        success: function(response) {
            const data = response.data || {};
            const token = data.accessToken;
            const role = data.role;
            const userName = data.username || data.userName || username;

            if (!token || !role) {
                alert("Login successful, but missing token or role.");
                return;
            }

            localStorage.setItem("accessToken", token);
            localStorage.setItem("username", userName);
            localStorage.setItem("role", role);

            alert("Login successful!");
            window.location.href = "dashboard.html";
        },
        error: function(xhr) {
            let errorMsg = "Login failed. Please try again.";
            if (xhr.responseJSON && xhr.responseJSON.message) {
                errorMsg = xhr.responseJSON.message;
            }
            if (xhr.status === 401 || xhr.status === 403) {
                alert("Username or password incorrect. Please try again.");
            } else if (xhr.status === 404) {
                alert("User not found. Redirecting to signup...");
                setTimeout(() => window.location.href = "signup.html", 1500);
            } else {
                alert(errorMsg);
            }
        }
    });
});