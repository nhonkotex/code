package web.model;

public class addProduct {
	 private static final long serialVersionUID = 1L;
	 private int id;
	    private String name;
	    private String category;
	    private String price;
	    private String image;
	    private String chitiet;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		
		public String getChitiet() {
			return chitiet;
		}
		public void setChitiet(String chitiet) {
			this.chitiet = chitiet;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		@Override
		public String toString() {
			return "addProduct [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price
					+ ", image=" + image + ", chitiet=" + chitiet + "]";
		}
		
		
	
 
}
