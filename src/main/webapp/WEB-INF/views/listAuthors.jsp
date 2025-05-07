<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp" />

<h2>Authors List</h2>

<a href="<c:url value='/authors/add' />" class="btn">Add New Author</a>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Bio</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="author" items="${authors}">
            <tr>
                <td>${author.id}</td>
                <td>${author.name}</td>
                <td>${author.bio}</td>
                <td>
                    <a href="<c:url value='/authors/update/${author.id}' />" class="btn">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<jsp:include page="common/footer.jsp" />