<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Order Details</title>
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <script>
       // Dynamically set the initial rowIndex based on the size of orderItems
       let rowIndex = ${order.orderItems != null ? order.orderItems.size() : 0};

       function addOrderItemRow() {
           alert("size " + rowIndex);
           const table = document.getElementById("orderItemsTable").getElementsByTagName('tbody')[0];
           const newRow = document.createElement("tr");

           newRow.innerHTML = `
               <td>
                   <select class="form-control" id="product-${rowIndex}" name="orderItems[${rowIndex}].product.id" required>
                       <option value="" disabled>Select a product</option>
                       <c:forEach var="product" items="${products}">
                           <option value="${product.id}">
                               ${product.name}
                           </option>
                       </c:forEach>
                   </select>
               </td>
               <td>
                   <input type="number" class="form-control" name="orderItems[0].quantity" value="1" />
               </td>
               <td>
                   <input type="number" class="form-control" name="orderItems[${rowIndex}].price" step="0.01" />
               </td>
           `;

           table.appendChild(newRow);

           // Increment rowIndex after appending the new row
           rowIndex++;
       }
   </script>

</head>
<body>
    <div class="container mt-4">
        <h2 class="mb-4">Order Details</h2>

        <form action="/orders/save" method="post">
            <input type="hidden" name="id" value="${order.id}" />

            <div class="form-group">
                <label for="branch">Branch:</label>
                <select class="form-control" id="branch" name="branch.id" required>
                    <option value="" disabled>Select a branch</option>
                    <c:forEach var="branch" items="${branches}">
                        <option value="${branch.id}"
                            <c:if test="${not empty order.branch and branch.id == order.branch.id}">selected</c:if>>
                            ${branch.name}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="description">Description:</label>
                <textarea class="form-control" id="description" name="description">${order.description}</textarea>
            </div>

            <div class="form-group">
                <label for="status">Status:</label>
                <input type="text" class="form-control" id="status" name="status" value="${order.status != null ? order.status : 'Pending'}" readonly required />
            </div>

            <div class="form-group">
                <label for="date">Date:</label>
                <input type="date" class="form-control" id="date" name="date" value="${order.date}" required />
            </div>

        <div class="form-group">
            <label>Order Items:</label>
            <table class="table table-bordered" id="orderItemsTable">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${order.orderItems}">
                        <tr>
                            <input type="hidden" name="${item.id}" value="${item.id}" />

                            <td>
                                <select class="form-control" name="${item.product.id}">
                                    <option value="" disabled>Select a product</option>
                                    <c:forEach var="product" items="${products}">
                                        <option value="${product.id}"
                                            <c:if test="${item.product != null && product.id == item.product.id}">selected</c:if>>
                                            ${product.name}
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>

                            <td>
                                <input type="number" class="form-control" name="orderItems[${rowIndex}].quantity"
                                       value="${item.quantity}" />
                            </td>

                            <td>
                                <input type="number" class="form-control" name="${item.price}"
                                       step="0.01" value="${item.price}" />
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- Add Item Button -->
            <button type="button" class="btn btn-secondary" onclick="addOrderItemRow()">Add Item</button>
        </div>

            <button type="submit" class="btn btn-primary">Save</button>
        </form>

        <br>
        <!-- Back to Product List -->
        <a href="../" class="btn btn-secondary">Back to Order List</a>
    </div>

    <!-- Add Bootstrap JS and dependencies (optional for Bootstrap features like modals, dropdowns) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
