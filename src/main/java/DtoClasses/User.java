package DtoClasses;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int Userid;
	private String UserName;
	private String UserEmail;
	private String UserPassword;
	private long UserContact;
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public long getUserContact() {
		return UserContact;
	}
	public void setUserContact(long userContact) {
		UserContact = userContact;
	}
	@Override
	public String toString() {
		return "User [Userid=" + Userid + ", UserName=" + UserName + ", UserEmail=" + UserEmail + ", UserPassword="
				+ UserPassword + ", UserContact=" + UserContact + ", cart=" + cart + "]";
	}
	
	
}
