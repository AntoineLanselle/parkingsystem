package com.parkit.parkingsystem;

import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.integration.config.DataBaseTestConfig;
import com.parkit.parkingsystem.integration.service.DataBasePrepareService;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.model.Ticket;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;

public class TicketDAOTest {
	
	private static TicketDAO ticketDAO;
	private static DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();
	private static DataBasePrepareService dataBasePrepareService;
	
	Ticket ticket = new Ticket();

	@BeforeAll
	private static void setUp() throws Exception {
		ticketDAO = new TicketDAO();
		ticketDAO.dataBaseConfig = dataBaseTestConfig;
		dataBasePrepareService = new DataBasePrepareService();
	}
	
	@BeforeEach
	private void setUpPerTest() throws Exception {
		dataBasePrepareService.clearDataBaseEntries();
		
		ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, false);		
		Date inTime = new Date();
		
		inTime.setTime(System.currentTimeMillis());
		
		ticket.setId(1);
		ticket.setParkingSpot(parkingSpot);
		ticket.setVehicleRegNumber("ABCDE");
		ticket.setPrice(5);
		ticket.setInTime(inTime);
		ticket.setReduction(false);	
	}
	
	@AfterAll
	private static void tearDown() {
		dataBasePrepareService.clearDataBaseEntries();
	}
	
	@Test
	public void saveTicketTest() {		
		ticketDAO.saveTicket(ticket);		
		assertTrue(ticket.equals(ticketDAO.getTicket("ABCDE")));
	}
	
	@Test
	public void getTicketTest() {
		saveTicketTest();		
		assertTrue(ticket.equals(ticketDAO.getTicket("ABCDE")));
	}
	
	@Test
	public void updateTicketTest() {
		saveTicketTest();
		
		Date inTime = new Date();
		ticket.setPrice(10);
		ticket.setOutTime(inTime);
		
		ticketDAO.updateTicket(ticket);
		
		assertTrue(ticketDAO.getTicket("ABCDE").getPrice() == 10);
	}
	
	@Test
	public void getOccurenceTest() {
		saveTicketTest();
		assertTrue(ticketDAO.getOccurence("ABCDE"));
	}

}
