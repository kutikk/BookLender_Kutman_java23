<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
          name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>Freemarker Sample Page</title>
    <link href="forms.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <div class="box">
     <#if Garri??>
          <img src="${Garri.image}" alt="Обложка книги">
     </#if>
  </div>
    <div class="box">
    <#if Garri??>
            <p>Название: ${Garri.title}<br>Автор: ${Garri.author}</p>

        </#if>
    </div>
    <div class="box">
    <#if Garri??>
    Статус : ${Garri.status}
     </#if>

    </div>
</div>
</body>
</html>