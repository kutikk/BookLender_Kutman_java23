<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Вход</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-primary d-flex justify-content-center align-items-center min-vh-100">

    <div class="card shadow-sm w-100" style="max-width: 400px;">
        <div class="card-body text-center">
            <h2 class="card-title mb-4">Регистрация</h2>
            <form action="/register" method="post">
                <div class="mb-3">
                    <label for="user-email" class="form-label">Username</label>
                    <input type="text" name="username" id="user-email" class="form-control" placeholder="Ваш email" required autofocus>
                </div>
                <div class="mb-3">
                    <label for="user-password" class="form-label">Password</label>
                    <input type="password" name="password" id="user-password" class="form-control" placeholder="Ваш пароль" required>
                </div>

                <button class="btn btn-primary w-100" type="submit">Зарегистрироваться</button>
            </form>
        </div>
    </div>


</body>

</html>
