package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.order.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.annotation.processing.Generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

@Generated(value = "org.junit-tools-1.1.0")
public class DiskTest {

	private Order anOrder;
	private DigitalVideoDisc dvd1;
	private DigitalVideoDisc dvd2;
	private DigitalVideoDisc dvd3;
	
	
	@BeforeEach
    void setUp() throws Exception {
		anOrder = new Order();
		dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);

		dvd2 = new DigitalVideoDisc("Magi", "Animation", "John Hahaha", 90, 20.00f);
		dvd3 = new DigitalVideoDisc("Alladin", "Animation", "John Musker", 90, 18.99f);
		
    }
	
	
	
	
	@Test
	public void testGetLuckyItem() throws Exception {

		anOrder.addDigitalVideoDisc(dvd1,dvd3,dvd3,dvd2);
		DigitalVideoDisc dvdLucky = anOrder.getLuckyItem();
		DigitalVideoDisc [] itemOrder = anOrder.getItemsOrdered();
		int i;
		for (i = 0 ; i < anOrder.getQtyOrdered(); i++)
			if (itemOrder[i].equals(dvdLucky))
			{
				assertEquals(0, itemOrder[i].getCost(), "This is lucky item, the cost must = 0.");
				return;
			}
		assertEquals(i, anOrder.getQtyOrdered(), "No lucky item be chosen. Error.");
			
	}


	@Test
	public void testRemoveDigitalVideoDisc() throws Exception {
		anOrder.addDigitalVideoDisc(dvd1,dvd3,dvd3);
		assertTrue(anOrder.removeDigitalVideoDisc(dvd3) == true, "Remove Error.");
	}


	@Test
	public void testTotalCost() throws Exception {
		anOrder.addDigitalVideoDisc(dvd1,dvd2,dvd3, dvd2);
		float expected = (dvd1.getCost() + 2 * dvd2.getCost() + dvd3.getCost());
		float result = anOrder.totalCost();
		
		assertTrue(result > dvd1.getCost(),"Totalcost should greater than "+ dvd1.getCost());
		assertTrue(result > (dvd1.getCost() + dvd2.getCost() + dvd3.getCost()),"Totalcost should greater.");
		assertEquals(expected, result, "Error in method totalCost");
		
		
		

	}
}

