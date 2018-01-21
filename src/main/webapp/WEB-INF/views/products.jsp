<%--
  Created by IntelliJ IDEA.
  User: SMEY
  Date: 1/16/2018
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: SMEY
  Date: 1/12/2018
  Time: 8:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.mysql.jdbc.ConnectionFeatureNotAvailableException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<center>
    <h3>Add / Edit Product!!!</h3>

    <%--@elvariable id="product" type=""--%>
    <form:form method="post" action="/product" commandName="product">
        <div class="table-responsive">
            <table class="table table-bordered" style="width: 300px">



                <tr>
                    <td>Id :</td>
                    <td><form:input type="text" path="id" /></td>
                </tr>
                <tr>
                    <td>Name :</td>
                    <td><form:input type="text" path="name" /></td>
                </tr>
                <tr>
                    <td>Qty :</td>
                    <td><form:input type="text" path="qty" /></td>
                </tr>
                <tr>
                    <td>UnitPrice :</td>
                    <td><form:input type="text" path="unitprice" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="btn btn-primary btn-sm" type="submit" value="Submit" /></td>
                </tr>


            </table>




        </div>




    </form:form>


    <form  method="get">

        <input type="text"  id="search" name="search" placeholder="search data by name"/>
        <%--<button type="submit" value="Search">Search</button>--%>


    </form>



    <br>
    <br>
    <h3>List of Products</h3>
    <table class="table table-bordered" style="width: 300px">



        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Qty</th>
            <th>UnitPrice</th>
            <th>Edit/Delete</th>
        </tr>
        <c:forEach items="${productList}" var="product">

            <tr>
                <td width="60" align="center">${product.id}</td>
                <td width="60" align="center">${product.name}</td>
                <td width="60" align="center">${product.qty}</td>
                <td width="60" align="center">${product.unitprice}</td>
                <td width="60" align="center"><a href="edit/${product.id}">Edit</a>/<a href="delete/${product.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <%
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
            String query="select * from product where name like'%"+request.getParameter("search")+"%'";

            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(query);

            while (rs.next())
            {
    %>
    <table>
    <tr>
        <td><%=rs.getInt("id")%></td>
        <td><%=rs.getString("name")%></td>
        <td><%=rs.getFloat("qty")%></td>
        <td><%=rs.getFloat("unitprice")%></td>


    </tr>

    </table>
    <%
            }



        }catch (Exception ex)
        {

        }
    %>

</center>
</body>
</html>