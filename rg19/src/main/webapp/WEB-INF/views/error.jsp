<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:eval var="base" expression="@commonProperties.urlbase"/>
<%--
  Created by IntelliJ IDEA.
  User: Houssem
  Date: 26/03/2019
  Time: 02:51
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <base href="${base}">
    <link rel="icon" type="image/png" href="${base}public/img/logo.png" />
    <link rel="stylesheet" href="${base}public/css/notFoundPageStyle.css">
    <title>Not Found</title>
</head>
<body>
<div id="clouds">
    <div class="cloud x1"></div>
    <div class="cloud x1_5"></div>
    <div class="cloud x2"></div>
    <div class="cloud x3"></div>
    <div class="cloud x4"></div>
    <div class="cloud x5"></div>
</div>
<div class='c'>
    <div class='_404'>404</div>
    <hr>
    <div class='_1'>REST RG19</div>
    <div class='_2'>La Page Demandé Est Introuvable</div>
    <a class='btn' href='${base}'>Acceuil</a>
</div>
</body>
</html>
