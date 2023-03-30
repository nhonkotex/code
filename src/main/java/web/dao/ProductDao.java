package web.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.model.Cart;
import web.model.Product;

public class ProductDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	public ProductDao(Connection con) {
		this.con = con;
	}
	public List<Product> getAllProducts() {
        List<Product> products= new ArrayList<>();
        try {

            query = "select * from sanpham1";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
            	Product row = new Product();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("name"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getDouble("price"));
                row.setImage(rs.getString("image"));
                row.setChitiet(rs.getString("chitiet"));

                products.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return products;
	
}
	public Product getSingleProduct(int id) {
		 Product row = null;
	        try {
	            query = "select * from sanpham1 where id=? ";
	           
	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, id);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	            	row = new Product();
	                row.setId(rs.getInt("id"));
	                row.setName(rs.getString("name"));
	                row.setCategory(rs.getString("category"));
	                row.setPrice(rs.getDouble("price"));
	                row.setImage(rs.getString("image"));
	                row.setChitiet(rs.getString("chitiet"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }
	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
		List<Cart> products = new ArrayList<Cart>();
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					 query = "select * from sanpham1 where id=?";
					
	                    pst = this.con.prepareStatement(query);
	                    pst.setInt(1, item.getId());
	                    rs = pst.executeQuery();
	                    while (rs.next()) {
	                        Cart row = new Cart();
	                        row.setId(rs.getInt("id"));
	                        row.setName(rs.getString("name"));
	                        row.setCategory(rs.getString("category"));
	                       
	                        row.setPrice(rs.getDouble("price")*item.getQuantity());
	                        row.setQuantity(item.getQuantity());
	                        row.setImage(rs.getString("image"));
	                        row.setChitiet(rs.getString("chitiet"));
	                        products.add(row);
	                    }
				}
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
			}
		
		return products;
	}
	
	
	
	
	
	
	public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select price from sanpham1 where id=?";
                   
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        sum+=rs.getDouble("price")*item.getQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }
	public List<Cart> getCartchitiet(ArrayList<Cart> cartList) {
		List<Cart> products = new ArrayList<Cart>();
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					 query = "select * from sanpham1 where id=?";
					
	                    pst = this.con.prepareStatement(query);
	                    pst.setInt(1, item.getId());
	                    rs = pst.executeQuery();
	                    while (rs.next()) {
	                        Cart row = new Cart();
	                        row.setId(rs.getInt("id"));
	                        row.setName(rs.getString("name"));
	                        row.setCategory(rs.getString("category"));
	                       
	                        row.setPrice(rs.getDouble("price"));
	                        row.setQuantity(item.getQuantity());
	                        row.setImage(rs.getString("image"));
	                        row.setChitiet(rs.getString("chitiet"));
	                        products.add(row);
	                    }
				}
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
			}
		
		return products;
	}
	
	 public void huydon(int id) {
         //boolean result = false;
         try {
             query = "delete from sanpham1 where id=?";
             pst = this.con.prepareStatement(query);
             pst.setInt(1, id);
             pst.execute();
             //result = true;
         } catch (SQLException e) {
             e.printStackTrace();
             System.out.print(e.getMessage());
         }
         //return result;
     }
	
	
}
