import java.util.ArrayList;

public class Node 
{
	class Node implements Comparable<Node>{
		
	    private String name;
	    private ArrayList<Node> children;
	    private int distance = Integer.MAX_VALUE;
	    private double cost = Integer.MAX_VALUE;
	    private Node parent;
	    private int owner;
	    
	    int index;
	    int x;
	    int y;
	    
	    public Node(String name, ArrayList<Node> children)
	    {
	        this.name = name;
	        this.children = children;
	    }
	    public Node(String name, ArrayList<Node> children, int index)
	    {
	        this.name = name;
	        this.children = children;
	        this.index = index;
	    }
	    public Node(int x, int y)
	    {
	        this.name = "(" + x + "," + y + ")";
	        this.x = x;
	        this.y = y;
	        this.owner = -1;
	        }

	    public ArrayList<Node> getChildren()
	    {
	        return this.children;
	    }

	    public void setChildren(ArrayList<Node> children)
	    {
	        this.children = children;
	    }
	    
	    public int getDistance()
	    {
	    	return this.distance;
	    }
	    public void setDistance(int dist) 
	    {
	    	this.distance = dist;
	    }
	    public Node getParent()
	    {
	    	return this.parent;
	    }
	    public void setParent(Node node)
	    {
	    	this.parent = node;
	    }

	    
	    public String toString()
	    {
	        return this.name;
	    }
	   
	    public double getCost() {
	    	return this.cost;
	    }
	    
	    public void setCost(double cost)
	    {
	    	this.cost = cost;
	    }
	    public void setOwner(int owner)
	    {
	    	this.owner = owner;
	    }
	    public int getOwner()
	    {
	    	return this.owner;
	    }
	    
	    
	    public int compareTo(Node node)
	    {
			return Double.compare(this.cost, node.cost);
	    }



}
