<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Houssem
  Date: 15/05/2019
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp" %>
<div class="row">
    <div class="col-md-8 m-auto">
        <h2 class="text-center"><a href="${entry.id}">${entry.title}</a></h2>
        <p>
            <b>Categories : </b> ${fn:join(entry.categories.toArray(),', ')}
        </p>
        <c:if test="${entry.published != null}">
            <p>
               (Publié le : ${entry.published})
            </p>
        </c:if>
        <c:if test="${entry.updated != null}">
            <p>
                (Mise à jour le : ${entry.updated})
            </p>
        </c:if>
        <c:if test="${entry.image!= null}">
            <div>
                <img class="img-thumbnail mx-auto" src="${entry.image.href}" alt="${entry.image.alt}" width="60%">
            </div>
        </c:if>
        <c:if test="${entry.content.href != null}">
            <a class="py-2" href="${entry.content.href}">${entry.content.href}</a>
        </c:if>
        <c:if test="${entry.content.text != null}">
            <p>${entry.content.text}</p>
        </c:if>
        <c:if test="${!empty entry.authors}">
           <div>
               <h5>Auteurs :</h5>
               <c:forEach items="${entry.authors}" var="author">
                   <p class="lead">
                       <c:choose>
                           <c:when test="${author.uri != null}">
                               <a href="${author.uri}">${author.name}</a>
                           </c:when>
                           <c:otherwise>
                               ${author.name}
                           </c:otherwise>
                       </c:choose>
                       <c:if test="${author.email != null}">
                           - ${author.email}
                       </c:if>
                   </p>
               </c:forEach>
           </div>
        </c:if>
        <c:if test="${!empty entry.contributors}">
            <div>
                <h5>Contributeurs :</h5>
                <c:forEach items="${entry.contributors}" var="contributor">
                    <p class="lead">
                            ${contributor.name} - ${contributor.email} - <a href="${contributor.uri}">${contributor.uri}</a>
                    </p>
                </c:forEach>
            </div>
        </c:if>
    </div>

</div>
<%@include file="footer.jsp" %>
