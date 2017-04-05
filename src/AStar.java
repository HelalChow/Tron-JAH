/*Jia Hua Zhu
 *AP Java 4/3/2017
 *AStar search
 */

import java.util.PriorityQueue;
import java.util.ArrayList;

public class AStar {
	
	private Node start;
	private Node goal;
	private Node[][] nodeGrid;
	private int[][] costGrid; 
	private int gridSize;
	
	public AStar(Node begin, Node end, int[][] grid, int size) {
		this.start = begin;
		this.goal = end;
		this.gridSize = size;
		this.costGrid = grid;
		
		this.nodeGrid = new Node[size][size]; //node 2d array
		this.nodeGrid[start.x()][start.y()] = start;
		this.nodeGrid[goal.x()][goal.y()] = goal;
		for(int x = 0; x < size; x++) {
			for(int y = 0; y < size; y++) {
				if(nodeGrid[x][y] != start && nodeGrid[x][y] != goal) {
					nodeGrid[x][y] = new Node(x,y);
					nodeGrid[x][y].setCost(calcDist(nodeGrid[x][y]));
				}
			}
		}
	}
	
	/** Returns the euclidean distance from start to goal*/
	public double calcDist(Node current) {
		return Math.sqrt(Math.pow(goal.x()-current.x(),2) + Math.pow(goal.y()-current.y(),2));
	}
	
	/** Uses the grid to determine available directions and returns those nodes as a list*/
	public ArrayList<Node> getChildren(Node current) {
		int x = current.x();
		int y = current.y();
		ArrayList<Node> children = new ArrayList<Node>();
		if(y < gridSize-1) {
			if(costGrid[x][y+1] != 0){
				children.add(nodeGrid[x][y+1]);
			}
		}
		if(x < gridSize-1) {
			if(costGrid[x+1][y] != 0){
				children.add(nodeGrid[x+1][y]);
			}
		}
		if(x > 0) {
			if(costGrid[x-1][y] != 0){
				children.add(nodeGrid[x-1][y]);
			}
		}
		if(y > 0) {
			if(costGrid[x][y-1] != 0){
				children.add(nodeGrid[x][y-1]);
			}
		}
		return children;
	}
	
	public boolean search() {
		
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>();
		pQueue.add(this.start);
		ArrayList<Node> visited = new ArrayList<Node>();
		
		while(!pQueue.isEmpty()) {
			Node current = pQueue.remove();
			if(current.equals(this.goal)) {
				visited.add(current);
				printPath(current);
				System.out.println("Shortest path found!");
				return true;
			}
			else {
				for(Node child : getChildren(current)) {
					if(!pQueue.contains(child) && !visited.contains(child)) { //child is new
						child.setCost(current.cost() + child.cost());
						child.setParent(current);
						pQueue.add(child);
					}
					else if(child.cost() > current.cost()) { //child has been there before
						child.setCost(current.cost() + child.cost());
						child.setParent(current);
					}
				}
				visited.add(current);
			}
		}
		System.out.println("No path found...");
		return false;
	}
	
	public void printPath(Node goal) {
		while (goal.getParent() != null) {
			System.out.print(goal + " <-- ");
			goal = goal.getParent();
		}
		System.out.println(goal);
	}
}