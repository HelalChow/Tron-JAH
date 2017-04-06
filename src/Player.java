import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {
    static int myX0 = 0;
    static int myX1 = 0;
    static int myY0 = 0;
    static int myY1 = 0;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int height = 20;
        int width = 30;
        Node[][] map = new Node[width][height];
        
        for (int i = 0; i < width; i++)
        {
        	for (int j = 0; j < height; j++)
        	{
        		map[i][j] = new Node(i,j);        	
        	}
        }
        	
        // game loop
        while (true) {
            int N = in.nextInt(); // total number of players (2 to 4).
            int P = in.nextInt(); // your player number (0 to 3).
            for (int i = 0; i < N; i++) {
                int X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                int Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                int X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                int Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)
                map[X1][Y1].setOwner(i);
                map[X0][Y0].setOwner(i);
                if (i==P) {
                    myX1 = X1;
                    myY1 = Y1;
                }
            }
            //System.err.println(X1);
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            boolean moved = false;
            if(myX1 < width-1)
            {
            	if(map[myX1+1][myY1].getOwner() == -1)
            	{
            		System.out.println("RIGHT"); // A single line with UP, DOWN, LEFT or RIGHT
            		moved = true;
            	}
            }
            if(myX1 > 0 && !moved)
            {
            	if (map[myX1-1][myY1].getOwner() == -1)
            	{
            		System.out.println("LEFT");
            		moved = true;
            	}
            }
            if(myY1 < height-1 && !moved)
            {
            	if(map[myX1][myY1+1].getOwner() == -1)
            	{
            		System.out.println("DOWN");
            		moved = true;
            	}
            }
            if(myY1 > 0 && !moved)
            {
            	if(map[myX1][myY1-1].getOwner() == -1)
            	{
            		System.out.println("UP");
            		moved = true;
            	}
            }
        }
    }
}

class Node implements Comparable<Node> {
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