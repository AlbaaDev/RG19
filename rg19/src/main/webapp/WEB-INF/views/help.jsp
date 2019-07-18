<%--
  Created by IntelliJ IDEA.
  User: Houssem
  Date: 02/04/2019
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:eval var="base" expression="@commonProperties.urlbase"/>
<%@include file="header.jsp"%>
<img src="${base}public/img/logo.png" alt="logo">
<h1 align="center" > Projet REST RG19 </h1>
<h5>Liste des commandes disponibles :</h5>
<table class="table table-bordered">
    <thead class="thead-dark" >
    <tr>
        <th scope="col" >URL</th><th scope="col" >Méthode</th><th scope="col" >Flux</th><th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            ${base}
        </td>
        <td>
            GET
        </td>
        <td>text/html</td>
        <td>
            Retourner la page d’accueil avec un message identifiant le projet
        </td>
    </tr>
    <tr>
        <td>
            ${base}help
        </td>
        <td>
            GET
        </td>
        <td>
            text/html
        </td>
        <td>
            Retourner la page d'aide avec la liste des commandes disponibles (cad le contenu de ce tableau)
        </td>
    </tr>
    <tr>
        <td>
            ${base}resume/html
        </td>
        <td>
            GET
        </td>
        <td>
            text/html
        </td>
        <td>
            Retourner la liste des résumés des articles rg19 avec les informations suivantes :
            <ul>
                <li>titre de l’article</li>
                <li>date</li>
                <li>catégorie</li>
            </ul>
            Chaque article comporte un identifiant {id} numérique unique
        </td>
    </tr>
    <tr>
        <td>
            ${base}resume/html?query={term}
        </td>
        <td>
            GET
        </td>
        <td>
            text/html
        </td>
        <td>
            Retourner la liste des résumés des articles rg19 qui ont la catègorie {term} avec les informations suivantes :
            <ul>
                <li>titre de l’article</li>
                <li>date</li>
                <li>catégorie</li>
            </ul>
            Chaque article comporte un identifiant {id} numérique unique
        </td>
    </tr>
    <tr>
        <td>
            ${base}resume/xml
        </td>
        <td>
            GET
        </td>
        <td>
            application/xml
        </td>
        <td>
            Retourner la liste des résumés des articles rg19 avec les informations suivantes :
            <ul>
                <li>titre de l’article</li>
                <li>date</li>
                <li>catégorie</li>
            </ul>
            Chaque article comporte un identifiant {id} numérique unique
        </td>
    </tr>
    <tr>
        <td>
            ${base}resume/xml?query={term}
        </td>
        <td>
            GET
        </td>
        <td>
            application/xml
        </td>
        <td>
            Retourner la liste des résumés des articles rg19 qui ont la catègorie {term} avec les informations suivantes :
            <ul>
                <li>titre de l’article</li>
                <li>date</li>
                <li>catégorie</li>
            </ul>
            Chaque article comporte un identifiant {id} numérique unique
        </td>
    </tr>
    <tr>
        <td>${base}resume/html/{id}</td>
        <td>GET</td>
        <td>
            text/html
        </td>
        <td>Retourner le détail de l’article dont l’identifiant est {Id}</td>
    </tr>
    <tr>
        <td>${base}resume/xml/{id}</td>
        <td>GET</td>
        <td>application/xml</td>
        <td>Retourner le détail de l’article dont l’identifiant est {Id}</td>
    </tr>
    <tr>
        <td>${base}insert</td>
        <td>POST</td>
        <td>application/xml</td>
        <td>
            Recevoir un flux des articles, créer l'objet correspondant et
            retourner un message de succès ou d'echecs de l'insertion .
        </td>
    </tr>
    <tr>
        <td>${base}delete/{id}</td>
        <td>DELETE</td>
        <td>application/xml</td>
        <td>Supprimer l’article dont l’identifiant est {Id}</td>
    </tr>
    <tr>
        <td>${base}update</td>
        <td>PUT</td>
        <td>application/xml</td>
        <td>Mettre à jour les articles de flux</td>
    </tr>
    </tbody>
</table>
<%@include file="footer.jsp"%>