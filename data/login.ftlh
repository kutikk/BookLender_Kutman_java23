<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Вход</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light d-flex justify-content-center align-items-center" style="height: 100vh; margin: 0;">

    <div class="card shadow-sm w-100" style="max-width: 400px;">
        <div class="card-body">
            <h2 class="card-title text-center mb-4">Вход</h2>
            <form action="/login" method="post">
                <div class="mb-3">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" id="username" name="username" class="form-control" placeholder="Введите ваше имя пользователя" required autofocus>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" id="password" name="password" class="form-control" placeholder="Введите ваш пароль" required>
                </div>
                <button class="btn btn-success w-100" type="submit">Войти</button>
            </form>
            <div class="text-center mt-3">
                <a href="#" class="text-decoration-none text-success">Забыли пароль?</a>
            </div>
        </div>
    </div>

</body>

</html>
