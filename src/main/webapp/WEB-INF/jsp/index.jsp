<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>HW4 - Percoski,Eric</title>

    <style>
        div{
            float: left;
            display: inline-block;
        }
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
        <h2 style="float: left; padding-left: 40%">Countries API</h2>

</head>
<div>
    <div>
<body>
    <div>
<form method ="post" action="/push">
    <div>
        <textarea rows="5" cols="10" name="name">${name}</textarea>
        <div>
            <textarea rows="5" cols="10" name="capital">${capital}</textarea>
        </div>
    </div>

        <textarea rows="5" cols="10" name="region">${region}</textarea>
        <textarea rows="5" cols="10" name="subregion">${subregion}</textarea>
        <textarea rows="5" cols="10" name="population">${population}</textarea>

    <button type="submit" style="height: 35px; width: 100px;">SUBMIT AND LOAD DB</button>
</form>
    </div>
</body>
    </div>
<table>
    <tr>
        <th>Country Name</th>
        <th>Capital</th>
        <th>Region</th>
        <th>Sub-Region</th>
        <th>Population</th>
        <th>Actions</th>


    </tr>
    <c:forEach var="itemList" items="${itemList}">
        <tr>
            <td>${itemList.name}</td>
            <td>${itemList.capital}</td>
            <td>${itemList.region}</td>
            <td>${itemList.subregion}</td>
            <td>${itemList.population}</td>
            <td>
                <a href="/delete/${itemList.id}">DELETE</a>
            </td>


            <td></td>
        </tr>
    </c:forEach>
</table>
</div>
</html>