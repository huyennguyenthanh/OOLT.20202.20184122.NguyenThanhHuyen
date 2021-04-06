package hust.soict.hedspi.aims.media;

import javax.annotation.processing.Generated;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

import org.junit.jupiter.api.BeforeEach;

@Generated(value = "org.junit-tools-1.1.0")
public class DigitalVideoDiscTest {

	

	@Test
	public void testSearchTitle() throws Exception {
		DigitalVideoDisc dvd = new DigitalVideoDisc("Harry and Potter and the Secret Room");
		assertEquals(true, dvd.searchTitle("Potter Harry"), " Error in method searchTitle.");
		
		assertEquals(true, dvd.searchTitle("Room secret"), " Error in method searchTitle.");
	}
}