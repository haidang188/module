<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Category List</title>

  <!-- Bootstrap -->
  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/bootstrap520/css/bootstrap.min.css">

  <!-- DataTables -->
  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/datatables/css/dataTables.bootstrap5.min.css">
</head>

<body>

<div class="container mt-5">

  <div class="card shadow p-4">

    <!-- TITLE -->
    <div class="d-flex justify-content-between align-items-center mb-3">

      <h3>Danh sách Category</h3>

      <a href="${pageContext.request.contextPath}/categories?action=create"
         class="btn btn-primary">

        ➕ Thêm Category

      </a>

    </div>

    <!-- SEARCH -->
    <div class="mb-3">

      <input type="text"
             id="searchBox"
             class="form-control"
             placeholder="Tìm kiếm category...">

    </div>

    <!-- TABLE -->
    <table id="tableCategory"
           class="table table-striped table-bordered"
           style="width:100%">

      <thead>

      <tr>
        <th>ID</th>
        <th>Tên Category</th>
        <th width="180px">Action</th>
      </tr>

      </thead>

      <tbody>

      <c:forEach var="c" items="${categories}">

        <tr>

          <td>${c.id}</td>

          <td>${c.name}</td>

          <td>

            <!-- EDIT -->
            <a class="btn btn-warning btn-sm"
               href="${pageContext.request.contextPath}/categories?action=edit&id=${c.id}">

              Edit

            </a>

            <!-- DELETE -->
            <button
                    type="button"
                    class="btn btn-danger btn-sm"

                    data-bs-toggle="modal"
                    data-bs-target="#deleteModal"

                    data-id="${c.id}"
                    data-name="${c.name}">

              Delete
            </button>

          </td>

        </tr>

      </c:forEach>

      </tbody>

    </table>

  </div>

</div>
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

        Bạn có chắc muốn xóa danh mục:

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
<!-- JS -->
<script src="${pageContext.request.contextPath}/jquery/jquery-3.5.1.min.js"></script>

<script src="${pageContext.request.contextPath}/bootstrap520/js/bootstrap.bundle.min.js"></script>

<script src="${pageContext.request.contextPath}/datatables/js/jquery.dataTables.min.js"></script>

<script src="${pageContext.request.contextPath}/datatables/js/dataTables.bootstrap5.min.js"></script>

<script>

  $(document).ready(function () {

    let table = $('#tableCategory').DataTable({

      "dom": 'lrtip',
      "lengthChange": false,
      "pageLength": 5

    });

    // SEARCH
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
            '${pageContext.request.contextPath}/categories?action=delete&id='
            + productId;
  });

</script>
</body>
</html>