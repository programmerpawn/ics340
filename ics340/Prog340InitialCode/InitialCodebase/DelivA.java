import java.io.*;
import java.util.Collections;
import java.util.Comparator;

public class DelivA {

	private File inputFile;
	private File outputFile;
	private PrintWriter output;
	private Graph graph;

	// Constructor - DO NOT MODIFY
	public DelivA(File in, Graph gr) {
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

		// Calls the method that will do the work of deliverable A
		runDelivA();

		output.flush();
	}

	// *********************************************************************************
	// This is where your work starts

	private void runDelivA() {
		// Delete these lines when you add functionality
		Collections.sort(graph.getNodeList(), new NodeComparer()); // sort alphabetically

		Collections.sort(graph.getNodeList(), new NodeCompareSizeIn()); // order from biggest to smallest for ingoing
																		// edges
		System.out.println("Indegree: ");
		for (Node myNodein : graph.getNodeList()) {
			System.out.println("Node " + myNodein.getAbbrev() + " has outdegree " + myNodein.getIncomingEdges().size());
		}

		System.out.println(" ");

		Collections.sort(graph.getNodeList(), new NodeCompareSizeOut()); // order from biggest to smallest for outgoing
																			// edges
		System.out.println("Outdegree: ");
		for (Node myNode : graph.getNodeList()) {
			System.out.println("Node " + myNode.getAbbrev() + " has outdegree " + myNode.getOutgoingEdges().size());
		}

	}

	private class NodeComparer implements Comparator<Node> {// sort alphabetically
		public int compare(Node o1, Node o2) {
			return o1.getAbbrev().compareToIgnoreCase(o2.getAbbrev());
		}
	}

	private class NodeCompareSizeIn implements Comparator<Node> {// order from biggest to smallest
		public int compare(Node o1, Node o2) {
			// make a if else statement
			if (o1.getIncomingEdges().size() < o2.getIncomingEdges().size()) {
				return 1;
			}
			if (o1.getIncomingEdges().size() > o2.getIncomingEdges().size()) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	private class NodeCompareSizeOut implements Comparator<Node> {// order from biggest to smallest
		public int compare(Node o1, Node o2) {
			// make a if else statement
			if (o1.getOutgoingEdges().size() < o2.getOutgoingEdges().size()) {
				return 1;
			}
			if (o1.getOutgoingEdges().size() > o2.getOutgoingEdges().size()) {
				return -1;
			} else {
				return 0;
			}
		}
	}

}
