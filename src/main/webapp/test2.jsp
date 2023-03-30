<%@page import="web.connection.DbCon"%>
<%@page import="web.dao.ProductDao"%>
<%@page import="web.model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("auth", auth);
}
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if (cart_list != null) {
	ProductDao pDao = new ProductDao(DbCon.getConnetion());
	cartProduct = pDao.getCartProducts(cart_list);
	double total = pDao.getTotalCartPrice(cart_list);
	request.setAttribute("total", total);
	request.setAttribute("cart_list", cart_list);
}


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<head>
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	
	
	
	 <!----======== CSS ======== -->

    
    <!----===== Boxicons CSS ===== -->
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>

     <!-- ===== Link Swiper's CSS ===== -->
     <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>

     <!-- ===== Fontawesome CDN Link ===== -->
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>

</head>

</head>
<body>
	
	  <div class="image-gallery">
            <header><font color="black">Giỏ hàng </font></header>
        </div>
		<div class="container my-3">	
		<div class="container my-3">
		
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			<%
				if (cart_list != null) {
					for (Cart c : cartProduct) { %>
						<tr>
						<td><%= c.getName() %></td>
						<td><%= c.getCategory() %></td>
						<td><%= dcf.format(c.getPrice())%></td>
						<td>
							<form action="Order-Now" method="post" class="form-inline">
								<input type="hidden" name="id" value="<%= c.getId() %>" class="form-input">
								<div class="form-group d-flex justify-content-between"> 
									<a class="btn btn-ms btn-incre" href="QuantityInc?action=dec&id=<%= c.getId() %>"><i class="fas fa-minus-square"></i></a>
									
									<input type="text" name="quantity" class="form-control"  value="<%=c.getQuantity()%>" readonly> 
									<a class="btn btn-sm btn-decre" href="QuantityInc?action=inc&id=<%= c.getId() %>"><i class="fas fa-minus-square"></i></a>
									
								</div>
								<button type="submit" class="btn btn-primary btn-sm">Buy</button>
							</form>
							</td>
							<td>
							<a class="btn btn-sm btn-danger" href="xoa-khoiGH?id=<%=c.getId() %>">Loại bỏ</a>
							</td>
					</tr>
						<%}
					}
				%>
				
			</tbody>
		</table>
		<div class="d-flex py-3">
		<h3>Tổng tiền sản phẩm:  ${(total>0)?dcf.format(total):0} VNĐ</h3> 
		<a class="mx-3 btn btn-primary" href="Tong-tien">Thanh Toán</a></div>
		<p>* Lưu ý các sản phẩm trên không có số 000 ở sau có nghĩa sản phẩm của bạn là hàng triệu nhé.</p>
			</div>
			</div>
			
	
	
	
	
</body>
</html>