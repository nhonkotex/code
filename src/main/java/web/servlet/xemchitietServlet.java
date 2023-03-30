package web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.Cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class xemchitietServlet /xemchitiet
 */
public class xemchitietServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// thêm sản phẩm vời giỏ
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try (PrintWriter out = response.getWriter()) {
			
			ArrayList<Cart> cartList = new ArrayList<>();
			  int id = Integer.parseInt(request.getParameter("id"));
	            Cart cm = new Cart();
	            cm.setId(id);
	            cm.setQuantity(1);
	            HttpSession session = request.getSession();
	            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	            
	           if(cart_list == null) {
	        	   cartList.add(cm);
	        	  session.setAttribute("cart-list", cartList); //thêm sản phẩm đầu 
	        	  response.sendRedirect("chitiet.jsp");
	           } else {
	                cartList = cart_list;

	                boolean exist = false;
	                for (Cart c : cart_list) {
	                    if (c.getId() == id) {				
	                        exist = true;
	                        out.println("<h3 style='color:crimson; text-align: center'>Sản phẩm đã được xem. <a href='giohang.jsp'>Mời bạn quay lại trang chi tiết</a></h3>");		//sản phẩm đã được thêm vào sản 
	                    }   
	                }
	                if (!exist) {
	                    cartList.add(cm);
	                  response.sendRedirect("chitiet.jsp");
	                }
	            }
			}
		
		}

}
