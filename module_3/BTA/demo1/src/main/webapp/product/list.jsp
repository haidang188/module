
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap520/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/datatables/css/dataTables.bootstrap5.min.css">
</head>
<body>

<h2>Danh sách sản phẩm</h2>

<!-- Search -->
<form action="${pageContext.request.contextPath}/products" method="get">
    <input type="hidden" name="action" value="search"/>
    <input type="text" name="keyword" placeholder="Tìm kiếm..."/>
    <button type="submit">Search</button>
</form>

<br>

<a href="${pageContext.request.contextPath}/products?action=create">➕ Thêm sản phẩm</a>
<a class="btn btn-success"
   href="${pageContext.request.contextPath}/categories">

    📂 Quản lý Category

</a>

<br><br>

<table id="tableProduct" class="table table-striped table-bordered" style="width: 100%">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Category Name</th>
        <th>Action</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.quantity}</td>
            <td>${p.category.name}</td>
            <td>
                <a class="btn btn-warning btn-sm"
                   href="${pageContext.request.contextPath}/products?action=edit&id=${p.id}">
                    Edit
                </a>

                <button
                        type="button"
                        class="btn btn-danger btn-sm"

                        data-bs-toggle="modal"
                        data-bs-target="#deleteModal"

                        data-id="${p.id}"
                        data-name="${p.name}">

                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>

<!-- Delete Modal -->
<div class="modal fade"
     id="deleteModal"
     tabindex="-1"
     aria-hidden="true">

    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h5 class="modal-title">
                    Xác nhận xóa
                </h5>

                <button type="button"
                        class="btn-close"
                        data-bs-dismiss="modal">
                </button>
            </div>

            <div class="modal-body">

                Bạn có chắc muốn xóa sản phẩm:

                <strong id="productName"></strong> ?

            </div>

            <div class="modal-footer">

                <button type="button"
                        class="btn btn-secondary"
                        data-bs-dismiss="modal">

                    Hủy
                </button>

                <a id="confirmDeleteBtn"
                   href=""
                   class="btn btn-danger">

                    Xóa
                </a>

            </div>

        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/jquery/jquery-3.5.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap520/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/datatables/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/datatables/js/dataTables.bootstrap5.min.js"></script>

<script>
    $(document).ready(function () {
        var table = $('#tableProduct').DataTable ( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 6

        });
        $('input[name="keyword"]').on('keyup', function () {
            table.search(this.value).draw();
        });
    });
</script>

<script>

    const deleteModal =
        document.getElementById('deleteModal');

    deleteModal.addEventListener('show.bs.modal', function (event) {

        const button = event.relatedTarget;

        const productId =
            button.getAttribute('data-id');

        const productName =
            button.getAttribute('data-name');

        document.getElementById('productName').textContent =
            productName;

        document.getElementById('confirmDeleteBtn').href =
            '${pageContext.request.contextPath}/products?action=delete&id='
            + productId;
    });

</script>
</body>
</html>
