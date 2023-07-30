<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/jsp/members/save.jsp" method="post">
    <label>
        username: <input name="username" type="text"/>
    </label>
    <label>
        age: <input name="age" type="text"/>
    </label>
    <button type="submit">전송</button>
</form>
</body>
</html>
