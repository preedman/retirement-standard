<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
    <a class="navbar-brand m-1" target="_blank" href="https://sites.google.com/reedmanit.com/software/home">ReedmanIT</a>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="https://www.superannuation.asn.au/resources/retirement-standard">ASFA Retirement Standard</a></li>
            <li class="nav-item"><a class="nav-link" href="/create">New</a></li>
        </ul>
    </div>
    <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
    </ul>
</nav>
<head>
    <title>Budget Standards</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="mb-4">AFSA Retirement Standard for retirees 65 - 84. September Qtr 2024</h2>

    <!-- Enhanced Filter Section -->
    <div class="row mb-4">
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Filter Options</h5>
                    <form id="filterForm" class="mt-3">
                        <!-- Lifestyle Filter -->
                        <div class="mb-3">
                            <label for="lifestyleFilter" class="form-label">Lifestyle</label>
                            <select class="form-select" id="lifestyleFilter" name="lifestyleId">
                                <option value="">All Lifestyles</option>
                                <c:forEach items="${lifestyles}" var="lifestyle">
                                    <option value="${lifestyle.id}" ${lifestyle.id == selectedLifestyle ? 'selected' : ''}>
                                            ${lifestyle.description}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <!-- Category Filter -->
                        <div class="mb-3">
                            <label for="categoryFilter" class="form-label">Category</label>
                            <select class="form-select" id="categoryFilter" name="categoryId">
                                <option value="">All Categories</option>
                                <c:forEach items="${categories}" var="category">
                                    <option value="${category.id}" ${category.id == selectedCategory ? 'selected' : ''}>
                                            ${category.description}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <!-- Retirement Type Filter -->
                        <div class="mb-3">
                            <label for="retirementTypeFilter" class="form-label">Retirement Type</label>
                            <select class="form-select" id="retirementTypeFilter" name="retirementTypeId">
                                <option value="">All Retirement Types</option>
                                <c:forEach items="${retirementTypes}" var="type">
                                    <option value="${type.id}" ${type.id == selectedRetirementType ? 'selected' : ''}>
                                            ${type.description}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>

                        <!-- Apply Filters Button -->
                        <button type="button" class="btn btn-primary" onclick="submitFilter()">Apply Filters</button>
                        <button type="button" class="btn btn-secondary" onclick="resetFilters()">Reset</button>

                        <!-- Hidden fields for pagination -->
                        <input type="hidden" name="page" value="0">
                        <input type="hidden" name="size" value="${param.size}">
                    </form>
                </div>
            </div>
        </div>

        <!-- Table Section -->
        <div class="col-md-8">
            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover">
                    <thead class="table-dark">
                    <tr>
                    <!--    <th>ID</th>  -->
                    <!--    <th>Budget Per Week</th> -->
                    <!--<th>Start Date</th>  -->
                    <!--<th>End Date</th> -->
                        <th>Category</th>
                        <th>Item</th>
                        <th>Lifestyle</th>
                        <th>Retirement Type</th>
                        <th>Budget Per Week</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${budgetStandards}" var="budget">
                        <tr>
                         <!--   <td>${budget.id}</td> -->

                         <!--   <td><fmt:formatDate value="${budget.startdate}" pattern="MM/dd/yyyy"/></td> -->
                         <!--   <td><fmt:formatDate value="${budget.enddate}" pattern="MM/dd/yyyy"/></td> -->
                            <td>${budget.category.description}</td>
                            <td>${budget.item.description}</td>
                            <td>${budget.lifestyle.description}</td>
                            <td>${budget.retirementtype.description}</td>
                            <td><fmt:formatNumber value="${budget.budgetperweek}" type="currency" currencySymbol="$"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <!-- Pagination Controls -->
            <div class="d-flex justify-content-between align-items-center mt-4">
                <div class="d-flex align-items-center">
                    <span class="me-2">Show</span>
                    <select class="form-select form-select-sm w-auto" onchange="changePageSize(this.value)">
                        <option value="5" ${param.size == 5 ? 'selected' : ''}>5</option>
                        <option value="10" ${param.size == 10 || empty param.size ? 'selected' : ''}>10</option>
                        <option value="20" ${param.size == 20 ? 'selected' : ''}>20</option>
                        <option value="50" ${param.size == 50 ? 'selected' : ''}>50</option>
                    </select>
                    <span class="ms-2">entries</span>
                </div>

                <div class="text-muted">
                    Showing ${currentPage * param.size + 1} to
                    ${Math.min((currentPage * param.size) + param.size, totalItems)}
                    of ${totalItems} entries
                </div>
            </div>

            <!-- Pagination -->
            <nav aria-label="Page navigation" class="mt-4">
                <ul class="pagination justify-content-center">
                    <li class="page-item ${currentPage == 0 ? 'disabled' : ''}">
                        <a class="page-link" href="javascript:void(0)" onclick="goToPage(0)">First</a>
                    </li>
                    <li class="page-item ${currentPage == 0 ? 'disabled' : ''}">
                        <a class="page-link" href="javascript:void(0)" onclick="goToPage(${currentPage - 1})">Previous</a>
                    </li>

                    <c:forEach begin="${Math.max(0, currentPage - 2)}"
                               end="${Math.min(totalPages - 1, currentPage + 2)}" var="i">
                        <li class="page-item ${currentPage == i ? 'active' : ''}">
                            <a class="page-link" href="javascript:void(0)" onclick="goToPage(${i})">${i + 1}</a>
                        </li>
                    </c:forEach>

                    <li class="page-item ${currentPage + 1 >= totalPages ? 'disabled' : ''}">
                        <a class="page-link" href="javascript:void(0)" onclick="goToPage(${currentPage + 1})">Next</a>
                    </li>
                    <li class="page-item ${currentPage + 1 >= totalPages ? 'disabled' : ''}">
                        <a class="page-link" href="javascript:void(0)" onclick="goToPage(${totalPages - 1})">Last</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>

<!-- Bootstrap JS and Popper.js -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- JavaScript functions -->
<script>
    function submitFilter() {
        document.getElementById('filterForm').submit();
    }

    function resetFilters() {
        document.getElementById('lifestyleFilter').value = '';
        document.getElementById('categoryFilter').value = '';
        document.getElementById('retirementTypeFilter').value = '';
        submitFilter();
    }

    function changePageSize(size) {
        const form = document.getElementById('filterForm');
        const url = new URL(window.location.href);
        url.searchParams.set('page', '0');
        url.searchParams.set('size', size);
        url.searchParams.set('lifestyleId', form.lifestyleId.value);
        url.searchParams.set('categoryId', form.categoryId.value);
        url.searchParams.set('retirementTypeId', form.retirementTypeId.value);
        window.location.href = url.toString();
    }

    function goToPage(page) {
        const form = document.getElementById('filterForm');
        const url = new URL(window.location.href);
        url.searchParams.set('page', page);
        url.searchParams.set('lifestyleId', form.lifestyleId.value);
        url.searchParams.set('categoryId', form.categoryId.value);
        url.searchParams.set('retirementTypeId', form.retirementTypeId.value);
        window.location.href = url.toString();
    }
</script>
</body>
</html>