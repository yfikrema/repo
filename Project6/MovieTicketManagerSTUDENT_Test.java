

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieTicketManagerSTUDENT_Test {
	private MovieTicketManager ticketList;
	

	@Before
	public void setUp() throws Exception {
		ticketList = new MovieTicketManager();
		
		
		
		
		//Student add adult tickets
		ticketList.addTicket("Deadpool", "NR", 2, 12, "NONE", "Adult", 0);
		ticketList.addTicket("Show Dogs", "PG13", 5, 19, "IMAX", "Adult", 0);
		//Student add children tickets
		ticketList.addTicket("Black Panther", "PG13", 1, 12, "3D", "Child", 0);
		ticketList.addTicket("Little Mermaid", "G", 3, 14, "IMAX", "Child", 0);
		//Student add employee tickets
		ticketList.addTicket("Solo", "PG13", 2, 14, "NONE", "Employee", 12345);
		ticketList.addTicket("Infinity", "G", 6, 14, "NONE", "Employee", 45698);
		//Student add MoviePass member tickets
		ticketList.addTicket("Book Club", "PG", 5, 8, "IMAX", "MoviePass", 55555);
		ticketList.addTicket("Fight Club", "R", 13, 13, "IMAX", "MoviePass", 45612);
	}

	@After
	public void tearDown() throws Exception {
		//Student set ticketList to null;
		
	}

	/**
	 * Student Test the number of visits to the theater within the month
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumVisits() {
		
		
		
		
		
	
		//Student test Employees' number of visits
		assertEquals(1,ticketList.numVisits(12345));
		ticketList.addTicket("Arrow", "NR", 12,12,"3D","MoviePass",12345);
		assertEquals(2,ticketList.numVisits(12345));
		ticketList.addTicket("Eagle Eye", "R", 6,12,"IMAX","MoviePass",12345);
		assertEquals(3,ticketList.numVisits(12345));
		
	
		//Student test MoviePass members' number of visits
		assertEquals(1,ticketList.numVisits(55555));
		ticketList.addTicket("Arrow", "NR", 12,12,"3D","MoviePass",55555);
		assertEquals(2,ticketList.numVisits(55555));
		ticketList.addTicket("Eagle Eye", "R", 6,12,"IMAX","MoviePass",55555);
		assertEquals(3,ticketList.numVisits(55555));
	
	}

	/**
	 * Student Test the number of times this movie has been viewed
	 * This only applied to those who have id numbers - Employees or MoviePass members
	 */
	@Test
	public void testNumThisMovie() {
		
		//Student test Employees' number of views
		ticketList.addTicket("Arrow", "NR", 12,12,"3D","MoviePass",12345);
		assertEquals(1,ticketList.numThisMovie(12345,"Arrow"));
		ticketList.addTicket("Solo", "PG13", 7,19,"NONE","Employee",12345);
		assertEquals(2,ticketList.numThisMovie(12345,"Solo"));
		ticketList.addTicket("Solo", "PG13", 9,19,"NONE","Employee",12345);
		assertEquals(3,ticketList.numThisMovie(12345,"Solo"));
		//Student test MoviePass members' number of views
		
		ticketList.addTicket("Deadpool", "NR", 4,12,"NONE","MoviePass",33333);
		assertEquals(1,ticketList.numThisMovie(33333,"Deadpool"));
		
		ticketList.addTicket("Deadpool", "NR", 6,12,"NONE","MoviePass",33333);
		assertEquals(2,ticketList.numThisMovie(33333,"Deadpool"));
	}

}
