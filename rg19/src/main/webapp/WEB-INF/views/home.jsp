<%--
  Created by IntelliJ IDEA.
  User: Houssem
  Date: 02/04/2019
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%! DateFormat fmt = new SimpleDateFormat("dd/MM/YYYY"); String now = fmt.format(new Date()); %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:eval var="base" expression="@commonProperties.urlbase"/>
<%@include file="header.jsp"%>
    <img src="${base}public/img/logo.png" alt="logo">
    <h1 align="center" > Projet REST RG19 </h1>
    <p><b>version  : </b> 1.0.0</p>
    <p><b>Date de dernière Mise a jour : </b><u><%=now%></u> </p>
    <h5>Auteurs : </h5>
    <p class="ml-2">AYOUB Housem</p>
    <p class="ml-2">FAZLIU Arber</p>

<%@include file="footer.jsp"%>
