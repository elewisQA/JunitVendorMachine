package vendormachine.users.util;

public class Wallet {

    private String brand = "Generic";
    private float credit = 0.5f; // using f after a decimal value treats it the as a float(rather than a double)

    public Wallet(){}

    public Wallet(float startCredit) {
        this.brand = "Generic";
        this.credit = startCredit; // using f after a decimal value treats it the as a float(rather than a double)
    }

    public Wallet(String brandName, float startCredit) {
        this.brand = brandName;
        this.credit = startCredit; // using f after a decimal value treats it the as a float(rather than a double)
    }

	//==================
	//===	Methods
	//==================

    public void addCredit(float credit){
        this.credit += credit;
    }
    
    public float takeCredit(float retrieve) {
        if(retrieve > this.credit){
            //TODO replace 'Sys.out's with Log4j
            System.out.println("Warning: request exceeds value in wallet!");
            System.out.println("Request: " + retrieve + ",\tstored value: " + retrieve);

            return 0;
        }else {
        	this.credit -= retrieve;
        	
            return retrieve;
        }
    }
    
    //===============================
    //===  'get'ors
    //===============================

    public float getCredit(){
        return this.credit;
    }

    public String getBrand() {
        return this.brand;
    }

    //===============================
    //===  'set'ors
    //===============================
    public void setCredit(float credit){
        this.credit = credit;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }
}
