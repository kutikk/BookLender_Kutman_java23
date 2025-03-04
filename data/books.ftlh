<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
        name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>Freemarker Sample Page</title>
    <link href="/css/bookStyle.css" rel="stylesheet">
    <style>
        .book-list {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
            gap: 20px;
            padding: 20px;
        }

        .book-item {
            border: 1px solid #ddd;
            padding: 15px;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            text-align: center;
            background-color: #fff;
        }

        .book-item h2 {
            font-size: 1.2em;
            margin-bottom: 10px;
        }

        .book-item p {
            margin: 5px 0;
        }

        .book-item img {
            width: 100%;
            height: auto;
            max-height: 200px;
            object-fit: cover;
            margin-bottom: 15px;
        }

        .button-container {
            text-align: center;
            margin-top: 30px;
        }

        .btn {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin: 10px;
            display: inline-block;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        .btn-primary {
            background-color: #28a745;
        }

        .btn-primary:hover {
            background-color: #218838;
        }

    </style>
</head>

<body>
    <div class="book-list">
        <#list beforeBooks as book>
            <div class="book-item">
                <h2>${book.title}</h2>
                <p>Автор: ${book.author}</p>
                <p>Статус: ${book.status}</p>
                <img src="${book.image?default('/images/book_placeholder.jpg')}" alt="Обложка книги">
                <form action="/addBook" method="POST">
                    <input type="hidden" name="bookId" value="${book.id}">
                    <button type="submit" class="btn btn-primary">Добавить в список</button>
                </form>

            </div>
        </#list>
    </div>
    <div class="button-container">
        <a href="/info" class="btn btn-primary">Больше информации о книгах</a>
        <a href="/login" class="btn btn-primary">Сотрудник</a>
    </div>
</body>

</html>
