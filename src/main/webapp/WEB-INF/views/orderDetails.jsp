<html>
<head>
    <title>Product Details</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="mb-4">Product Details</h2>

        <!-- Form for Product Details -->
        <form action="/products/save" method="post">
            <input type="hidden" name="id" value="${product.id}" />

            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="${product.name}" required />
            </div>

            <div class="form-group">
                <label for="salePrice">salePrice:</label>
                <input type="number" class="form-control" step="0.01" id="salePrice" name="salePrice" value="${product.salePrice}" required />
            </div>

            <div class="form-group">
                <label for="costPrice">costPrice:</label>
                <input type="number" class="form-control" step="0.01" id="costPrice" name="costPrice" value="${product.costPrice}" required />
            </div>

            <div class="form-group">
                <label for="description">Description:</label>
                <textarea class="form-control" id="description" name="description">${product.description}</textarea>
            </div>

            <button type="submit" class="btn btn-primary">Save</button>
        </form>

        <br>
        <!-- Back to Product List -->
        <a href="../" class="btn btn-secondary">Back to Product List</a>
    </div>

    <!-- Add Bootstrap JS and dependencies (optional for Bootstrap features like modals, dropdowns) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
