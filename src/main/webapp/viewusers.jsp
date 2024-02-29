<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Users</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        h1 {
            color: #333;
        }

        table {
            width: 90%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<%@page import="Dao.UserDao,bean.*,java.util.*"%>
<%@ page import="Service.UserService" %>
<%@ page import="Implementation.UserImpl" %>
<%@ page import="Controller.HibernateUtil" %>

<h1>Users List</h1>

<%
    UserService services ;
    services =new UserImpl(HibernateUtil.getSessionFactory());

    List<User> list=services.listAllUsers();
    request.setAttribute("list",list);
%>

<table border="1" width="90%">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Password</th>
        <th>Email</th>
        <th>Sex</th>
        <th>Country</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <% for(User u :list){ %>
    <tr>
        <td><%=u.getId()%></td>
        <td><%=u.getName()%></td>
        <td><%=u.getPassword()%></td>
        <td><%=u.getEmail()%></td>
        <td><%=u.getSex()%></td>
        <td><%=u.getCountry()%></td>
        <td><a href="editform.jsp?id=<%=u.getId()%>">Edit</a></td>
        <td><a href="deleteuser.jsp?id=<%=u.getId()%>">Delete</a></td>
    </tr>
    <% }
    %>
</table>

<br/><a href="adduserform.jsp">Add New User</a>

</body>
</html>
