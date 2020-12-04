import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Town implements Comparable<Town> {

	private String name;
	private Town templateTown;
	private LinkedList<Town> shortestPath;
	private Map<Town, Integer> adjacentTowns;
	private Integer distance;

	public Town(String name) {
		this.name = name;
		this.adjacentTowns = new HashMap<Town, Integer>();
		this.shortestPath = new LinkedList<Town>();
	}

	public Town(Town templateTown) {
		this.setTemplateTown(templateTown);
	}

	public boolean equals(Object obj) {
		Town t = (Town) obj;
		return this.name.compareTo(t.name) == 0;

	}

	public String getName() {
		return name;

	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getDistance() {
		return distance;
	}

	public int hashCode() {
		return name.hashCode();

	}

	public String toString() {
		return "Town:" + name;

	}

	public Map<Town, Integer> getAdjacentTowns() {
		return adjacentTowns;
	}

	public void setAdjTowns(Map<Town, Integer> AdjTowns) {
		this.adjacentTowns = AdjTowns;
	}

	public void addAdjacentTown(Town destinationTown, int distance) {
		this.adjacentTowns.put(destinationTown, distance);
	}

	@Override
	public int compareTo(Town o) {

		if (name.compareToIgnoreCase(o.name) < 0)
			return -1;
		else if (name.compareToIgnoreCase(o.name) > 0)
			return 1;
		else
			return 0;
	}

	public LinkedList<Town> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(LinkedList<Town> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public Town getTemplateTown() {
		return templateTown;
	}

	public void setTemplateTown(Town templateTown) {
		this.templateTown = templateTown;
	}
}
