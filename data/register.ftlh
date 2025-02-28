<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <link rel="stylesheet" href="css/forms.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #6a11cb, #2575fc);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        main {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
            text-align: center;
            width: 350px;
        }

        fieldset {
            border: none;
            padding: 0;
            margin: 0;
        }

        .legend p {
            font-size: 24px;
            font-weight: bold;
            color: #333;
        }

        .form-element {
            margin: 15px 0;
        }

        label {
            display: block;
            font-size: 14px;
            color: #666;
            margin-bottom: 5px;
            text-align: left;
        }

        input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        input:focus {
            border-color: #2575fc;
            outline: none;
            box-shadow: 0 0 5px rgba(37, 117, 252, 0.5);
        }

        .hr-line {
            margin: 20px 0;
            font-size: 14px;
            color: #777;
        }

        .register-button {
            background: #2575fc;
            color: white;
            border: none;
            padding: 12px;
            width: 100%;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background 0.3s;
        }

        .register-button:hover {
            background: #1b5fd8;
        }

        img {
            display: block;
            margin: 10px auto;
            width: 150px;
            height: 150px;
            border-radius: 10px;
        }
    </style>
</head>

<body>
    <main>
        <form action="/register" method="post">
            <fieldset>
                <div class="legend">
                    <p>Welcome!</p>
                    <img src="/images/1.jpg" alt="coins">
                </div>
                <div class="form-element">
                    <label for="username">Username</label>
                    <input type="text" name="username" id="user-email" placeholder="Your email" required autofocus>
                </div>
                <div class="form-element">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="user-password" placeholder="Your password" required>
                </div>
                <div class="hr-line">
                    <span class="details">One more step to go</span>
                </div>
                <div class="form-element">
                    <button class="register-button" type="submit">Login</button>
                </div>
            </fieldset>
        </form>
    </main>
</body>

</html>
