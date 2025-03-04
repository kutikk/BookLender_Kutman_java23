<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Профиль сотрудника</title>
    <link href="/css/formstyle.css" rel="stylesheet">
    <style>
        /* Добавление стилей для карточек книг */
        .book-card {
            border: 1px solid #ddd;
            border-radius: 10px;
            width: 200px;
            padding: 10px;
            margin: 10px;
            text-align: center;
            background-color: #f9f9f9;
        }

        .book-cover {
            width: 150px;
            height: 200px;
            object-fit: cover;
            border-radius: 8px;
        }

        .book-info {
            margin-top: 10px;
        }

        .book-title {
            font-weight: bold;
            font-size: 1.1em;
            margin: 5px 0;
        }

        .book-author {
            font-size: 1em;
            color: #555;
            margin: 5px 0;
        }

        .book-status {
            font-size: 0.9em;
            color: #777;
            margin: 5px 0;
        }

        .book-return-btn {
            margin-top: 10px;
            padding: 8px 15px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .book-return-btn:hover {
            background-color: #0056b3;
        }

        .books-grid {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }

        .profile-container {
            padding: 20px;
            text-align: center;
        }

        /* Дополнительные стили для общего вида */
        .books-section h3 {
            font-size: 1.5em;
            margin-bottom: 15px;
        }
    </style>
</head>

<body>
<div class="profile-container">
    <img src="${employee.avatar?default('/images/avatar_placeholder.jpg')}" alt="Аватар сотрудника">

    <h1>Добро пожаловать, ${employee.name}!</h1>

    <p><strong>Имя:</strong> ${employee.name}</p>
    <p><strong>Пароль:</strong> ${employee.password}</p>

    <div class="books-section">
        <h3>Текущие книги:</h3>
        <#if employee?? && employee.currentBooks?? && employee.currentBooks?size gt 0>
        <div class="books-grid">
            <#list employee.currentBooks as book>
            <div class="book-card">
                <img src="${book.image?default('/images/book_placeholder.jpg')}" alt="Обложка книги" class="book-cover">
                <div class="book-info">
                    <p class="book-title">${book.title}</p>
                    <p class="book-author">${book.author}</p>
                    <p class="book-status">${book.status}</p>
                </div>
                <form action="/returnBook" method="POST">
                    <input type="hidden" name="bookId" value="${book.id}">
                    <button type="submit" class="book-return-btn">Вернуть</button>
                </form>
            </div>
        </#list>
    </div>
    <#else>
    <p>Нет текущих книг</p>
</#if>
</div>
<div class="books-section">
    <h3>Прочитанные книги:</h3>
    <#if employee?? && employee.pastBooks?? && employee.pastBooks?size gt 0>
    <div class="books-grid">
        <#list employee.pastBooks as book>
        <div class="book-card">
            <img src="${book.image?default('/images/book_placeholder.jpg')}" alt="Обложка книги">
                <div class="book-info">
                <p class="book-title">${book.title}</p>
                <p class="book-author">${book.author}</p>
                <p class="book-status">${book.status}</p>
            </div>

        </div>
    </#list>
</div>
<#else>
<p>Нет текущих книг</p>
</#if>
</div>

<a href="/logout">Выйти</a>
</div>
</body>

</html>
