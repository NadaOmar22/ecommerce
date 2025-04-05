<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Orders</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="mb-4">Orders</h2>

        <!-- Table styled with Bootstrap -->
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td>${order.description}</td>
                        <td>${order.date}</td>
                        <td>${order.status}</td>
                        <td>
                            <!-- Add Bootstrap button styling to actions -->
                            <a href="orders/details/${order.id}" class="btn btn-info btn-sm">Edit</a>
                            <a href="orders/delete/${order.id}" onclick="return confirm('Are you sure?');" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Add New Product link with Bootstrap styling -->
        <a href="orders/orderForm" class="btn btn-success">Add New Order</a>
    </div>

    <!-- Add Bootstrap JS and dependencies (optional for Bootstrap features like modals, dropdowns) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
