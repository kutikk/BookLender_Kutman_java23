<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Профиль сотрудника</title>
    <link href="/css/formstyle.css" rel="stylesheet">

</head>
<body>
<div class="profile-container">
    <img src="${employee.avatar?default('/images/avatar_placeholder.jpg')}" alt="Аватар сотрудника">

    <h1>Добро пожаловать, ${employee.name}!</h1>

    <p><strong>Имя:</strong> ${employee.name}</p>
    <p><strong>Пароль:</strong> ${employee.password}</p>

    <h2>Текущие книги:</h2>
    <#if employee.currentBooks?? && employee.currentBooks?size > 0>
        <ul>
            <#list employee.currentBooks as book>
                <li>${book.title}</li>
            </#list>
        </ul>
    <#else>
        <p>Нет текущих книг</p>
    </#if>

    <a href="/logout">Выйти</a>
</div>
</body>
</html>
