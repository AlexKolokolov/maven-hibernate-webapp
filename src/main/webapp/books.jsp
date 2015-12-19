<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 08.12.2015
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Books</title>
    </head>
    <body>
        <h2>Books</h2>
        <p>
            <table>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.writer.nameRus} (${book.writer.nameEn})</td>
                        <td>${book.titleRus} (${book.titleEn})</td>
                    </tr>
                </c:forEach>
            </table>
        </p>
    </body>
</html>
