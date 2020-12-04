public class Road implements Comparable<Road> {

	private Town source, destination;
	private int degrees;
	private String name;

	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		this.degrees = degrees;
		this.name = name;

	}

	public Town getSource() {
		return source;
	}

	public void setSource() {
		this.source = source;
	}

	public void setDestination() {
		this.destination = destination;
	}

	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.degrees = 1;
		this.name = name;
	}

	public boolean contains(Town town) {
		return (source.compareTo(town) == 0 || destination.compareTo(town) == 0);

	}

	public boolean equals(Object r) {

		return false;

	}

	public Town getDestination() {
		return destination;

	}

	public String getName() {
		return name;

	}

	public int getWeight() {
		return degrees;

	}

	public String toString() {
		return "Road{" + "Source=" + source + ",Destination=" + destination + ",Name=" + name + ",Distance="
				+ degrees + "}";

	}

	@Override
	public int compareTo(Road o) {
		if (degrees > o.degrees) {
			return 1;
		} else if (degrees < o.degrees) {
			return -1;
		}
		return 0;
	}

}
