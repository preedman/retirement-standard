<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to Retirement Planning</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-8 offset-md-2">
            <h1 class="mb-4">Welcome to Retirement Planning</h1>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Hello ${name}</h5>
                    <p class="card-text">Please choose from the following resources:</p>
                    <div class="list-group">
                        <a href="budgetstandards" class="list-group-item list-group-item-action">
                            <i class="bi bi-calculator"></i> View Retirement Budget Standards
                        </a>
                        <a href="https://www.superannuation.asn.au/resources/retirement-standard"
                           class="list-group-item list-group-item-action"
                           target="_blank">
                            <i class="bi bi-box-arrow-up-right"></i> ASFA Retirement Standard Resources
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>