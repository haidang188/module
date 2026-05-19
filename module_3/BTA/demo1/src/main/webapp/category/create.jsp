<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
  <title>Create Category</title>

  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/bootstrap520/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">

  <div class="card shadow p-4 col-md-6 mx-auto">

    <h3 class="mb-4 text-center">Thêm Category</h3>

    <form id="categoryForm"
          action="${pageContext.request.contextPath}/categories?action=create"
          method="post">

      <!-- CATEGORY NAME -->
      <div class="mb-3">

        <label class="form-label">Tên Category</label>

        <input type="text"
               id="name"
               name="name"
               class="form-control">

        <div class="text-danger" id="errorName"></div>

      </div>

      <!-- BUTTON -->
      <div class="d-flex justify-content-between">

        <a href="${pageContext.request.contextPath}/categories"
           class="btn btn-secondary">

          ⬅ Quay lại

        </a>

        <button type="submit"
                class="btn btn-primary">

          Create

        </button>

      </div>

    </form>

  </div>

</div>

<!-- JS -->
<script src="${pageContext.request.contextPath}/jquery/jquery-3.5.1.min.js"></script>

<script src="${pageContext.request.contextPath}/bootstrap520/js/bootstrap.bundle.js"></script>

<script>

  document.getElementById("categoryForm")
          .addEventListener("submit", function (e) {

            let isValid = true;

            // clear error
            document.getElementById("errorName").innerText = "";

            let name = document.getElementById("name").value.trim();

            // VALIDATE NAME
            if (name === "") {

              document.getElementById("errorName").innerText =
                      "Không được để trống";

              isValid = false;

            } else if (name.length < 3) {

              document.getElementById("errorName").innerText =
                      "Tối thiểu 3 ký tự";

              isValid = false;
            }

            if (!isValid) {
              e.preventDefault();
            }

          });

</script>

</body>
</html>