<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Inventories</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="mb-4">Inventories</h2>

        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${errorMessage}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>

        <!-- Table styled with Bootstrap -->
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Product</th>
                    <th>Branch</th>
                    <th>Quantity</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="inventory" items="${inventories}">
                    <tr>
                        <td>${inventory.product.name}</td>
                        <td>${inventory.branch.name}</td>
                        <td>${inventory.quantity}</td>
                        <td>
                            <!-- Add Bootstrap button styling to actions -->
                            <a href="inventories/details/${inventory.id}" class="btn btn-info btn-sm">Edit</a>
                            <a href="inventories/delete/${inventory.id}" onclick="return confirm('Are you sure?');" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Add New Product link with Bootstrap styling -->
        <a href="inventories/inventoryForm" class="btn btn-success">Add New Inventory</a>
    </div>

    <!-- Add Bootstrap JS and dependencies (optional for Bootstrap features like modals, dropdowns) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
