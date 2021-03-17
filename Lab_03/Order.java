
public class Order {
	
	public static final int MAX_NUMBERS_ORDERED = 10;
	
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0;
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered > MAX_NUMBERS_ORDERED) {
			System.out.println("The order is almost full");
		}
		this.itemsOrdered[qtyOrdered] = disc;
		qtyOrdered += 1;
		System.out.println("The disc " + disc.getTitle() + "has been added.");
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i = 0; i < qtyOrdered; i++)
		{
			if (itemsOrdered[i].equals(disc))
			{
				for(int j = i; j < qtyOrdered -1 ; j++)
					itemsOrdered[i] = itemsOrdered[i+1];
				break;
			}
		}
		qtyOrdered -= 1;
	}
	public void printListOrder()
	{
		for (int i = 0; i < qtyOrdered; i++)
			System.out.println("Title : " + itemsOrdered[i].getTitle());
		
	}
	public float totalCost()
	{
		float total_cost = 0;
		for (int i = 0; i < qtyOrdered; i++)
		{
			total_cost += itemsOrdered[i].getCost();
		}
		return total_cost;
	}


	
}
