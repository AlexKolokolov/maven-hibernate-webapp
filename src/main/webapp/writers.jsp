<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 09.12.2015
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title>Writers</title>
</head>
    <body>
        <h2>Выберите писателя</h2>
        <p>
            <table>
                <c:forEach items="${writers}" var="writer">
                    <tr>
                        <td><a href="/booklib/books?author_id=${writer.id}">${writer.id} ${writer.nameRus} (${writer.nameEn})</a></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td><a href="/booklib/books?author_id=0">Все авторы</a></td>
                </tr>
            </table>
        </p>
    </body>
</html>
