<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp" />

<h2>Books List</h2>

<a href="<c:url value='/books/add' />" class="btn">Add New Book</a>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>ISBN</th>
            <th>Author</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.isbn}</td>
                <td>${book.author.name}</td>
                <td>
                    <a href="<c:url value='/books/update/${book.id}' />" class="btn">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<jsp:include page="common/footer.jsp" />