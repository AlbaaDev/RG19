<%--
  Created by IntelliJ IDEA.
  User: Houssem
  Date: 15/05/2019
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:eval var="base" expression="@commonProperties.urlbase"/>
<%@include file="header.jsp" %>
<h2 class="text-center">Les résumés des articles </h2>
<div class="row mt-4">
    <c:forEach items="${entries.resumes}" var="entry">
        <div class="col-md-3 card mx-2">
            <div class="card-body">
                <h3 class="card-title text-center">${entry.title}</h3>
                <p class="card-text text-muted"><b>Date : </b>${entry.date}</p>
                    <%--            <p class="card-text">${entry.id}</p>--%>
                <p class="card-text">
                    <b>Categories : </b> ${fn:join(entry.categories.toArray(),', ')}
                </p>
                <div class="text-center">
                    <a class="btn btn-primary" href="${base}resume/html/${entry.num}">voir détails</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<%@include file="footer.jsp" %>
