<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register - Flower Paradise</title>
    <link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" href="assets/css/components.css">
</head>
<body>
    <div class="modal-content" style="margin-top: 5rem;">
        <h2 style="color: var(--primary-maroon); margin-bottom: 1.5rem;">Daftar Akun Baru</h2>
        <form id="registerForm">
            <div class="form-group">
                <label for="registerName">Nama Lengkap:</label>
                <input type="text" id="registerName" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="registerEmail">Email:</label>
                <input type="email" id="registerEmail" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="registerPhone">Nomor Telepon:</label>
                <input type="tel" id="registerPhone" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="registerPassword">Password:</label>
                <input type="password" id="registerPassword" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary" style="width: 100%;">
                Daftar Sekarang
            </button>
        </form>
    </div>

    <script src="assets/js/app.js"></script>
</body>
</html>
