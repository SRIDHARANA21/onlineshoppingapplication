package DtoClasses;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int Adminid;
	private String AdminName;
	private String AdminEmail;
	private String AdminPassword;
	private long AdminContact;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> items;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getAdminid() {
		return Adminid;
	}

	public void setAdminid(int adminid) {
		Adminid = adminid;
	}

	public String getAdminName() {
		return AdminName;
	}

	public void setAdminName(String adminName) {
		AdminName = adminName;
	}

	public String getAdminEmail() {
		return AdminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		AdminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return AdminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.AdminPassword = adminPassword;
	}

	public long getAdminContact() {
		return AdminContact;
	}

	public void setAdminContact(long adminContact) {
		AdminContact = adminContact;
	}

	@Override
	public String toString() {
		return "Admin [Adminid=" + Adminid + ", AdminName=" + AdminName + ", AdminEmail=" + AdminEmail
				+ ", AdminPassword=" + AdminPassword + ", AdminContact=" + AdminContact + ", items=" + items + "]";
	}

}
