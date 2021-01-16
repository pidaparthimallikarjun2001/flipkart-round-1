import java.util.*;
public class MaximumSumComponent {

    static class Edge {
        int src;
        int nbr;
        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
        public String toString() {
            return src + " " + nbr;
        }
    }

    public static void getConnectedComponents(ArrayList<ArrayList<Edge>> graph, int src, ArrayList<Integer> component, boolean[] visited) {
        visited[src] = true;
        component.add(src);
        for(Edge edge: graph.get(src)) {
            if(!visited[edge.nbr]) {
                getConnectedComponents(graph, edge.nbr, component, visited);
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>(V);
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++) {
            graph.add(new ArrayList<Edge>());
        }

        for(int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            v1 -= 1;
            int v2 = sc.nextInt();
            v2 -= 1;

            graph.get(v1).add(new Edge(v1, v2));
            graph.get(v2).add(new Edge(v2, v1));
        }

        ArrayList<ArrayList<Integer>> connectedComponents = new ArrayList<>();

        //Taking values of each vertex
        int[] values = new int[V];
        for(int i = 0; i < V; i++) {
            values[i] = sc.nextInt();
        }

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                getConnectedComponents(graph, i, component, visited);
                connectedComponents.add(component);
            }
        }
        //System.out.println(connectedComponents);

        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < connectedComponents.size(); i++) {
            int currentSum = 0;
            for(int j = 0; j < connectedComponents.get(i).size(); j++) {

                currentSum += values[connectedComponents.get(i).get(j)];

            }
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);

    }
}
