<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Product List</title>

  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/bootstrap520/css/bootstrap.min.css">

  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/datatables/css/dataTables.bootstrap5.min.css">
</head>

<body>

<div class="container mt-4">

  <h2>Danh sách sản phẩm</h2>

  <div class="d-flex justify-content-between align-items-center mb-3">

    <input type="text"
           id="searchBox"
           class="form-control w-25"
           placeholder="Tìm kiếm...">

    <a href="${pageContext.request.contextPath}/product?action=create"
       class="btn btn-primary">

      ➕ Thêm sản phẩm
    </a>

  </div>

  <table id="tableProduct"
         class="table table-striped table-bordered">

    <thead>
    <tr>
      <th>ID</th>
      <th>Tên</th>
      <th>Giá</th>
      <th>Số lượng</th>
      <th>Màu sắc</th>
      <th>Mô tả</th>
      <th>Category</th>
      <th>Action</th>
    </tr>
    </thead>

    <tbody>

    <c:forEach var="p" items="${product}">

      <tr>

        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.price}</td>
        <td>${p.quantity}</td>
        <td>${p.color}</td>
        <td>${p.description}</td>
        <td>${p.category.name}</td>

        <td>

          <a class="btn btn-warning btn-sm"
             href="${pageContext.request.contextPath}/product?action=update&id=${p.id}">

            Edit
          </a>

          <button type="button"
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

</div>

<!-- DELETE MODAL -->
<div class="modal fade"
     id="deleteModal"
     tabindex="-1">

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

    let table = $('#tableProduct').DataTable({

      "dom": 'lrtip',
      "lengthChange": false,
      "pageLength": 5

    });

    $('#searchBox').on('keyup', function () {

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
            '${pageContext.request.contextPath}/product?action=delete&id='
            + productId;

  });

</script>

</body>
</html>