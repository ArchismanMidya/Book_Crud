<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="common/header.jsp" />

<h2>Add New Author</h2>

<form:form action="/authors/add" method="post" modelAttribute="author">
    <div class="form-group">
        <form:label path="name">Name</form:label>
        <form:input path="name" required="true" />
    </div>
    <div class="form-group">
        <form:label path="bio">Bio</form:label>
        <form:textarea path="bio" rows="5" />
    </div>
    <button type="submit" class="btn">Save Author</button>
    <a href="<c:url value='/authors' />" class="btn">Cancel</a>
</form:form>

<jsp:include page="common/footer.jsp" />