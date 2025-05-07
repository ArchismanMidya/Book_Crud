<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="common/header.jsp" />

<h2>Books with Authors</h2>

<table>
    <thead>
        <tr>
            <th>Title</th>
            <th>ISBN</th>
            <th>Author</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="bookWithAuthor" items="${booksWithAuthors}">
            <tr>
                <td>${bookWithAuthor[0]}</td> <!-- Title -->
                <td>${bookWithAuthor[1]}</td> <!-- ISBN -->
                <td>${bookWithAuthor[2]}</td> <!-- Author Name -->
            </tr>
        </c:forEach>
    </tbody>
</table>

<a href="<c:url value='/books' />" class="btn">Back to Books</a>

<jsp:include page="common/footer.jsp" />