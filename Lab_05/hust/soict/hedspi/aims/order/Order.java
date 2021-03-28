package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.utils.MyDate;


public class Order {
	
	public static final int MAX_NUMBERS_ORDERED = 5;
	public static final int MAX_LIMITED_ORDERS = 5;
	
	private DigitalVideoDisc itemsOrdered[];
	private int qtyOrdered;
	private MyDate dateOrderd;
	
	private static int nbOrders = 0;
	
	public Order()
	{
		this.itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		this.qtyOrdered = 0;
		this.dateOrderd = new MyDate();
		nbOrders++;
		
	}
	public Order(String date)
	{
		if (nbOrders > MAX_LIMITED_ORDERS)
		{
			System.out.println("Over limited number of orders.");
			return;
			
		}
		this.itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		this.qtyOrdered = 0;
		this.dateOrderd = new MyDate(date);
		nbOrders++;
		
	}
	
	public int getQtyOrdered() {
		return this.qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	public DigitalVideoDisc[] getItemsOrdered() {
		return itemsOrdered;
	}
	
	public void setItemsOrdered(DigitalVideoDisc[] itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}
	
	public MyDate getDateOrderd() {
		return dateOrderd;
	}
	public void setDateOrderd(MyDate dateOrderd) {
		this.dateOrderd = dateOrderd;
	}
	
	public static int getNbOrders() {
		return nbOrders;
	}
	public static void setNbOrders(int nbOrders) {
		Order.nbOrders = nbOrders;
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (this.qtyOrdered > MAX_NUMBERS_ORDERED) {
			System.out.println("The dvd " + disc.getTitle( ) + " could not be added.");
			System.out.println("The item quantity has reached its limit.");
			return;
		}
		this.itemsOrdered[qtyOrdered] = disc;
		qtyOrdered += 1;
		System.out.println("Add " + disc.getTitle() + " succesfully.");
	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2)
	{
		if ((MAX_NUMBERS_ORDERED - qtyOrdered) < 2)
		{
			System.out.println("Not enough slot for 2 dics.");
			return;
		}
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc ...dvdList)
	{
		//if full, not add any disc.
		
		if (dvdList != null && dvdList.length <= (MAX_NUMBERS_ORDERED - this.qtyOrdered))
		{
			for (DigitalVideoDisc dvd : dvdList)
				this.addDigitalVideoDisc(dvd);
		}
		else
			System.out.println("Cannot be added order because of full ordered items");
		
	}
	
	public boolean removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i = 0; i < this.qtyOrdered; i++)
		{
			if (this.itemsOrdered[i].equals(disc))
			{
				for(int j = i; j < this.qtyOrdered -1 ; j++)
					this.itemsOrdered[i] = this.itemsOrdered[i+1];
				this.qtyOrdered -= 1;
				System.out.println("Deleted " + disc.getTitle() + " successfully!");
				return true;
			}
		}
		System.out.println("This disc does not exist!");
		return false;
		
	}
	public void printListOrder()
	{
		System.out.println("****************ORDER************");
		dateOrderd.print();
		System.out.println("Ordered Items : ");
		
		for (int i = 0; i < qtyOrdered; i++)
		{
			System.out.print("DVD : " + this.itemsOrdered[i].getTitle());
			System.out.print(" -  " + this.itemsOrdered[i].getCategory());
			System.out.print(" -  " + this.itemsOrdered[i].getDirector());
			System.out.print(" -  " + this.itemsOrdered[i].getLength());
			System.out.println(" - " + this.itemsOrdered[i].getCost() + "$");
		}
		
		System.out.println("Total Cost : " + this.totalCost());
		System.out.println("****************************");
		
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
	
	private int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	public DigitalVideoDisc getLuckyItem() {
		
		int n = getRandomNumber(0, this.getQtyOrdered());
		System.out.println(n);
		this.itemsOrdered[n].setCost(0);
		return this.itemsOrdered[n];
		
	}



	
}
