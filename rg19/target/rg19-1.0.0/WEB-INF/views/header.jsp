<%--
  Created by IntelliJ IDEA.
  User: Houssem
  Date: 18/05/2019
  Time: 02:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:eval var="base" expression="@commonProperties.urlbase"/>

<!doctype html>
<html lang="fr" >
<head>
    <!-- Required meta tags -->
    <link rel="icon" type="image/png" href="${base}public/img/logo.png" />
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>${title}</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%@include file="nav.jsp" %>
<div class="container mt-4 mb-5">