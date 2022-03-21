
public class Receipt 
{
	private Store store;
	private int numberOfItems;
	private double totalAmountSpent;
	private String receiptID;
	public static final int DEFAULT_NUMBER_OF_ITEMS = 1;
	
	public Receipt(Store store, int numberOfItems, double totalAmountSpent, String receiptId)
	{
		this.store = store;
		this.numberOfItems = numberOfItems;
		this.totalAmountSpent = totalAmountSpent;
		this.receiptID = receiptId;
	}
	
	public Receipt(Store store, double totalAmountSpent, String receiptId)
	{
		this(store, DEFAULT_NUMBER_OF_ITEMS, totalAmountSpent, receiptId);
	}
	
	// setters
	public void setStore(Store store)
	{
		this.store = store;
	}
	public void setNumberOfItems(int numberOfItems)
	{
		this.numberOfItems = numberOfItems;
	}
	public void setTotalAmountSpent(double totalAmountSpent)
	{
		this.totalAmountSpent = totalAmountSpent;
	}
	public void setReceiptId(String receiptId)
	{
		this.receiptID = receiptId;
	}
	
	//getters
	public Store getStore()
	{
		return store;
	}
	public int getNumberOfItems()
	{
		return numberOfItems;
	}
	public double getTotal()
	{
		return totalAmountSpent;
	}
	public String getReceiptID()
	{
		return receiptID;
	}
	
	//toString
	public String toString()
	{
		return "store: " + store.toString() + "\n" 
				+((numberOfItems == DEFAULT_NUMBER_OF_ITEMS) ? "item: " : "items: ") +numberOfItems + "\n"
				+"total: $" + totalAmountSpent + "\n" 
				+"receipt ID: " +receiptID;
	}
	
	//equals
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Receipt)
		{
			Receipt other = (Receipt) obj;
			return this.store.equals(other.store) &&
				   this.numberOfItems == other.numberOfItems &&
				   Math.abs(this.totalAmountSpent - other.totalAmountSpent) < 0.00001 &&
				   this.receiptID.equalsIgnoreCase(other.receiptID);
		}
		else
		{
			return false;
		}
		
	}
	
	public static boolean idMeetsCriteria(String receiptID, char firstTarget, char secondTarget, int countOfSecondAfterFirst)	
	{
		try
		{
			int startIndex = receiptID.indexOf(firstTarget);
			int occurrence= 0;
			
			for (int i=startIndex+1; i<receiptID.length();i++)
			{
				if(receiptID.charAt(i) == secondTarget)
					occurrence++;
			}
			
		if((countOfSecondAfterFirst == occurrence) && (receiptID.charAt(startIndex) == firstTarget))	
			{
			return true;
			}
		else
			{
			return false;
			}
						
		}
		catch(Exception e)
		{
			return false;
		}
	
	}
}
