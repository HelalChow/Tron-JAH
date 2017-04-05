//Jia Hua Zhu
//3/10/2017
//AP Java Node Class

import java.util.ArrayList;

public class Node implements Comparable<Node> {
	private String nodeName; 										
	private Node parent;					 						
	private int index; 												
	private int distance = Integer.MAX_VALUE;
	private double cost = Integer.MAX_VALUE;
	private ArrayList<Node> childrenNodes = new ArrayList<Node>();
	private int x;
	private int y;
	private int owner;
	
	public Node(int row, int column) {
		this.x = row;
		this.y = column;
		this.nodeName = ("(" + x + ", " + y + ")");
		this.owner = -1;
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
		return this.childrenNodes;
	}
	
	public void setDistance(int dist) {
		this.distance = dist;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setParent(Node prevNode) {
		this.parent = prevNode;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public int getIndex() {
		return index;
	}

	public String toString() {
		return this.nodeName;
	}
	
    public void setOwner(int owner)
    {
    	this.owner = owner;
    }
    public int getOwner()
    {
    	return this.owner;
    }
    
    
	public int compareTo(Node o) {
		return Double.compare(this.cost, o.cost);
	}
}