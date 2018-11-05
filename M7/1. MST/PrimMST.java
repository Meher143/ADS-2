/**
 * Class for primitive mst.
 */
public class PrimMST {
    /**
     * { var_description }.
     */
    private static final double FLOATING_POINT_EPSILON = 1E-12;
    /**
     * { var_description }.
     */

    private Edge[] edgeTo;
    /**
     * { item_description }.
     */// edgeTo[v] = shortest edge from tree vertex to non-tree vertex
    private double[] distTo;
    /**
     * { item_description }.
     */// distTo[v] = weight of shortest such edge
    private boolean[] marked;
    /**
     * { item_description }.
     */
    // marked[v] = true if v on tree, false otherwise
    private IndexMinPQ<Double> pq;

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     * @param g the edge-weighted graph
     */
    public PrimMST(final EdgeWeightedGraph g) {
        edgeTo = new Edge[g.vertex()];
        distTo = new double[g.vertex()];
        marked = new boolean[g.vertex()];
        pq = new IndexMinPQ<Double>(g.vertex());
        for (int v = 0; v < g.vertex(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        for (int v = 0; v < g.vertex(); v++) {
            if (!marked[v]) {
                prim(g, v);
            }
                assert check(g);
            // run from each vertex to find
          // minimum spanning forest

        // check optimality conditions
        }
    }

    /**
     * { function_description }.
     *
     * @param      g     { parameter_description }.
     * @param      s     { parameter_description }.
     */

    private void prim(final EdgeWeightedGraph g, final int s) {
        distTo[s] = 0.0;
        pq.insert(s, distTo[s]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            scan(g, v);
        }
    }
    /**
     * { function_description }.
     *
     * @param      g     { parameter_description }.
     * @param      v     { parameter_description }.
     */
    private void scan(final EdgeWeightedGraph g, final int v) {
        marked[v] = true;
        for (Edge e : g.adj(v)) {
            int w = e.other(v);
            if (marked[w]) {
                continue;
            }         // v-w is obsolete edge
            if (e.weight() < distTo[w]) {
                distTo[w] = e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.decreaseKey(w, distTo[w]);
                }
                else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    /**
     * Returns the edges in a minimum spanning tree (or forest).
     * @return the edges in a minimum spanning tree (or forest) as
     *    an iterable of edges
     */
    public Iterable<Edge> edges() {
        Queue<Edge> mst = new Queue<Edge>();
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
            if (e != null) {
                mst.enqueue(e);
            }
        }
        return mst;
    }

    /**
     * Returns the sum of the edge weights in a M S T(or forest).
     * @return the sum of the edge weights in a M S T(or forest).
     */
    public double weight() {
        double weight = 0.0;
        for (Edge e : edges()) {
            weight += e.weight();
        }
        return weight;
    }

    // check optimality conditions (takes time proportional to E V lg* V)

    /**
     * { function_description }.
     *
     * @param      g     { parameter_description }.
     *
     * @return     { description_of_the_return_value }.
     */
    private boolean check(final EdgeWeightedGraph g) {

        // check weight
        double totalWeight = 0.0;
        for (Edge e : edges()) {
            totalWeight += e.weight();
        }
        if (Math.abs(totalWeight - weight()) > FLOATING_POINT_EPSILON) {
            System.err.printf("Weight of edges does not equal weight(): %f vs. %f\n", 
                totalWeight, weight());
            return false;
        }

        // check that it is acyclic
        UF uf = new UF(g.vertex());
        for (Edge e : edges()) {
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w)) {
                System.err.println("Not a forest");
                return false;
            }
            uf.union(v, w);
        }

        // check that it is a spanning forest
        for (Edge e : g.edges()) {
            int v = e.either(), w = e.other(v);
            if (!uf.connected(v, w)) {
                System.err.println("Not a spanning forest");
                return false;
            }
        }

        // check that it is a M S F (cut optimality conditions).
        for (Edge e : edges()) {

            // all edges in MST except e
            uf = new UF(g.vertex());
            for (Edge f : edges()) {
                int x = f.either(), y = f.other(x);
                if (f != e) {
                uf.union(x, y); 
               }
            }

            // check that e is min weight edge in crossing cut
            for (Edge f : g.edges()) {
                int x = f.either(), 
                y = f.other(x);
                if (!uf.connected(x, y)) {
                    if (f.weight() < e.weight()) {
                        System.err.println("Edge " + f + " violates cut optimality conditions");
                        return false;
                    }
                }
            }

        }

        return true;
    }
}