
public class DigitalReceipt extends Receipt {
	
	private String email;

	public DigitalReceipt(Store store, int numberOfItems, double totalAmountSpent, String receiptId, String email) 
	{
		super(store, numberOfItems, totalAmountSpent, receiptId);
		this.email = email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return email;
	}
	
    public static boolean validateEmail(String email)
    {
        boolean hasChar = false; 
        boolean hasDot = false; 
        boolean hasThreeLetter = false;
        try{
            int index = email.indexOf('@');
            
            for(int i=0; i < index ; i++) 
            {
              if ((email.charAt(i) >= 'a') && (email.charAt(i) <= 'z'))
            	hasChar = true;
            }

            hasDot = (-1 != email.lastIndexOf("."));

            hasThreeLetter =(email.length()-1 - email.lastIndexOf(".") == 3);
                 
            return (hasChar && hasDot && hasThreeLetter);  

        }
        catch(Exception e)
        {
            return false;
        }
    } 
}
