<%@page import="web.connection.DbCon"%>
<%@page import="web.dao.AddUserDao"%>
<%@page import="web.model.Adduser"%>
<%@page import="java.util.*"%>
<%@page import="web.dao.addProductDao"%>
<%@page import="web.dao.ProductDao"%>

<%@page import="web.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%
 
  AddUserDao Ql = new AddUserDao(DbCon.getConnetion());
  List<Adduser> user = Ql.getAllUser1();
  
  
  addProductDao te = new addProductDao(DbCon.getConnetion());
  List<addProduct> test = te.getAllPRD();

  ProductDao t1 = new ProductDao(DbCon.getConnetion());
  List<Product> test1 = t1.getAllProducts();
  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> PETS SHOP </title>
<link rel="stylesheet" href="css/test.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

</head>
<body>

	
	 <div class="image-gallery">
            <header> Sản Phẩm của Shop Pet </header>
        </div>
	<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Password</th>
					<th scope="col">Số điện Thoại</th>
					<th scope="col">Địa chỉ</th>
					<th scope="col">Xoá TK</th>
					
				</tr>
			</thead>
			<tbody>
			
				<%
			if(!user.isEmpty()) {
				for (Adduser q : user) {		
				%>
					<tr>
						<td><%=q.getId() %></td>
						<td><%=q.getName() %></td>
						<td><%=q.getEmail() %></td>
						<td><%=q.getPassword() %></td>
						<td><%=q.getSodienthoai() %></td>
						<td><%=q.getDiachi() %></td>
						<td><a class="btn btn-sm btn-danger" href="delete-user?id=<%=q.getId() %>">Xoá
						</a></td>
						
					</tr>
					
				<%}	
			}
			%>
			</tbody>
					</table>
					
					<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Password</th>
					<th scope="col">Số điện Thoại</th>
					<th scope="col">Địa chỉ</th>
					<th scope="col">Xoá TK</th>
					
				</tr>
			</thead>
			<tbody>
			
			
			</tbody>
			
					</table>
	<form>
		
     	<%
			if(!test.isEmpty()) {
				for (addProduct q : test) {		
				%>
					<tr>
						<td><%=q.getId() %></td>
						<td><%=q.getName() %></td>
						<td><%=q.getCategory() %></td>
						
						<td><a class="btn btn-sm btn-danger" href="delete-user?id=<%=q.getId() %>">Xoá
						</a></td>
						
					</tr>
					
				<%}	
			}
			%>
		
					
					
					<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Password</th>
					<th scope="col">Số điện Thoại</th>
					<th scope="col">Địa chỉ</th>
					<th scope="col">Xoá TK</th>
					
				</tr>
			</thead>
			<tbody>
			
			
			</tbody>
			
					</table>
	<form>
		
     	<%
			if(!test1.isEmpty()) {
				for (Product q : test1) {		
				%>
					<tr>
						<td><%=q.getId() %></td>
						<td><%=q.getName() %></td>
						<td><%=q.getCategory() %></td>
						
						<td><a class="btn btn-sm btn-danger" href="delete-user?id=<%=q.getId() %>">Xoá
						</a></td>
						
					</tr>
					
				<%}	
			}
			%>
		
					
</form>

	<section class="footer">
		
		    <div class="share">
		        <a href="https://www.facebook.com/caonhatnhon.beo" class="fab fa-facebook-f"></a>
		        <a href="https://twitter.com/nhon_beo" class="fab fa-twitter"></a>
		        <a href="https://www.instagram.com/caonhatnhon/?fbclid=IwAR0iL6XO9rdrdV1IjXEpUri9w-nY79prtiLsbBnFy2k2e4Xu5R1gR64aKvg" class="fab fa-instagram"></a>
		      
		        <a href="https://github.com/nhonkotex/cnpm_nhon4" class="fab fa-github"></a>
		    </div>
		
		    <div class="links">
		        <a href="Admin.jsp">home</a>
		        <a href="lichkham.jsp">Lịch khám</a>
		        <a href="quanlyproduct.jsp">Sản Phẩm</a>
		        <a href="quanlydonhang.jsp">Đơn Hàng</a>
		        <a href="Addthongbao.jsp">Thông Báo</a>
		        <a href="quanlyUser.jsp">User</a>
		        <a href="Nhanvien.jsp">Nhân Viên</a>
		        <a href="Nhanxet.jsp">Nhận xét</a>
		    </div>
		
		   
		
		    <div class="credit">created by <span>Cao Nhật Nhơn</span> | all rights reserved</div>
		
		</section>

    <!-- Swiper JS -->
  <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

   

  
   
</body>
</html>