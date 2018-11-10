import java.util.Scanner;
/**
 * Class for solution.
 */

public class Solution {
/**
 * Constructs the object.
 */

private Solution() {

}
/**
 * main function.
 *
 * @param      args  The arguments
 */

    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = Integer.parseInt(sc.nextLine());
        int edges = Integer.parseInt(sc.nextLine());
        EdgeWeightedGraph edgeGraph = new EdgeWeightedGraph(vertices);
        while (edges > 0) {
            String[] tokens = sc.nextLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            double weight = Double.parseDouble(tokens[2]);
            Edge e = new Edge(a, b, weight);
            edgeGraph.addEdge(e);
            edges--;
        }

        // Self loops are not allowed...
        // Parallel Edges are allowed...
        // Take the Graph input here...

        String caseToGo = sc.nextLine();
        switch (caseToGo) {
        case "Graph":
            //Print the Graph Object.
        System.out.println(edgeGraph);
            break;

        case "DirectedPaths":
            // Handle the case of DirectedPaths, where two integers are given.
            // First is the source and second is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            String[] tokens = sc.nextLine().split(" ");
            int source = Integer.parseInt(tokens[0]);
            int destination = Integer.parseInt(tokens[1]);
            DijkstraUndirectedSP objectDSP = 
            new DijkstraUndirectedSP(edgeGraph, source);
            if (objectDSP.hasPathTo(destination)) {
                System.out.println(objectDSP.distTo(destination));
            } else {
                System.out.println("No path Found.");
            }


            break;

        case "ViaPaths":
            // Handle the case of ViaPaths, where three integers are given.
            // First is the source and second is the via is the one where path should pass throuh.
            // third is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            System.out.println("No Path Found.");
            break;

        default:
            break;
        }

    }
}
