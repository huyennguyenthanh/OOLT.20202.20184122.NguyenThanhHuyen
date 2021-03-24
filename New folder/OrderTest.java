import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import javax.annotation.processing.Generated;

// import org.junit.Test;

@Generated(value = "org.junit-tools-1.1.0")
public class OrderTest {


	@Test
	public void testRemoveDigitalVideoDisc() throws Exception {
		
		Order anOrder = new Order();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin", "Animation", "John Musker", 90, 18.99f);
		
		
		anOrder.addDigitalVideoDisc(dvd1,dvd3,dvd3);
		assertTrue(anOrder.removeDigitalVideoDisc(dvd1) == true, "Remove Error.");
	}
}