package web.servlet;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import web.dao.addProductDao;
import web.model.addProduct;

/**
 * Servlet implementation class themProductServlet
 */
public class themProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private addProductDao addhangDao;
    public void init() {
 	   addhangDao = new addProductDao(null);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		String image = request.getParameter("image");
		String chitiet = request.getParameter("chitiet");
		
		addProduct addsp = new addProduct();
		addsp.setName(name);
		addsp.setCategory(category);
		addsp.setPrice(price);
		addsp.setImage(image);
		addsp.setChitiet(chitiet);
		try {
		addhangDao.registerAddProduct(addsp);
		}catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
	}
		response.sendRedirect("test1.jsp");
	}

}

