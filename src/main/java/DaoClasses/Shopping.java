package DaoClasses;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import DtoClasses.Admin;
import DtoClasses.Cart;
import DtoClasses.Item;
import DtoClasses.Product;
import DtoClasses.User;

public class Shopping {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("sridharan");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public Admin findadmin(int id) {
		Admin afi = em.find(Admin.class, id);
		return afi;
	}

	public Item saveitem() {
		Scanner sc = new Scanner(System.in);

		Item item = new Item();

		System.out.println("Enter the item name");
		String name = sc.next();
		item.setItemName(name);

		System.out.println("Enter the item price");
		double price = sc.nextDouble();
		item.setItemPrice(price);

		System.out.println("Enter the item Quantity");
		int quantity = sc.nextInt();
		item.setItemQuantityt(quantity);

		System.out.println("Enter the item Description");
		String description = sc.next();
		item.setItemDescreption(description);

		et.begin();
		em.persist(item);
		et.commit();

		return item;
	}

	public Admin saveadmin() {
		Admin admin = new Admin();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Admin name");
		String name = sc.next();
		admin.setAdminName(name);

		System.out.println("Enter the Admin Email");
		String email = sc.next();
		admin.setAdminEmail(email);

		System.out.println("Enter the Admin password");
		String pass = sc.next();
		admin.setAdminPassword(pass);

		System.out.println("Enter the Admin contact");
		long contact = sc.nextLong();
		admin.setAdminContact(contact);

		et.begin();
		em.persist(admin);
		et.commit();

		return admin;
	}

	public Item saveitemToadmin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Admin id");
		int adid = sc.nextInt();
		Admin admin = em.find(Admin.class, adid);
		List<Item> items = admin.getItems();
		Item i = saveitem();
		items.add(i);
		admin.setItems(items);
		updateadmin(admin, adid);
		return i;
	}

	public Item deleteitem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Admin id");
		int aid = sc.nextInt();
		Admin eadm = em.find(Admin.class, aid);
		System.out.println("enter the item id you want to delete");
		Item i = em.find(Item.class, sc.nextInt());
		if (eadm.getItems().contains(i)) {
			List<Item> item = eadm.getItems();
			item.remove(i);
			eadm.setItems(item);
			updateadmin(eadm, eadm.getAdminid());
			et.begin();
			em.remove(i);
			et.commit();
			return i;
		} else {
			System.out.println("item is not present in the admin");
			return null;
		}

	}

	public Admin updateadmin(Admin aup, int id) {
		Admin exist = em.find(Admin.class, id);
		if (exist != null) {
			aup.setAdminid(id);
			et.begin();
			em.merge(aup);
			et.commit();
			return exist;
		} else {
			return null;
		}
	}

	public Item finditembyname() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the item name");
		String na = sc.next();
		Query query = em.createQuery("select it from Item it where it.ItemName=?1");
		query.setParameter(1, na);
		Item item = (Item) query.getSingleResult();
		return item;
	}

	public Item deleteitembyname() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the admin id");
		Admin id = em.find(Admin.class, sc.nextInt());
		Item it = finditembyname();

		if (id != null) {
			if (it != null) {
				List<Item> items = id.getItems();
				items.remove(it);
				id.setItems(items);
				updateadmin(id, id.getAdminid());
				return removeitem(it);
			} else {
				System.out.println("item is not present ");
				return null;
			}
		} else {
			System.out.println("Admin not contains any items like this");
			return null;
		}

	}

	public Item removeitem(Item item) {
		et.begin();
		em.remove(item);
		et.commit();
		return item;
	}

	public User saveuser() {
		Scanner sc = new Scanner(System.in);
		User u = new User();
		Cart c = new Cart();
		u.setCart(c);

		System.out.println("Enter the user name");
		String name = sc.next();
		u.setUserName(name);

		System.out.println("Enter the user email");
		String emal = sc.next();
		u.setUserEmail(emal);

		System.out.println("Enter the user password");
		String pass = sc.next();
		u.setUserPassword(pass);

		System.out.println("Enter the user contact");
		long con = sc.nextLong();
		u.setUserContact(con);

		et.begin();
		em.persist(u);
		et.commit();

		return u;
	}

	public Cart savecart()

	{
		Cart ca = new Cart();
		et.begin();
		em.persist(ca);
		et.commit();
		return ca;
	}

	public Product addproducttocart() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the cart id");
		Cart c = findcart(sc.nextInt());

		System.out.println("Enter the item id");
		int id = sc.nextInt();
		Item i1 = em.find(Item.class, id);
		Product pr = new Product();
		pr.setProductName(i1.getItemName());
		pr.setProductPrice(i1.getItemPrice());
		pr.setProductDescreption(i1.getItemDescreption());
		System.out.println("Enter the quantity how much u want to buy");
		int n = sc.nextInt();
		pr.setProductQuantityt(n);

		saveproduct(pr);
		
		i1.setItemQuantityt(i1.getItemQuantityt()-n);
		updateitem(i1,i1.getItemid());
		
		List<Product> products = c.getProducts();
		products.add(pr);
		double totalprice=0;
		for (Product product : products) {
			totalprice=totalprice+(pr.getProductPrice()*pr.getProductQuantityt());
		}
		
		
		c.setCartTotalPrice(totalprice);
		c.setProducts(products);
		updatecart(c, c.getCartid());
		return pr;

	}

	public Cart updatecart(Cart ucart, int id) {
		Cart c1 = em.find(Cart.class, id);
		if (c1 != null) {
			c1.setCartid(id);
			et.begin();
			em.merge(ucart);
			et.commit();
			return c1;
		} else {
			System.out.println("Product ID is Not There");
			return null;
		}
	}
	public Item updateitem(Item uitem, int id) {
		Item item = em.find(Item.class, id);
		if (item != null) {
			item.setItemid(id);
			et.begin();
			em.merge(uitem);
			et.commit();
			return item;
		} else {
			System.out.println("Product ID is Not There");
			return null;
		}
	}

	public Cart findcart(int cartid) {
		return em.find(Cart.class, cartid);
	}

	public Product saveproduct(Product p) {
		et.begin();
		em.persist(p);
		et.commit();
		return p;
	}

	public Cart removeproductfromcart() {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter the cart id");
		Cart c = em.find(Cart.class, sc.nextInt());
		System.out.println("enter the product id");
		Product p = em.find(Product.class, sc.nextInt());
		
		if(p!=null&&c!=null)
		{
			List<Product>products=c.getProducts();
			products.remove(p);
			c.setProducts(products);
			double totalprice=0;
			for (Product product : products) {
				totalprice=totalprice+(p.getProductPrice()*p.getProductQuantityt());
			}
			c.setCartTotalPrice(totalprice);
			
			updatecart(c, c.getCartid());
			et.begin();//why we use this three lines of code because if u call remove product from cart it only removes the products from inside the cart only if u want to remove product from database also u use this code must
			em.remove(p);
			et.commit();
			return c;
		}
		else
		{
			System.out.println("There is no products from this given id");
			return null;
		}

	}
public void cartcheckout()
{
	Scanner sc=new Scanner(System.in);
  System.out.println("Enter the cart id");
  Cart cid=em.find(Cart.class, sc.nextInt());
  System.out.println("Total price of the  Cart:"+cid.getCartTotalPrice());
  System.out.println(" cash accepeted is:");
  double amt=sc.nextDouble();
  
  while(amt<cid.getCartTotalPrice())
  {
	  System.out.println("<--------pay the whole Amount------->");
	  amt=sc.nextDouble();
  }
  double returnableamount=amt-cid.getCartTotalPrice();
  if(returnableamount>0)
  {
	  System.out.println("Take the return amount  ::"+returnableamount);
	  System.out.println("----Thank you for shopping");
  }
 
  else
  {
	  System.out.println("Thank you for shopping ");
  }
 
}

}
