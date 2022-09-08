package Assessment_First;
import java.util.*;

//creating custom exception 
class OutOfStockMapException extends Exception{
	public OutOfStockMapException (String str) {
		super(str);
	}
}

//main class
public class Shop1 {
	 int key = 1;
     int key1 = 1, Small=0, Medium=0, Large=0;
     long startTime;
     long endTime;
     long durationInNano;
     Map<Integer, Shoes> Shoes_Map = new HashMap<>();
     Map<Integer, Cloths> Cloth_Map = new HashMap<>();
   public static void main(String[] args) {
	new Shop1().call();
	new Shop1().calling();
	new Shop1().calling1();
  }

public void call() {
	Scanner sc =  new Scanner(System.in);
	Integer choich = -1;
	Integer s_choich = -1;
	
	do {
		System.out.println("1. SHOES ");
		System.out.println("2. CLOTHS ");
		System.out.println("0. QUITE ");
		System.out.println("ENTER YOUR CHOICH: ");
		choich = sc.nextInt();
		switch(choich) {
		case 0:
			System.exit(0);
			System.out.println("Thank you for sopping with us..");
		case 1:
			calling();
			break;
		case 2:
			calling1();
			break;
		}
	}while(choich == 0);
  }

public void calling1() {
	Scanner sc = new Scanner(System.in);
	Integer c_choich = -1;
	do {
		System.out.println("1. ADD NEW ClOTH BRAND ");
		System.out.println("2. VIEW AVAILABLE ");
		System.out.println("3. MAIN MENU");
		System.out.println("ENTER YOUR CHOICH: ");
	    c_choich = sc.nextInt();
		switch(c_choich) {
		case 1:
			try {
				AddNewCloths();
			}catch(OutOfStockMapException ex) {
				System.out.println("Exception cought: "+ex+"\n");
			}
			call();
			break;
		case 2:
			try {
				ViewAvailableCloths();	
			}catch(OutOfStockMapException ex) {
				System.out.println("Exception cought: "+ex+"\n");
			}
			call();
			break;
		default :
			call();
		}
	}while(c_choich == 3);
	
}
public void calling() {
	Scanner sc = new Scanner(System.in);
	Integer s_choich=-1;
	do {
		System.out.println("1. ADD NEW SHOES ");
		System.out.println("2. VIEW AVAILABLE ");
		System.out.println("3. ENTER 3 FOR MAIN MENU\n");
		System.out.println("ENTER YOUR CHOICH: ");
	    s_choich = sc.nextInt();
		switch(s_choich) {
		case 1:
			try {
			   AddNewShoes();
			}catch(OutOfStockMapException ex) {
				System.out.println("Exceptio cought: "+ex+"\n");
			}
			calling();
	       break;
		case 2:
			try {
				ViewAvailableShoes();	
			}catch(OutOfStockMapException ex) {
				System.out.println("Exception found: "+ex+"\n");
			}
			calling();
			break;
		default :
			call();
			break;
		}
	}while(s_choich == 3);
}
public  void AddNewCloths()throws OutOfStockMapException {
    Scanner scn = new Scanner(System.in);
    if(key1 <= 5) {	
    startTime = System.nanoTime();
    
    System.out.println("Enter Cloth Name: ");
    String clothName = new String(scn.nextLine());
    
    System.out.println("Enter quantity for S-Size ");
    Integer small  = scn.nextInt();
    if(small <=5 ) {}
    else { System.out.println("Quantity should be <= 5"); call();}
    
    System.out.println("Enter quantity for M-Size ");
    Integer medium = scn.nextInt();
    if(medium <=5 ) {}
    else { System.out.println("Quantity should be <= 5"); call();}
    
    System.out.println("Enter quantity for L-Size ");
    Integer large = scn.nextInt();
    if(large <=5 ) {}
    else { System.out.println("Quantity should be <= 5"); call();}
    
    System.out.println("Enter quantity for XL-Size ");
    Integer xtraLarge = scn.nextInt();
    if(xtraLarge <=5 ) {}
    else { System.out.println("Quantity should be <= 5"); call();}
    
    Cloths newCloth = new Cloths(clothName,small,medium,large,xtraLarge);
    Cloth_Map.put(key1, newCloth);
    
    endTime = System.nanoTime();
    durationInNano = (endTime - startTime);
    System.out.println("Total Execution time in nano seconds: "+durationInNano);
    key1++;
    System.out.println("Successfully added... \n");
    calling1();
    }
    else {
       throw new OutOfStockMapException("Map is full you can't add now");
    }
}


public void AddNewShoes()throws OutOfStockMapException {
    Scanner scan = new Scanner(System.in);
    
    if(key <= 5){
    	startTime = System.nanoTime();
    	
    	System.out.println("Enter Shoes Name: ");
    	String shoesName = scan.nextLine();
    	
        System.out.println("Enter quantity for S-Size ");
        Integer small  = scan.nextInt();
        if(small <=5 ) {}
        else { System.out.println("Quantity should be <= 5"); call();}
        
        System.out.println("Enter quantity for M-Size ");
        Integer medium = scan.nextInt();
        if(medium <=5 ) {}
        else { System.out.println("Quantity should be <= 5"); call();}
        
        System.out.println("Enter quantity for L-Size ");
        Integer large = scan.nextInt();
        if(large <=5 ) {}
        else { System.out.println("Quantity should be <= 5"); call();}
        
        Shoes newShoes = new Shoes(shoesName, small, medium, large);
        Shoes_Map.put(key, newShoes);
        endTime = System.nanoTime();
        durationInNano = (endTime - startTime);
        System.out.println("Total Execution time in nano seconds: "+durationInNano);
        key++;
        System.out.println("Successfully added... \n");
     }
    calling();
   }

public void ViewAvailableShoes() throws OutOfStockMapException {
	Scanner sc = new Scanner(System.in);
	if(Shoes_Map.isEmpty()) {
        System.out.println("Empty....\n");
    }
    else {
        System.out.println("Available Shoes.. ");
        for(Map.Entry<Integer, Shoes> entry:Shoes_Map.entrySet()) {
            int   k = entry.getKey();
            Shoes s = entry.getValue();
            System.out.print(k+" ");
            System.out.print(s.ShoesName+"\n");
        }
        System.out.println("Enter your brand: ");
        String brand = sc.nextLine();
        switch(brand) {
        case "puma":
        	delete(brand);
        	calling();
        	break;
        case "adidas":
        	delete(brand);
        	calling();
        	break;
        case "nike":
            delete(brand);
            calling();
        	break;
        case "bata":
        	delete(brand);
        	calling();
        	break;
        case "reebok":
        	delete(brand);
        	calling();
        	break;
        default:
       		System.out.println("this brand is not available ");
       		calling();
    }
   }
 }
public void delete(String brand)throws OutOfStockMapException {
	// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	System.out.println("Available size with quantity..");
	
	for(Map.Entry<Integer, Shoes> entry:Shoes_Map.entrySet()) {
        Shoes s = entry.getValue();
        System.out.print("\nS="+s.S+"\nM="+s.M+"\nL="+s.L+"\n");
        
        System.out.println("Enter your size: ");
    	String size = sc.nextLine();
        if(size.equalsIgnoreCase("s") && s.S>0) {
            s.S--;
            System.out.println("Available in Stock");
            Shoes newShoes = new Shoes(brand, s.S, s.M, s.L);
            Shoes_Map.replace(key, newShoes);
            break;
        }
        else if(size.equalsIgnoreCase("m") && s.M>0) {
        	s.M--;
        	System.out.println("Available in Stock");
        	Shoes newShoes = new Shoes(brand, s.S, s.M, s.L);
            Shoes_Map.replace(key, newShoes);
            break;
        }
        else if(size.equalsIgnoreCase("l") && s.L>0) {
        	s.L--;
        	System.out.println("Available in Stock");
        	Shoes newShoes = new Shoes(brand, s.S, s.M, s.L);
            Shoes_Map.replace(key, newShoes);
            break;
        }    
        else
        {
        	throw new OutOfStockMapException("Out Of Stock.\n");
        }
    }
}

public void ViewAvailableCloths()throws OutOfStockMapException {
	Scanner sc = new Scanner(System.in);
	if(Cloth_Map.isEmpty()) {
        System.out.println("Empty....\n");
    }
    else {
        System.out.println("Available Cloth.. ");
        for(Map.Entry<Integer, Cloths> entry:Cloth_Map.entrySet()) {
            int   k = entry.getKey();
            Cloths s = entry.getValue();
            System.out.print(k+" ");
            System.out.print(s.Cloth_Name+"\n");
        }
        System.out.println("Enter your brand: ");
        String brand = sc.nextLine();
        switch(brand) {
        case "jeans":
        	cloth_delete(brand);
        	calling1();
        	break;
        case "shirt":
        	cloth_delete(brand);
        	calling1();
        	break;
        case "jacket":
        	cloth_delete(brand);
        	calling1();
        	break;
        case "sweater":
        	cloth_delete(brand);
        	calling1();
        	break;
        case "shari":
        	cloth_delete(brand);
        	calling1();
        	break;
          default:
       		System.out.println("this brand is not available ");
       		call();
       }
     }
   }

public void cloth_delete(String brand) throws OutOfStockMapException {
	// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	for(Map.Entry<Integer, Cloths> entry:Cloth_Map.entrySet()) {
        Cloths s = entry.getValue();
        System.out.print("\nS="+s.S+"\nM="+s.M+"\nL="+s.L+"\nXL="+s.XL+"\n");
        
        String brand1 = s.Cloth_Name;
        System.out.println("Enter your size: ");
    	String size = sc.nextLine();
    	
    	if(brand1.equalsIgnoreCase(brand)) {
        if(size.equalsIgnoreCase("s") && s.S>0) {
            s.S--;
            System.out.println("Available in Stock"); 
        }
        else if(size.equalsIgnoreCase("m") && s.M>0) {
            s.M--;
            System.out.println("Available in Stock");  
        }
        else if(size.equalsIgnoreCase("l") && s.L>0) {
        	s.L--;
        	System.out.println("Available in Stock");   
        }
        else if(size.equalsIgnoreCase("xl") && s.XL>0) {
        	s.XL--;
        	System.out.println("Available in Stock");
        }
        else
        {
        	throw new OutOfStockMapException("Out Of Stock.\n");
        }
        Cloths newShoes = new Cloths(brand, s.S, s.M, s.L,s.XL);
        Cloth_Map.replace(key, newShoes);
        calling1();
        break;
      }
    }
  }
}