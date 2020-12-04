import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> {

	private Set<Town> towns;
	private Set<Road> roads;
	private Map<String, Town> prevTown;

	public Graph() {

		towns = new HashSet<Town>();
		roads = new HashSet<Road>();
		this.prevTown = new HashMap<>();
	}

	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {

		for (Road r : roads) {
			if ((sourceVertex.equals(r.getSource()) || sourceVertex.equals(r.getDestination()))
					&& (destinationVertex.equals(r.getDestination()) || destinationVertex.equals(r.getSource())))

			{
				return r;
			}
		}
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

		if (containsEdge(sourceVertex, destinationVertex)) {
			return null;
		}
		if (!containsVertex(sourceVertex) || !containsVertex(destinationVertex)) {
			throw new IllegalArgumentException();
		}
		if (sourceVertex == null || destinationVertex == null || description == null) {
			throw new NullPointerException();
		}

		Road r = new Road(sourceVertex, destinationVertex, weight, description);
		roads.add(r);

		return r;
	}

	@Override
	public boolean addVertex(Town v) {
		towns.add(v);
		if (containsVertex(v)) {
			return false;
		}
		if (v == null) {
			throw new NullPointerException();
		}
		return true;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for (Road r : roads) {
			if ((sourceVertex.equals(r.getSource()) || sourceVertex.equals(r.getDestination()))
					&& (destinationVertex.equals(r.getDestination()) || destinationVertex.equals(r.getSource()))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		for (Town t : towns) {
			if (t.equals(v)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Set<Road> edgeSet() {

		return roads;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {

		Set<Road> road = new HashSet<>();

		if (!containsVertex(vertex)) {
			throw new IllegalArgumentException();
		}
		if (vertex == null) {
			throw new NullPointerException();
		}
		for (Road r : roads) {
			if (r.getSource().equals(vertex) || r.getDestination().equals(vertex)) {
				road.add(r);
			}
		}
		return road;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

		Road removeE = new Road(sourceVertex, destinationVertex, weight, description);
		Road foundE = null;
		for (Road r : roads) {
			if (r.equals(removeE)) {
				foundE = r;
				break;
			}
		}
		if (foundE != null) {
			roads.remove(foundE);
		}
		return foundE;
	}

	@Override
	public boolean removeVertex(Town v) {

		return towns.remove(v);
	}

	@Override
	public Set<Town> vertexSet() {

		return towns;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {

		ArrayList<String> path = new ArrayList<>();
		dijkstraShortestPath(sourceVertex);
		Town newTown = destinationVertex;
		while (!newTown.equals(sourceVertex)) {
			if (!prevTown.containsKey(newTown.getName())) {
				path.clear();
				break;
			}
			Town parentTown = prevTown.get(newTown.getName());
			Road r = getEdge(parentTown, newTown);
			path.add(0, parentTown.getName() + " via " + r.getName() + " to " + newTown.getName() + " " + r.getWeight()
					+ " mi");
			newTown = parentTown;
		}
		return path;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		Set<Town> explored = new HashSet<>();
		List<Town> unvisitedTown = new ArrayList<>();
		HashMap<String, Integer> cost = new HashMap<>();
		prevTown.clear();

		for (Town t : towns) {
			unvisitedTown.add(t);
			cost.put(t.getName(), Integer.MAX_VALUE);
			prevTown.put(t.getName(), null);
		}
		cost.put(sourceVertex.getName(), 0);
		System.out.println(unvisitedTown);
		System.out.println(cost + "\n");
		while (!unvisitedTown.isEmpty()) {
			int lowestCostIndex = 0;

			for (int i = 1; i < unvisitedTown.size(); i++) {
				Town unvisitedVertex = unvisitedTown.get(i);

				if (cost.get(unvisitedVertex.getName()) < cost.get(unvisitedTown.get(lowestCostIndex).getName())) {
					lowestCostIndex = i;
				}
			}
			Town lowestCostVertex = unvisitedTown.remove(lowestCostIndex);
			explored.add(lowestCostVertex);
			if (cost.get(lowestCostVertex.getName()) == Integer.MAX_VALUE) {
				return;
			}
			for (Road r : edgesOf(lowestCostVertex)) {
				Town neighbor = r.getDestination();

				if (neighbor.equals(lowestCostVertex)) {
					neighbor = r.getSource();
				}

				if (explored.contains(neighbor)) {
					continue;
				}

				int adjacentCost = cost.get(lowestCostVertex.getName()) + r.getWeight();

				if (adjacentCost < cost.get(neighbor.getName())) {
					cost.put(neighbor.getName(), adjacentCost);
					prevTown.put(neighbor.getName(), lowestCostVertex);
				}
			}
		}
	}

	private void findMinDistance(Town adjTown, Integer edgedistance, Town currentTown) {

		Integer sourceTownDistance = currentTown.getDistance();
		if (sourceTownDistance + edgedistance < adjTown.getDistance()) {
			adjTown.setDistance(sourceTownDistance + edgedistance);
			LinkedList<Town> sp = new LinkedList<>(currentTown.getShortestPath());
			sp.add(currentTown);
			adjTown.setShortestPath(sp);
		}

	}

	private Town getLowestDistanceTown(Set<Town> set2) {

		Town lDTown = null;
		int lDistance = Integer.MAX_VALUE;
		for (Town town : set2) {
			int tDistance = town.getDistance();
			if (tDistance < lDistance) {
				lDistance = tDistance;
				lDTown = town;
			}
		}
		return lDTown;
	}

}
