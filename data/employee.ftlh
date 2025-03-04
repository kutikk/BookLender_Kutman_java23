<!doctype html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Читатель | Библиотека</title>
    <link href="/css/styles.css" rel="stylesheet">
</head>

<body>
    <div class="container">
        <div class="employee-info">
            <div class="employee-card">
                <#if Employee?? && Employee.avatar??>
                    <img src="${Employee.avatar}" alt="Аватар сотрудника" class="employee-avatar">
                <#else>
                    <p>Аватар не загружен</p>
                </#if>
                <h2>${Employee.name}</h2>
            </div>
        </div>

           <div class="books-section">
            <h3>Текущие книги:</h3>
            <#if Employee?? && Employee.currentBooks?? && Employee.currentBooks?size gt 0>
                <div class="books-grid">
                    <#list Employee.currentBooks as book>
                        <div class="book-card">

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

        <div class="books-section">
            <h3>Ранее прочитанные книги:</h3>
            <#if Employee?? && Employee.pastBooks?? && Employee.pastBooks?size gt 0>
                <div class="books-grid">
                    <#list Employee.pastBooks as book>
                        <div class="book-card">
                            <img src="${book.image}" alt="Обложка книги" class="book-cover">
                            <div class="book-info">
                                <p class="book-title">${book.title}</p>
                                <p class="book-author">${book.author}</p>
                                 <p class="book-status">${book.status}</p>

                            </div>
                        </div>
                    </#list>
                </div>
            <#else>
                <p>Нет ранее прочитанных книг</p>
            </#if>
        </div>
    </div>
</body>

</html>
