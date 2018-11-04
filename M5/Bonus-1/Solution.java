import java.util.Scanner;
/**
 * class for Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String[] num = s.nextLine().split(" ");
        int vertices = Integer.parseInt(num[0]);
        int edges = Integer.parseInt(num[1]);
        if (edges == 0) {
            System.out.println(edges);
        } else {
            Graph graph = new Graph(vertices + 1);
            while (s.hasNext()) {
                String[] lines = s.nextLine().split(" ");
                graph.addEdge(Integer.parseInt(lines[0]),
                    Integer.parseInt(lines[1]));
            }
            CC obj = new CC(graph);
            int[] idarr = obj.idarr();
            int count = 0;
            int finalcount = 0;
            int id = 0;
            for (int i = 0; i < graph.vertices(); i++) {
                if (graph.hasParallelEdges(i)) {
                    count++;
                }
                int idcnt = 0;
                id = idarr[i];
                //System.out.println(id);
                for (int j = 0; j < idarr.length; j++) {
                    if (id == idarr[j]) {
                        idcnt++;
                    }
                }
                if (finalcount < idcnt) {
                    finalcount = idcnt;
                }
            }
            System.out.println(count + finalcount);
            }
        }
    }
