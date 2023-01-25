//import java.util.*;

// Edge between two nodes
public class Edge {
	
	private int distance;
	private int finish;
	private Node tail;
	private Node head;
	
	public Edge(Node tailNode, Node headNode, int distanceTime) {
		tail = tailNode;
		head = headNode;
		
		distance = distanceTime;
	}
	
	public Node getTail() {
		return tail;
	}
	
	public Node getHead() {
		return head;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public int getFinish() {
		return finish;
	}
	
	public void setTail(Node newTail) {
		tail = newTail;
	}
	
	public void setHead(Node newHead) {
		head = newHead;
	}
	
	public void setDistance(int dist) {
		distance = dist;
	}
	
	public void setFinish(int fini) {
		finish = fini;
	}
	
}
