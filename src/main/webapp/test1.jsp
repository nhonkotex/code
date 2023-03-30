<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOGIN</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
  <div class="container">
	
               
               <div class="card-header text-center">Thêm sản phẩm</div>
			<div class="card-body">
				
			<form action="<%= request.getContextPath() %>/themProduct" method="post">
                   <p>Tên mặt hàng</p>
					<input type="text" name="name" class="form-control" placeholder="vd: Chó pull">
				
						
					<p>Thể loại</p>
					<input type="text" placeholder="vd: thú cưng" class="form-control" name="category" required>
					
						
					<p>Giá sản phẩm</p>
					<input type="text" placeholder="vd: 100" class="form-control" name="price" required>
					
					<p>Ảnh sản phẩm </p>
					<input type="text" placeholder="vd: cho.jpg" class="form-control" name="image" required>
					
					<p>Ảnh sản phẩm </p>
					<input type="text" placeholder="vd: hihi" class="form-control" name="chitiet" required>
					
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Thêm sản phẩm</button>
						<a href="ThemUserTC.jsp" class="btn">Exit</a>
					</div>
					</form>
      </div>
   
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $("#action").click(function(){
            $(".log_form, .reg_form").toggle(1200);
        });
    </script>
</body>
</html>