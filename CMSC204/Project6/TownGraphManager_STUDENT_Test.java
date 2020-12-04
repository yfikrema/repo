import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TownGraphManager_STUDENT_Test {
	
	private TownGraphManagerInterface graph;
	private String[] town;

	@BeforeEach
	void setUp() throws Exception {
		
		graph = new TownGraphManager();
		town = new String[12];
		  
		for (int i = 1; i < 12; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[2], 2, "Road_11");
		  graph.addRoad(town[1], town[3], 4, "Road_12");
		  graph.addRoad(town[1], town[5], 6, "Road_13");
		  graph.addRoad(town[3], town[7], 1, "Road_14");
		  graph.addRoad(town[3], town[8], 2, "Road_15");
		  graph.addRoad(town[4], town[8], 3, "Road_16");
		  graph.addRoad(town[6], town[9], 3, "Road_17");
		  graph.addRoad(town[9], town[10], 4, "Road_18");
		  graph.addRoad(town[8], town[10], 2, "Road_19");
		  graph.addRoad(town[5], town[10], 5, "Road_101");
		  graph.addRoad(town[10], town[11], 3, "Road_111");
		  graph.addRoad(town[2], town[11], 6, "Road_121");
	}

	@AfterEach
	void tearDown() throws Exception {
		graph = null;
	}

	
	@Test
	void testGetRoad() {
		assertEquals("Road_121", graph.getRoad(town[2], town[11]));
		assertEquals("Road_14", graph.getRoad(town[3], town[7]));
	}

	@Test
	void testAddTown() {
		assertEquals(false, graph.containsTown("Town_42"));
		graph.addTown("Town_42");
		assertEquals(true, graph.containsTown("Town_42"));
	}

	

}
