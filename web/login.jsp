<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Flower Paradise</title>
    <link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" href="assets/css/components.css">
</head>
<body>
    <div class="modal-content" style="margin-top: 5rem;">
        <h2 style="color: var(--primary-maroon); margin-bottom: 1.5rem;">Login</h2>
        <form id="loginForm">
            <div class="form-group">
                <label for="loginEmail">Email:</label>
                <input type="email" id="loginEmail" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="loginPassword">Password:</label>
                <input type="password" id="loginPassword" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary" style="width: 100%;">
                <span class="login-text">Login</span>
                <span class="loading" style="display: none;"></span>
            </button>
        </form>
    </div>

    <script src="assets/js/app.js"></script>
</body>
</html>
