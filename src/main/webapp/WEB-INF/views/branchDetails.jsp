<html>
<head>
    <title>Product Details</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="mb-4">Branch Details</h2>

        <!-- Form for Product Details -->
        <form action="/branches/save" method="post">
            <input type="hidden" name="id" value="${branch.id}" />

            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="${branch.name}" required />
            </div>

            <div class="form-group">
                <label for="location">Location:</label>
                <input type="test" class="form-control" id="location" name="location" value="${branch.location}" required />
            </div>

            <button type="submit" class="btn btn-primary">Save</button>
        </form>

        <br>
        <!-- Back to Product List -->
        <a href="../" class="btn btn-secondary">Back to Branch List</a>
    </div>

    <!-- Add Bootstrap JS and dependencies (optional for Bootstrap features like modals, dropdowns) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
