import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class TownGraphManager implements TownGraphManagerInterface {

	private Graph graph;

	public TownGraphManager() {
		this.graph = new Graph();
	}

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {

		return graph.addEdge(new Town(town1), new Town(town2), weight, roadName) != null;
	}

	@Override
	public String getRoad(String town1, String town2) {
		Road r = graph.getEdge(new Town(town1), new Town(town2));

		if (r == null) {
			return null;
		}

		return r.getName();
	}

	@Override
	public boolean addTown(String v) {

		return graph.addVertex(new Town(v));
	}

	@Override
	public Town getTown(String name) {
		Town town = null;
		for (Town t : graph.vertexSet()) {
			if (t.getName().equals(name)) {
				town = t;
			}
		}
		return town;
	}

	@Override
	public boolean containsTown(String v) {

		return graph.containsVertex(new Town(v));
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {

		return graph.containsEdge(new Town(town1), new Town(town2));
	}

	@Override
	public ArrayList<String> allRoads() {

		ArrayList<String> list = new ArrayList<>();
		for (Road r : graph.edgeSet()) {
			if (!list.contains(r.getName())) {
				list.add(r.getName());
			}
		}
		Collections.sort(list);
		return list;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {

		return graph.removeEdge(new Town(town1), new Town(town2), 1, road) != null;
	}

	@Override
	public boolean deleteTown(String v) {

		return graph.removeVertex(new Town(v));
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> list = new ArrayList<>();

		for (Town t : graph.vertexSet()) {
			if (!list.contains(t.getName())) {
				list.add(t.getName());
			}
		}
		Collections.sort(list);
		return list;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {

		return graph.shortestPath(new Town(town1), new Town(town2));
	}

	public void populateTownGraph(File selectedFile) {
		// TODO Auto-generated method stub

	}

}
