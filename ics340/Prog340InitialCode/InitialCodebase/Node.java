import java.util.*;

// A node of a graph for the Spring 2018 ICS 340 program

public class Node {
	
	Node previousNode;
	private int distTime; // the distance from one point to another
	private int finishTime; // how long it takes in total from one point to another
	private String color; // color of the nodes being visited
	private String nodeType;
	private int key;
	
	private String name;
	private String value;  // The value of the Node which was stored in the value column
	private String abbrev;  // The abbreviation for the Node
	private ArrayList<Edge> outgoingEdges;  
	private ArrayList<Edge> incomingEdges;
	
	public Node(String abbreviation) {
		abbrev = abbreviation;
		value = null;
		name = null;
		color = "white";
		nodeType = "tree";
		distTime = 0;
		finishTime = 0;
		outgoingEdges = new ArrayList<Edge>();
		incomingEdges = new ArrayList<Edge>();
	}
	
	public String getAbbrev() {
		return abbrev;
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getdistTime() {
		return distTime;
	}
	
	public int getFinishTime() {
		return finishTime;
	}
	
	public Node getPreviousNode() {
		return previousNode;
	}
	
	public String getNodeType() {
		return nodeType;
	}
	
	public ArrayList<Edge> getOutgoingEdges() {
		return outgoingEdges;
	}
	
	public ArrayList<Edge> getIncomingEdges() {
		return incomingEdges;
	}
	
	public int getKey() {
		return key;
	}
	
	public void setAbbrev(String abbreviation) {
		abbrev = abbreviation;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setDistTime(int distance) {
		this.distTime = distance;
	}
	
	public void setFinishTime(int finish) {
		this.finishTime = finish;
	}
	
	public void setPreviousNode(Node previousNode) {
		this.previousNode = previousNode;
	}
	
	public void setNodeType(String NodeAttri) {
		this.nodeType = NodeAttri;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public void addOutgoingEdge(Edge e) {
		outgoingEdges.add(e);
	}
	
	public void addIncomingEdge(Edge e) {
		incomingEdges.add(e);
	}
	
}

