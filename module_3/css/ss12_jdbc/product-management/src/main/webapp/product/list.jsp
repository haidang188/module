
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

<br><br>

<table id="tableProduct" class="table table-striped table-bordered" style="width: 100%">
  <thead>
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Giá</th>
    <th>Số lượng</th>
    <th>Category ID</th>
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
      <td>${p.categoryId}</td>
      <td>
        <a class="btn btn-warning btn-sm"
           href="${pageContext.request.contextPath}/products?action=edit&id=${p.id}">
          Edit
        </a>

        <a class="btn btn-danger btn-sm"
           href="${pageContext.request.contextPath}/products?action=delete&id=${p.id}"
           onclick="return confirm('Bạn có chắc muốn xoá?')">
          Delete
        </a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<br>

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

</body>
</html>
