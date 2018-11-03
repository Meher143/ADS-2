import java.util.Scanner;
/**PAGERANK.**/
class PageRank {
    /**
     * variable.
     */
    private Digraph graph;
    /**
     * variable.
     */
    private double[] a;
    /**
     * variable.
     */
    private int vertices;
    /**
     * @brief [brief description]
     * @details [long description]
     * @param g value
     */
    PageRank(final Digraph g) {
        this.graph = g;
        this.vertices = g.vert();
        a = new double[this.vertices];
    }
    /**
     * @brief [brief description]
     * @details [long description]
     * Time complexity is O(N ^ 2)
     * @param g value
     */
    public void computerank(final Digraph g) {
     double f = (double) vertices;
        for (int i = 0; i < vertices; i++) {
            a[i] = 1 / f;
            //System.out.println(a[i]);
        }
        int temp = vertices;
        while (temp >= 0) {
        for (int i = 0; i < vertices; i++) {
            //Queue q = g.connected(i);
            //int t = q.size();
            if (t == 0) {
                a[i] = 0;
            }

            double t1 = 0;
            while (t > 0) {
                 //int c = (int) q.dequeue();

        //t1 = a[c] / (double) g.outdegree(c);
                t--;
            }
            a[i] = t1;
            }
        temp--;
        }

    }
    /**
     * @brief [brief description]
     * @details [long description]
     * Time complexity is O(N)
     * @return value
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < vertices; i++) {
            str += i + " - " + a[i] + "\n";
        }
        return str;

    }
}
/**pagerank.**/
class WebSearch {

}

/**pagerank.**/
final class Solution {
    /**
     * @brief [brief description]
     * @details [long description]
     */
    private Solution() { }
    /**
     * @brief [brief description]
     * @details [long description]
     * @param args value
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int j = 0;
        Digraph g = new Digraph(n);
        while (j < n) {
            String[] tokens = s.nextLine().split(" ");
            for (int i = 1; i < tokens.length; i++) {
                g.addEdge(Integer.parseInt(tokens[0]),
                    Integer.parseInt(tokens[i]));
            }
            j++;
        }
        System.out.println(g);
        PageRank p = new PageRank(g);
        p.computerank(g);
        System.out.println(p);
        // File path to the web content
        String file = "WebContent.txt";

    }
}