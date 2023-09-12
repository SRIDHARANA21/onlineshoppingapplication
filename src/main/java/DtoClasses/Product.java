package DtoClasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Productid;
	private String ProductName;
	private String ProductDescreption;
	private double ProductPrice;
	private int ProductQuantityt;
	public int getProductid() {
		return Productid;
	}
	public void setProductid(int productid) {
		Productid = productid;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductDescreption() {
		return ProductDescreption;
	}
	public void setProductDescreption(String productDescreption) {
		ProductDescreption = productDescreption;
	}
	public double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}
	public int getProductQuantityt() {
		return ProductQuantityt;
	}
	public void setProductQuantityt(int productQuantityt) {
		ProductQuantityt = productQuantityt;
	}
	@Override
	public String toString() {
		return "Product [Productid=" + Productid + ", ProductName=" + ProductName + ", ProductDescreption="
				+ ProductDescreption + ", ProductPrice=" + ProductPrice + ", ProductQuantityt=" + ProductQuantityt
				+ "]";
	}
	
}
