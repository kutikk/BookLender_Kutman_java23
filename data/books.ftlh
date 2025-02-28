<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
        name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>Freemarker Sample Page</title>
    <link href="/css/bookStyle.css" rel="stylesheet">
</head>
</head>

<body>
 <div class="book-list">
     <#list beforeBooks as book>
         <div class="book-item">
             <h2>${book.title}</h2>
             <p>Автор: ${book.author}</p>
             <p>Статус: ${book.status}</p>
             <img src="${book.image}" alt="Обложка книги">
         </div>
     </#list>
 </div>
 <div class="button-container">
         <a href="/info" class="btn btn-primary">Больше информации о книгах</a>
         <a href="/employee" class="btn btn-primary">Сотрудник</a>
     </div>
</body>

</html>