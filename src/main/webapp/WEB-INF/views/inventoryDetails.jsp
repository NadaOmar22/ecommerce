<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Inventory Details</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="mb-4">Inventory Details</h2>

        <form action="/inventories/save" method="post">
            <input type="hidden" name="id" value="${inventory.id}" />

            <div class="form-group">
                <label for="product">Product:</label>
                <select class="form-control" id="product" name="product.id" required>
                    <option value="" disabled>Select a product</option>
                    <c:forEach var="product" items="${products}">
                        <option value="${product.id}"
                            <c:if test="${not empty inventory.product and product.id == inventory.product.id}">selected</c:if>>
                            ${product.name}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="branch">Branch:</label>
                <select class="form-control" id="branch" name="branch.id" required>
                    <option value="" disabled>Select a branch</option>
                    <c:forEach var="branch" items="${branches}">
                        <option value="${branch.id}"
                            <c:if test="${not empty inventory.branch and branch.id == inventory.branch.id}">selected</c:if>>
                            ${branch.name}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="quantity">Quantity:</label>
                <input type="number" class="form-control" step="0.01" id="quantity" name="quantity" value="${inventory.quantity}" required />
            </div>

            <button type="submit" class="btn btn-primary">Save</button>
        </form>

        <br>
        <!-- Back to Product List -->
        <a href="../" class="btn btn-secondary">Back to Inventories List</a>
    </div>

    <!-- Add Bootstrap JS and dependencies (optional for Bootstrap features like modals, dropdowns) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
