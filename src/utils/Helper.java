package utils;

public class Helper {

    public static String getHTMLinFailedRegister(){
        String hhh= """
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Ошибка регистрации</title>
            <script>
                setTimeout(function() {
                    window.location.href = '/register';
                }, 3000);
            </script>
        </head>
        <body style="text-align:center; font-family:Arial, sans-serif;">
            <h2 style="color:red;">Ошибка: пользователь уже существует!</h2>
            <p>Вы будете перенаправлены обратно через 3 секунды...</p>
        </body>
        </html>
        """;
        return hhh;
    }
    public static String getHTMLNotAllData(){
        String hhh= """
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Ошибка регистрации</title>
            <script>
                setTimeout(function() {
                    window.location.href = '/register';
                }, 3000);
            </script>
        </head>
        <body style="text-align:center; font-family:Arial, sans-serif;">
            <h2 style="color:red;">Ошибка: не все данные были введены!</h2>
            <p>Вы будете перенаправлены обратно через 3 секунды...</p>
        </body>
        </html>
        """;
        return hhh;
    }
    public static String getSuccesHTML(){
        String hh = """
                <!DOCTYPE html>
                        <html lang="ru">
                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <title>Успешная регистрация</title>
                            <style>
                                body {
                                    font-family: Arial, sans-serif;
                                    background: #f4f4f4;
                                    display: flex;
                                    justify-content: center;
                                    align-items: center;
                                    height: 100vh;
                                    margin: 0;
                                }
                                .container {
                                    text-align: center;
                                    background: white;
                                    padding: 20px;
                                    border-radius: 8px;
                                    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                                }
                                h1 {
                                    color: #2ecc71;
                                }
                                .message {
                                    font-size: 16px;
                                    color: #333;
                                    margin-bottom: 20px;
                                }
                                .home-button {
                                    display: inline-block;
                                    padding: 10px 20px;
                                    background: #2ecc71;
                                    color: white;
                                    text-decoration: none;
                                    border-radius: 5px;
                                }
                                .home-button:hover {
                                    background: #27ae60;
                                }
                            </style>
                        </head>
                        <body>
                            <div class="container">
                                <h1>✅ Успех!</h1>
                                <p class="message">${message}</p>
                                <a href="/" class="home-button">На главную</a>
                            </div>
                        </body>
                        </html>
                        
                                
                """;
        return hh;
    }
    public static String getHTMLWrongPassword() {
        String html = """
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Ошибка входа</title>
        <script>
            setTimeout(function() {
                window.location.href = '/login';
            }, 3000);
        </script>
    </head>
    <body style="text-align:center; font-family:Arial, sans-serif;">
        <h2 style="color:red;">Ошибка: неверный пароль!</h2>
        <p>Вы будете перенаправлены обратно на страницу входа через 3 секунды...</p>
    </body>
    </html>
    """;
        return html;
    }

}
