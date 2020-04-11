<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>HW4 - Percoski,Eric</title>

    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<h2 style="float: left; padding-left: 40%">Countries API</h2>
<form method ="post" action="/>save">
    <label title="Test">
        <textarea rows="5" cols="10" name="name">${name}</textarea>
    </label>
    <label>
        <textarea rows="5" cols="10" name="capital">${capital}</textarea>
    </label>
    <label>
        <textarea rows="5" cols="10" name="region">${region}</textarea>
    </label>
    <label>
        <textarea rows="5" cols="10" name="subregion">${subregion}</textarea>
    </label>
    <label>
        <textarea rows="5" cols="10" name="population">${population}</textarea>
    </label>
</form>


<table>
    <tr>
        <th>Country Name</th>
        <th>Capital</th>
        <th>Region</th>
        <th>Sub-Region</th>
        <th>Population</th>

    </tr>
    <c:forEach var="itemList" items="${itemList}">
        <tr>
            <td>${listitem.name}</td>
            <td>${listitem.description}</td>
            <td>${listitem.symptoms}</td>
            <td>${listitem.duration} days</td>
            <td>${listitem.mortal}%</td>
            <td>
                <img src="${listitem.image}" width="200" height="150"/>
            </td>


            <td></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>