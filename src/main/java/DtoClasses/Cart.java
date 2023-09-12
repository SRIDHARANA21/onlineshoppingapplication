package DtoClasses;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int Cartid;
	private double CartTotalPrice;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products;

	public int getCartid() {
		return Cartid;
	}

	public void setCartid(int cartid) {
		Cartid = cartid;
	}

	public double getCartTotalPrice() {
		return CartTotalPrice;
	}

	public void setCartTotalPrice(double cartTotalPrice) {
		CartTotalPrice = cartTotalPrice;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [Cartid=" + Cartid + ", CartTotalPrice=" + CartTotalPrice + ", products=" + products + "]";
	}
}
