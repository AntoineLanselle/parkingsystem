package com.parkit.parkingsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.model.ParkingSpot;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingSpotTest {

	static ParkingSpot parkingSpot;

	@BeforeEach
	private void setUpPerTest() {
		parkingSpot = new ParkingSpot(1, ParkingType.CAR, true);
	}

	@Test
	public void getIdTest() {
		assertTrue(parkingSpot.getId() == 1);
	}
	
	@Test
	public void setIdTest() {
		parkingSpot.setId(5);
		assertTrue(parkingSpot.getId() == 5);
	}
	
	@Test
	public void getParkingTypeTest() {
		assertTrue(parkingSpot.getParkingType() == ParkingType.CAR);
	}
	
	@Test
	public void setParkingTypeTest() {
		parkingSpot.setParkingType(ParkingType.BIKE);
		assertTrue(parkingSpot.getParkingType() == ParkingType.BIKE);
	}
	
	@Test
	public void getAvailableTest() {
		assertTrue(parkingSpot.isAvailable());
	}
	
	@Test
	public void setAvailableTest() {
		parkingSpot.setAvailable(false);
		assertTrue(!parkingSpot.isAvailable());
	}
	
	@Test
	public void equalsTest() {
		ParkingSpot parkingSpot2;
		ParkingSpot parkingSpot3;
		parkingSpot2 = new ParkingSpot(1, ParkingType.CAR, true);
		parkingSpot3 = new ParkingSpot(3, ParkingType.BIKE, false);
		
		assertTrue(parkingSpot.equals(parkingSpot2));
		assertFalse(parkingSpot.equals(parkingSpot3));
	}

}
