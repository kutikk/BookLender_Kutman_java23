<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список книг</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>

<body class="bg-light">
    <div class="container py-5">
        <h1 class="text-center mb-4">📚 Список книг</h1>

        <div class="row g-4">
            <#list beforeBooks as book>
                <div class="col-md-4 col-sm-6">
                    <div class="card shadow-sm h-100">
                        <img src="${book.image?default('/images/book_placeholder.jpg')}" class="card-img-top" alt="Обложка книги" style="height: 250px; object-fit: cover;">
                        <div class="card-body text-center">
                            <h5 class="card-title">
                                <form action="/book" method="POST">
                                    <input type="hidden" name="bookId" value="${book.id}">
                                    <button type="submit" class="btn btn-link text-decoration-none p-0" style="font-size: 1.1rem;">
                                        ${book.title}
                                    </button>
                                </form>
                            </h5>
                            <p class="card-text"><strong>Автор:</strong> ${book.author}</p>
                            <p class="card-text"><strong>Статус:</strong> ${book.status}</p>
                        </div>
                        <div class="card-footer text-center bg-white">
                            <form action="/addBook" method="POST">
                                <input type="hidden" name="bookId" value="${book.id}">
                                <button type="submit" class="btn btn-success w-100">Добавить в список</button>
                            </form>
                        </div>
                    </div>
                </div>
            </#list>
        </div>


    </div>

</body>

</html>
