package hust.soict.hedspi.aims.order;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

import hust.soict.hedspi.aims.utils.MyDate;


public class Order {
	
	public static final int MAX_NUMBERS_ORDERED = 5;
	public static final int MAX_LIMITED_ORDERS = 5;
	
	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private int qtyOrdered;
	private MyDate dateOrderd;
	
	private static int nbOrders = 0;
	
	public Order()
	{
		if (nbOrders > MAX_LIMITED_ORDERS)
		{
			System.out.println("Over limited number of orders.");
			return;
			
		}
		
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
	public void addMedia(Media media){
        this.itemsOrdered.add(media);
    }

    public void removeMedia(Media media){
        this.itemsOrdered.remove(media);
    }
	public void printListOrder()
	{
		System.out.println("****************ORDER************");
		dateOrderd.print();
		System.out.println("Ordered Items : ");
		
		for (int i = 0; i < qtyOrdered; i++)
		{
			System.out.print("DVD : " + this.itemsOrdered.get(i).getTitle());
			System.out.print(" -  " + this.itemsOrdered.get(i).getCategory());
			System.out.println(" - " + this.itemsOrdered.get(i).getCost() + "$");
		}
		
		System.out.println("Total Cost : " + this.totalCost());
		System.out.println("****************************");
		
	}
	public float totalCost()
	{
		float total_cost = 0;
		for (Media o : itemsOrdered)
		{
			total_cost += o.getCost();
		}
		return total_cost;
	}
	
	private int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	public Media getLuckyItem() {
		
		int n = getRandomNumber(0, this.getQtyOrdered());
		System.out.println(n);
		this.itemsOrdered.get(n).setCost(0);
		return this.itemsOrdered.get(n);
		
	}



	
}
