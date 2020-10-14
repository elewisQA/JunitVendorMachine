package vendormachine.vendors.item;

public class Snack implements Item{

    public String name;
    private float price;

    public Snack(float creditCost){
        this.price = creditCost;
    }

    public Snack(String name, float creditCost){
        this.name = name;
        this.price = creditCost;
    }
    
	//==================
	//===	Methods
	//==================

    //---[ Getters & Setters ]---
    public Float getPrice(){
        return this.price;
    }
    

    public void setPrice(Float cost){
        this.price = cost;
    }
}
