package Controller;

import java.util.Scanner;

import DaoClasses.Shopping;
import DtoClasses.Item;

public class MainController {
	public static void main(String[] args) {
		Shopping sp=new Shopping();
		boolean flag=true;
		while(flag)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter :|\n"
					+"1 CREATE ADMIN \n"
					+"2 ADD ITEM \n"
					+"3 DELETE ITEM \n"
					+"4 SAVE USER \n"
					+"5 SAVE PRODUCT \n"
					+"6 DELETE PRODUCT  \n "
					+"7 CARTCHEKOUT \n ");
			int option=sc.nextInt();
	        switch (option) {
			case 1:
				sp.saveadmin();
				break;
			case 2:
			sp.saveitem();
			    break;
			case 3:
			sp.deleteitem();
			    break;
			case 4:
				sp.saveuser();
		    break;
			case 5:
				sp.addproducttocart();
		    break;
			case 6:
				sp.removeproductfromcart();
		    break;
			case 7:
				sp.cartcheckout();
		    break;
			
			default:
				
				break;
			}
		}
	}

}
