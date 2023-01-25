import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DelivB {

	private File inputFile;
	private File outputFile;
	private PrintWriter output;
	private Graph graph;

	// Constructor - DO NOT MODIFY
	public DelivB(File in, Graph gr) {
		inputFile = in;
		graph = gr;

		// Set up for writing to a file
		try {
			// Use input file name to create output file in the same location
			String inputFileName = inputFile.toString();
			String outputFileName = inputFileName.substring(0, inputFileName.length() - 4).concat("_out.txt");
			outputFile = new File(outputFileName);

			// A Printwriter is an object that can write to a file
			output = new PrintWriter(outputFile);
		} catch (Exception x) {
			System.err.format("Exception: %s%n", x);
			System.exit(0);
		}

		// Calls the method that will do the work of deliverable B
		runDelivB();

		output.flush();
	}

	// *********************************************************************************
	// This is where your work starts
	int time = 0;

	private void runDelivB() {
		Graph graph1 = new Graph();
		for (Node o1 : graph1.getNodeList()) {
			o1.setColor("white");
			o1.setNodeType("Tree");
			o1.setPreviousNode(null);
		}

		time = 0;

		for (Node o1 : graph.getNodeList()) {
			if (o1.getValue().equalsIgnoreCase("S")) { // checks the graph to make sure where "S" is and starts from
				o1.setNodeType("Tree");										// there
				DFS_Visit(o1);
			}
		}

		System.out.println("DFS of Graph");

		System.out.println("");

		System.out.println("Node\t" + "Discs\t" + "Finished\t");
		for (Node newNode : graph.getNodeList()) {
			System.out.println(newNode.getAbbrev() + " \t " + newNode.getdistTime() + " \t " + newNode.getFinishTime());
		}

		System.out.println("");

		System.out.println("Edge\t" + "Type");

		for (Edge newEdgeType : graph.getEdgeList()) { // where each edge points to
			Node u = newEdgeType.getTail();
			Node v = newEdgeType.getHead();
			
			if (u.getdistTime() < v.getdistTime() && u.getFinishTime() > v.getFinishTime() ) { // checks for tree or forward edge
                if ( ( u.getColor().equalsIgnoreCase("white") || u.getdistTime() != 1 ) )
                {
                    System.out.println(u.getAbbrev() + "->" + v.getAbbrev() + "\t" + "Tree");
                }
                else{
                    System.out.println(u.getAbbrev() + "->" + v.getAbbrev() + "\t" +"Foward");
                
                }
            }
			
			else if(u.getdistTime() < v.getdistTime() && u.getFinishTime() > v.getFinishTime()) { // make an attribute
				System.out.println(u.getAbbrev() + "->" + v.getAbbrev() + "\t" + "Forward");
			} else if (u.getdistTime() > v.getdistTime() && u.getFinishTime() < v.getFinishTime()) { // checks for//
																										// back
				// v.setNodeType("Back");
				System.out.println(u.getAbbrev() + "->" + v.getAbbrev() + "\t" + "Back");
			} else if ((v.getdistTime() < v.getFinishTime()) || (u.getdistTime() < u.getFinishTime())) { // checks //
																											// for // //
																											// cross
				// v.setNodeType("Cross");
				System.out.println(u.getAbbrev() + "->" + v.getAbbrev() + "\t" + "Cross");
			}
			
		}

	}

	public void DFS_Visit(Node n1) {
		// n1 = node 1
		// n2 = node 2
		// e1 = edge 1

		time = time + 1;
		n1.setDistTime(time);
		n1.setColor("Gray");

		Collections.sort(n1.getOutgoingEdges(), new EdgeComparator());

		for (Edge e1 : n1.getOutgoingEdges()) {
			Node n2 = e1.getHead();
			if (n2.getColor().equalsIgnoreCase("White")) { // checks the node if it's color white if it is then perform
				n2.setNodeType("tree"); // DFS
				n2.setPreviousNode(n1);
				DFS_Visit(n2);
			}
		}
		n1.setColor("Black"); // after DFS it sets the node to color black
		time = time + 1; // increments the time by 1
		n1.setFinishTime(time); // gets the total time or finish time

	}

	private class EdgeComparator implements Comparator<Edge> {
		public int compare(Edge o1, Edge o2) {
			// make a if else statement
			if (o1.getDistance() < o2.getDistance()) {
				return -1;
			}
			if (o1.getDistance() > o2.getDistance()) {
				return 1;
			} else {
				return 0;
			}
		}
	}

}
