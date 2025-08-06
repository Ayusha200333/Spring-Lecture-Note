$(document).ready(function () {
    const token = localStorage.getItem("accessToken");
    const username = localStorage.getItem("username");
    const role = localStorage.getItem("role");

    if (!token || !username || !role) {
        alert("You are not logged in. Redirecting to sign in...");
        window.location.href = "signin.html";
        return;
    }

    $(".welcome").text(`Welcome, ${username}!`);
    $(".role").text(`Role: ${role}`);

    if (role === "ADMIN") {
        $("#adminHello").show();
        $("#userHello").hide();
    } else if (role === "USER") {
        $("#userHello").show();
        $("#adminHello").hide();
    }

    function callHelloEndpoint(endpointId, apiPath) {
        $(endpointId).off("click").on("click", function () {
            $("#message").hide();
            $.ajax({
                url: `http://localhost:8080/hello/${apiPath}`,
                type: "GET",
                headers: {
                    Authorization: `Bearer ${token}`
                },
                success: function (data) {
                    $("#message").text(data).show();
                },
                error: function (xhr) {
                    if (xhr.status === 401) {
                        alert("Session expired or unauthorized. Please log in again.");
                        localStorage.clear();
                        window.location.href = "signin.html";
                    } else {
                        const errorMsg = xhr.responseJSON?.message || "Something went wrong.";
                        $("#message").text(`Error: ${errorMsg}`).show();
                    }
                }
            });
        });
    }

    callHelloEndpoint("#adminHello", "admin");
    callHelloEndpoint("#userHello", "user");

    $("#logoutBtn").on("click", function () {
        if (confirm("Are you sure you want to logout?")) {
            localStorage.clear();
            window.location.href = "signin.html";
        }
    });
});
