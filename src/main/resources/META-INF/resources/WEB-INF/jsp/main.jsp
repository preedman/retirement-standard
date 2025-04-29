<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">

    <div id="main">
        <h1>Welcome</h1>
        <!--
        <a href="list-todos">Manage</a> your todos
        -->


        <div class="table-responsive">


            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Item</th>
                    <th scope="col">Life Style</th>
                    <th scope="col">Retirement Type</th>
                    <th scope="col">Category</th>
                    <th scope="col">Budget Per Week</th>
                    <th scope="col">Start Date</th>
                    <th scope="col">End Date</th>

                </tr>
                </thead>
                <tbody>
                    <c:forEach var="budgetstandard" items="${listOfBudgetStandards}">
                        <tr>
                            <td>${budgetstandard.id}</td>
                            <td>${budgetstandard.item}</td>
                            <td>${budgetstandard.lifestyle}</td>
                            <td>${budgetstandard.retirementtype}</td>
                            <td>${budgetstandard.category}</td>
                            <td>${budgetstandard.amount}</td>
                            <td>${budgetstandard.startDate}</td>
                            <td>${budgetstandard.endDate}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>



    </div>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </nav>
</div>



<%@ include file="common/footer.jspf" %>