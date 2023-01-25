import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static java.lang.Math.min;

public class DelivD {

	private static final int ArrayList = 0;
	private static final int Node = 0;
	private File inputFile;
	private File outputFile;
	private PrintWriter output;
	private Graph graph;

	// Constructor - DO NOT MODIFY
	public DelivD(File in, Graph gr) {
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

		// Calls the method that will do the work of deliverable D
		runDelivD();

		output.flush();
	}

	// *********************************************************************************
	// This is where your work starts

	private void runDelivD() {
		// looking for the distance between two nodes not edges
		// try node1 tail and compare it to the node2 tail
		// get the incoming and the outgoing nodes

		Collections.sort(graph.getEdgeList(), new EdgeCompare());
		int total = 0;
		for (Node myNodein : graph.getNodeList()) {

			total += bitonic(0, 1, graph.getNodeList());
		}
		System.out.println("Shortest bitonic tour has distance: " + total);
	}

	private int bitonic(int i, int j, ArrayList<Node> nodeList) {
		if (i == 0) {
			if (j == 0) {
				return 0;
			}
			if (j == 1) {
				return getDistance(nodeList.get(0), nodeList.get(1));
			}
		}

		if (i == j - 1) {
			int min_dist = Integer.MAX_VALUE;
			int dist;
			for (int k = 0; k < j - 1; k++) {
				dist = bitonic(k, i, nodeList) + getDistance(nodeList.get(k), nodeList.get(j));
				if (dist < min_dist) {
					min_dist = dist;
				}
			}
			return min_dist;
		}

		if (i < j - 1) {
			return bitonic(i, j - 1, nodeList) + getDistance(nodeList.get(i - 1), nodeList.get(j));
		}
		
		return bitonic(i -1, j, nodeList) + getDistance(nodeList.get(i - 1), nodeList.get(j));

	}

	private int getDistance(Node o1, Node o2) {
		return 0;
	}

	private class EdgeCompare implements Comparator<Edge> {
		public int compare(Edge edgeOfOne, Edge edgeOfTwo) {
			if (edgeOfOne.getDistance() > edgeOfTwo.getFinish()) {
				return -1;
			} else if (edgeOfOne.getDistance() < edgeOfTwo.getFinish()) {
				return 1;
			} else {
				return 0;
			}
		}
	}


}
