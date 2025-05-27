<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Budget Standard Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Budget Standard Form</h2>
    <form:form method="POST" modelAttribute="budgetStandard" action="/save" class="needs-validation" novalidate="true">
        <form:hidden path="id"/>

        <div class="mb-3">
            <label for="budgetperweek" class="form-label">Budget per Week</label>
            <form:input path="budgetperweek" class="form-control" required="true" type="number" step="0.01"/>
            <div class="invalid-feedback">Please enter a valid budget amount.</div>
        </div>

        <div class="mb-3">
            <label for="startdate" class="form-label">Start Date</label>
            <form:input path="startdate" class="form-control" type="date" required="true"/>
            <div class="invalid-feedback">Please select a start date.</div>
        </div>

        <div class="mb-3">
            <label for="enddate" class="form-label">End Date</label>
            <form:input path="enddate" class="form-control" type="date" required="true"/>
            <div class="invalid-feedback">Please select an end date.</div>
        </div>

        <div class="mb-3">
            <label for="lifestyle" class="form-label">Lifestyle</label>
            <form:select path="lifestyle" class="form-select" required="true">
                <form:option value="" label="-- Select Lifestyle --"/>
                <form:options items="${lifestyles}" itemValue="id" itemLabel="description"/>
            </form:select>
            <div class="invalid-feedback">Please select a lifestyle.</div>
        </div>

        <div class="mb-3">
            <label for="category" class="form-label">Category</label>
            <form:select path="category" class="form-select" required="true">
                <form:option value="" label="-- Select Category --"/>
                <form:options items="${categories}" itemValue="id" itemLabel="description"/>
            </form:select>
            <div class="invalid-feedback">Please select a category.</div>
        </div>

        <div class="mb-3">
            <label for="retirementtype" class="form-label">Retirement Type</label>
            <form:select path="retirementtype" class="form-select" required="true">
                <form:option value="" label="-- Select Retirement Type --"/>
                <form:options items="${retirementTypes}" itemValue="id" itemLabel="description"/>
            </form:select>
            <div class="invalid-feedback">Please select a retirement type.</div>
        </div>

        <div class="mb-3">
            <label for="item" class="form-label">Item</label>
            <form:select path="item" class="form-select" required="true">
                <form:option value="" label="-- Select Item --"/>
                <form:options items="${items}" itemValue="id" itemLabel="description"/>
            </form:select>
            <div class="invalid-feedback">Please select an item.</div>
        </div>

        <button type="submit" class="btn btn-primary">Save</button>
        <a href="/budgetstandards" class="btn btn-secondary">Cancel</a>
    </form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    // Form validation
    (function () {
        'use strict'
        var forms = document.querySelectorAll('.needs-validation')
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>
</body>
</html>