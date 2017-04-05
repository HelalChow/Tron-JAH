//Jia Hua Zhu
//3/10/2017
//AP Java Node Class

import java.util.ArrayList;

public class Node implements Comparable<Node> {
	private String nodeName; 										
	private Node prevCity;					 						
	private int index; 												
	private int distance = Integer.MAX_VALUE; 						
	private ArrayList<Node> childrenNodes = new ArrayList<Node>();
	private int x;
	private int y;
	private double cost; //in this simulation, all nodes have the same cost

	public Node(String name, ArrayList<Node> nextNode) {
		this.nodeName = name;
		this.childrenNodes = nextNode;
	}	

	public Node(String cityName, ArrayList<Node> nextCity, int index) {
		this.nodeName = cityName;
		this.childrenNodes = nextCity;
		this.index = index;
	}
	
	public Node(int row, int column) {
		this.x = row;
		this.y = column;
		this.nodeName = ("(" + x + ", " + y + ")");
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}
	
	public void setCost(double nodeCost) {
		this.cost = nodeCost;
	}
	
	public double cost() {
		return this.cost;
	}
	
	public void setChildren(ArrayList<Node> cities) {
		this.childrenNodes = cities;
	}

	public ArrayList<Node> getChildren() {
		return childrenNodes;
	}
	
	public void setDistance(int dist) {
		this.distance = dist;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public String toString() {
		return nodeName;
	}
	
	public void setParent(Node lastCity) {
		this.prevCity = lastCity;
	}
	
	public Node getParent() {
		return prevCity;
	}
	
	public int getIndex() {
		return index;
	}

	public int compareTo(Node o) {
		if(this.cost > o.cost) return 1;
		else if(this.cost < o.cost) return -1;
		else return 0;
	}
}