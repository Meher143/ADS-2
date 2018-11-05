import java.util.Scanner;
/**
 * { item_description }.
 */
final class Solution {
/**
 * Constructs the object.
 */
private Solution() {

}
/**
 * { item_description }.
 */
/**
 * { function_description }.
 *
 * @param      args  The arguments
 */
public static void main(final String[] args) {
Scanner sc = new Scanner(System.in);
int vertices = Integer.parseInt(sc.nextLine());
int edges = Integer.parseInt(sc.nextLine());
EdgeWeightedGraph ewg = new EdgeWeightedGraph(vertices);
while (sc.hasNextLine()) {
String[] tokens = sc.nextLine().split(" ");
Edge e = new Edge(Integer.parseInt(tokens[0]),
Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
ewg.addEdge(e);
}
PrimMST pmst = new PrimMST(ewg);
System.out.printf("%.5f", pmst.weight());
}
}
