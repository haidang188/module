<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit Product</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/bootstrap520/css/bootstrap.min.css">
</head>

<body>

<div class="container mt-5">
    <div class="card shadow p-4 col-md-6 mx-auto">

        <h3 class="text-center mb-4">Sửa sản phẩm</h3>

        <form id="productForm"
              action="${pageContext.request.contextPath}/product?action=update"
              method="post">

            <input type="hidden"
                   name="id"
                   value="${product.id}"/>

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

            <!-- COLOR -->
            <div class="mb-3">
                <label class="form-label">Màu sắc</label>

                <input type="text"
                       id="color"
                       name="color"
                       class="form-control"
                       value="${product.color}">

                <div class="text-danger" id="errorColor"></div>
            </div>

            <!-- DESCRIPTION -->
            <div class="mb-3">
                <label class="form-label">Mô tả</label>

                <textarea id="description"
                          name="description"
                          class="form-control"
                          rows="3">${product.description}</textarea>

                <div class="text-danger" id="errorDescription"></div>
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
                            ${c.id == product.category.id ? 'selected' : ''}>
                                ${c.name}
                        </option>
                    </c:forEach>

                </select>

                <div class="text-danger" id="errorCategory"></div>
            </div>

            <div class="d-flex justify-content-between">

                <a href="${pageContext.request.contextPath}/product"
                   class="btn btn-secondary">

                    ⬅ Quay lại
                </a>

                <button type="submit"
                        class="btn btn-primary">

                    Update
                </button>

            </div>

        </form>

    </div>
</div>

<script src="${pageContext.request.contextPath}/jquery/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap520/js/bootstrap.bundle.min.js"></script>

</body>
</html>