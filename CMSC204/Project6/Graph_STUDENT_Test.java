import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Graph_STUDENT_Test {
	
	private GraphInterface<Town,Road> graph;
	private Town[] town;

	@BeforeEach
	void setUp() throws Exception {
		
		 graph = new Graph();
		  town = new Town[12];
		  
		  for (int i = 1; i < 12; i++) {
			  town[i] = new Town("Town_" + i);
			  graph.addVertex(town[i]);
		  }
		  
		  graph.addEdge(town[1], town[2], 2, "Road_11");
		  graph.addEdge(town[1], town[3], 4, "Road_12");
		  graph.addEdge(town[1], town[5], 6, "Road_13");
		  graph.addEdge(town[3], town[7], 1, "Road_14");
		  graph.addEdge(town[3], town[8], 2, "Road_15");
		  graph.addEdge(town[4], town[8], 3, "Road_16");
		  graph.addEdge(town[6], town[9], 3, "Road_17");
		  graph.addEdge(town[9], town[10], 4, "Road_18");
		  graph.addEdge(town[8], town[10], 2, "Road_19");
		  graph.addEdge(town[5], town[10], 5, "Road_101");
		  graph.addEdge(town[10], town[11], 3, "Road_111");
		  graph.addEdge(town[2], town[11], 6, "Road_121");
	}

	@AfterEach
	void tearDown() throws Exception {
		graph = null;
	}

	@Test
	void testGetEdge() {
		assertEquals(false, graph.containsEdge(town[1], town[11]));
		graph.addEdge(town[1], town[11], 1, "Road_131");
		assertEquals(true, graph.containsEdge(town[1], town[1]));
	}

	@Test
	void testAddEdge() {
		assertEquals(false, graph.containsEdge(town[2], town[4]));
		graph.addEdge(town[2], town[4], 1, "Road_133");
		assertEquals(true, graph.containsEdge(town[2], town[4]));
	}

}
