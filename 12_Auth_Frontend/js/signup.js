$("#showPassword").on("change", function() {
    const pwd = $("#password");
    if (this.checked) {
        pwd.attr("type", "text");
    } else {
        pwd.attr("type", "password");
    }
});

$("#signupForm").on("submit", function(e) {
    e.preventDefault();
    const username = $("#username").val().trim();
    const password = $("#password").val();
    const role = $("#role").val();

    if (!username || !password || !role) {
        alert("Please fill in all fields.");
        return;
    }

    $.ajax({
        url: "http://localhost:8080/auth/register",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({ username, password, role }),
        success: function(response) {
            alert(response.message || "Registered successfully!");
            window.location.href = "signin.html";
        },
        error: function(xhr) {
            const errorMsg = xhr.responseJSON?.message || "Registration failed.";
            alert(errorMsg);
        }
    });
});