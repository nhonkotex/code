package web.servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import web.connection.DbCon;
import web.dao.OrderDao;
import web.model.Cart;
import web.model.Order;
import web.model.User;

/**
 * Servlet implementation class TongtienServlet /Tongtien
 */
public class TongtienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try(PrintWriter out = response.getWriter()) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = new Date();
    	
    	 ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list"); //nơi truy xuất tất cả sảm phẩm thẻ.
    	 User auth = (User) request.getSession().getAttribute("auth"); 	//xác thực người dùng.
    	 // kiểm tra và xác thực dnah sách.
    	 if(cart_list != null && auth!=null) {
    		 for(Cart c:cart_list) {
					Order order = new Order(); 	//chuẩn bị đối tượng đặt hàng.
					order.setId(c.getId());
					order.setUid(auth.getId());
					order.setQuantity(c.getQuantity());
					order.setDate(formatter.format(date));
					//khởi tạo class.
					OrderDao oDao = new OrderDao(DbCon.getConnetion());
					//gọi phương thức chằn.
					boolean result = oDao.insertOrder(order);
					if(!result) break;
				}
    		 cart_list.clear();
				response.sendRedirect("Order.jsp");
    		 
    	 } else {
    		 if(auth == null) response.sendRedirect("login.jsp");   //nếu chưa đăng nhập sẽ báo để quay lại login.
    		 response.sendRedirect("cart.jsp"); // đăng nhập xong thì nó búng vô giỏ hàng luôn.
    		 
    	 }
    	 
	}catch(Exception e) {
		e.printStackTrace();
	}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
