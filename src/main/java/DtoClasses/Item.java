package DtoClasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Itemid;
	private String ItemName;
	private String ItemDescreption;
	private double ItemPrice;
	private int ItemQuantityt;

	public int getItemid() {
		return Itemid;
	}

	public void setItemid(int itemid) {
		Itemid = itemid;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public String getItemDescreption() {
		return ItemDescreption;
	}

	public void setItemDescreption(String itemDescreption) {
		ItemDescreption = itemDescreption;
	}

	public double getItemPrice() {
		return ItemPrice;
	}

	public void setItemPrice(double itemPrice) {
		ItemPrice = itemPrice;
	}

	public int getItemQuantityt() {
		return ItemQuantityt;
	}

	public void setItemQuantityt(int itemQuantityt) {
		ItemQuantityt = itemQuantityt;
	}

	@Override
	public String toString() {
		return "Item [Itemid=" + Itemid + ", ItemName=" + ItemName + ", ItemDescreption=" + ItemDescreption
				+  ", ItemPrice=" + ItemPrice + ", ItemQuantityt=" + ItemQuantityt + "]";
	}

}
