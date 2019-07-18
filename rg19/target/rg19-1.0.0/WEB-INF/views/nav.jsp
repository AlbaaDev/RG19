<%--
  Created by IntelliJ IDEA.
  User: Houssem
  Date: 17/05/2019
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<!-- Fixed navbar -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:eval var="base" expression="@commonProperties.urlbase"/>
<nav class="navbar navbar-expand-md sticky-top navbar-dark bg-dark">
    <a class="navbar-brand" href="#">REST API RG19</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item<c:if test="${page == null}"> active</c:if>">
                <a class="nav-link" href="${base}">Accueil </a>
            </li>
            <li class="nav-item<c:if test="${page == 'resume'}"> active</c:if>">
                <a class="nav-link" href="${base}resume/html">Résumé</a>
            </li>
            <li class="nav-item<c:if test="${page == 'help'}"> active</c:if>">
                <a class="nav-link" href="${base}help" >Aide</a>
            </li>
        </ul>
    </div>
</nav>