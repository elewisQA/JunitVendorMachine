package vendormachine.vendors.item;

public interface Item {
	
	public static String name = "";
	public static float price = 0;
    
	//==================
	//===	Methods
	//==================
	
    public Float getPrice();
    public void setPrice(Float cost);

}
