import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.Assert.*;
public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //PriorityQueue<>

        HashMap<Integer, List<int[]>> nodeToNeighborWithWeight = new HashMap<>();
        for (int[] edge : flights) {
            int node = edge[0];
            if (nodeToNeighborWithWeight.containsKey(node)) {
                nodeToNeighborWithWeight.get(node).add(edge);
            } else {
                List<int[]> list = new ArrayList<>();
                list.add(edge);
                nodeToNeighborWithWeight.put(node, list);
            }
        }
        int returnedVal = dijkstra(nodeToNeighborWithWeight);
        return 0;
    }

    private int dijkstra(HashMap<Integer, List<int[]>> nodeToNeighborWithWeight) {
        return 0;
    }
}
