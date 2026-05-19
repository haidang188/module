<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit Product</title>

    <!-- Bootstrap -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/bootstrap520/css/bootstrap.min.css">
</head>

<body>

<div class="container mt-5">
    <div class="card shadow p-4 col-md-6 mx-auto">

        <h3 class="text-center mb-4">Sửa sản phẩm</h3>

        <form id="productForm"
              action="${pageContext.request.contextPath}/products?action=edit"
              method="post">

            <input type="hidden" name="id" value="${product.id}"/>

            <!-- NAME -->
            <div class="mb-3">
                <label class="form-label">Tên</label>
                <input type="text"
                       id="name"
                       name="name"
                       class="form-control"
                       value="${product.name}">
                <div class="text-danger" id="errorName"></div>
            </div>

            <!-- PRICE -->
            <div class="mb-3">
                <label class="form-label">Giá</label>
                <input type="number"
                       id="price"
                       name="price"
                       class="form-control"
                       value="${product.price}">
                <div class="text-danger" id="errorPrice"></div>
            </div>

            <!-- QUANTITY -->
            <div class="mb-3">
                <label class="form-label">Số lượng</label>
                <input type="number"
                       id="quantity"
                       name="quantity"
                       class="form-control"
                       value="${product.quantity}">
                <div class="text-danger" id="errorQuantity"></div>
            </div>

            <!-- CATEGORY -->
            <div class="mb-3">
                <label class="form-label">Category</label>
                <select id="categoryId"
                        name="categoryId"
                        class="form-select">

                    <option value="">-- Chọn category --</option>

                    <c:forEach var="c" items="${categories}">
                        <option value="${c.id}"
                                <c:if test="${c.id == product.categoryId}">selected</c:if>>
                                ${c.name}
                        </option>
                    </c:forEach>

                </select>
                <div class="text-danger" id="errorCategory"></div>
            </div>

            <!-- BUTTON -->
            <div class="d-flex justify-content-between">
                <a href="${pageContext.request.contextPath}/products"
                   class="btn btn-secondary">
                    ⬅ Quay lại
                </a>

                <button type="submit" class="btn btn-primary">
                    Update
                </button>
            </div>

        </form>

    </div>
</div>

<!-- JS -->
<script src="${pageContext.request.contextPath}/jquery/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap520/js/bootstrap.bundle.js"></script>

<script>
    document.getElementById("productForm").addEventListener("submit", function (e) {

        let isValid = true;

        document.querySelectorAll(".text-danger").forEach(el => el.innerText = "");

        let name = document.getElementById("name").value.trim();
        let price = document.getElementById("price").value;
        let quantity = document.getElementById("quantity").value;
        let category = document.getElementById("categoryId").value;

        if (name === "") {
            document.getElementById("errorName").innerText = "Không được để trống";
            isValid = false;
        }

        if (price === "" || price <= 0) {
            document.getElementById("errorPrice").innerText = "Giá phải > 0";
            isValid = false;
        }

        if (quantity === "" || quantity < 0) {
            document.getElementById("errorQuantity").innerText = "Số lượng ≥ 0";
            isValid = false;
        }

        if (category === "") {
            document.getElementById("errorCategory").innerText = "Phải chọn category";
            isValid = false;
        }

        if (!isValid) {
            e.preventDefault();
        }
    });
</script>

</body>
</html>