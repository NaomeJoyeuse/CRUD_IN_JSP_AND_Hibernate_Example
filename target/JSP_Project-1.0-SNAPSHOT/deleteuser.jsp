<%@page import="Dao.UserDao"%>
<%@ page import="Service.UserService" %>
<%@ page import="Implementation.UserImpl" %>
<%@ page import="Controller.HibernateUtil" %>
<%@ page import="bean.User" %>
<jsp:useBean id="u" class="bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<%

  UserService services ;
  services =new UserImpl(HibernateUtil.getSessionFactory());

  User users=services.deleteUsers(u);

  response.sendRedirect("viewusers.jsp");
%>