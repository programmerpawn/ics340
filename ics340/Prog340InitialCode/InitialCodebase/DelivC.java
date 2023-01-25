import java.io.*;
import java.util.*;

public class DelivC {

	private File inputFile;
	private File outputFile;
	private PrintWriter output;
	private Graph graph;

	// Constructor - DO NOT MODIFY
	public DelivC(File in, Graph gr) {
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

		// Calls the method that will do the work of deliverable C
		runDelivC();

		output.flush();
	}

	// *********************************************************************************
	// This is where your work starts

	private void runDelivC() {

		Graph opgraph = new Graph();

		for (Node vertex : opgraph.getNodeList()) {
			MST_Prim(opgraph, vertex);
		}

		// Make a for loop for the graph to print it out
		// Call MST_Prim(Graph(Graph),Weight(INT),Starting_point(NODE));
		// key needs to be a getter and setter in NODE class

	}

	// u is the tail
	// v is the head
	// Node r is the number of nodes in the graph
	private void MST_Prim(Graph graph1, Node start) { // graph of the node has to be in the function
		// make key a node??
		Graph graph2 = new Graph();
		Node o1 = new Node(null);

		o1.getKey();
		for (Node vertex : graph2.getNodeList()) {
			if (vertex.getValue().equalsIgnoreCase("S")) {
				vertex.setKey(10000000);// sets the nodes to infinite
				vertex.setPreviousNode(null);
			}
		}

		o1.setKey(0);

		Collections.sort(o1.getOutgoingEdges(), new EdgeComparator()); // <-- fix this
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>();// <-- fix this

		for (Node nodeToQ : graph.getNodeList()) {
			pQueue.add(nodeToQ);
		}

		Node node1 = new Node(null);
		while (!pQueue.isEmpty()) {
			int min = Integer.MAX_VALUE, min_index = -1;
			pQueue.remove(min_index); // grabs and removes the min
			for (Edge edge1 : node1.getOutgoingEdges()) {
				Node node2 = edge1.getHead();
				if (pQueue.add(node1) && edge1.getDistance() < edge1.getHead().getKey()) { // needs to compare key to
																							// the distance e1 needs to
																							// be
					// part of the queue
					node2.setPreviousNode(null);
					System.out.println("The minimum spanning tree has a total cost of " + pQueue
							+ "and includes the following edges: "); // needs to set key
				}
			}
		}
	}

	private class EdgeComparator implements Comparator<Edge> {
		public int compare(Edge o1, Edge o2) {
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
