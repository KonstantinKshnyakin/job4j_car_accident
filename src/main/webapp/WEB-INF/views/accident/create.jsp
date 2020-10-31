<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
            integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
            crossorigin="anonymous"></script>
    <title>Accident</title>
</head>
<body>

<form method='POST' action="<c:url value='/save'/>">
    <div class="form-group">
        <label>Name
            <input type="text" class="form-control" placeholder="Enter name" name="name">
        </label>
    </div>
    <div class="form-group">
        <label>Text
            <input type="text" class="form-control" placeholder="Enter text" name="text">
        </label>
    </div>
    <div class="form-group">
        <label>Address
            <input type="text" class="form-control" placeholder="Enter address" name="address">
        </label>
    </div>
    <div>
        <label>Тип
            <select class="custom-select mr-sm-2" name="type.id">
                <option selected>Выберите...</option>
                <c:forEach var="type" items="${types}">
                    <option value="${type.id}">${type.name}</option>
                    <%--                <option value="${type.id}">${type.name}</option>--%>
                </c:forEach>
            </select>
        </label>
    </div>
    <div>
        <label>Статьи:
            <select name="rIds" multiple class="form-control">
                <c:forEach var="rule" items="${rules}">
                    <option value="${rule.id}">${rule.name}</option>
                </c:forEach>
            </select>
        </label>
    </div>
    <br/>
    <button type="submit" class="btn btn-primary">Сохранить</button>
</form>
<br/>
<form method='GET' action="<c:url value='/'/>">
    <button type="submit" class="btn btn-primary">Вернутся</button>
</form>

</body>
</html>