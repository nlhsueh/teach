package u03_principles;

import java.util.*;

/**
 * 簡易路徑規劃器 (RoutePlanner)
 * 模擬自駕導航或地圖服務的最短距離計算。
 * 用於展示在複雜圖形網路中，當缺乏 Test Oracle (無法人工計算確切預期數值) 時，
 * 如何利用變質關係 (Metamorphic Relations, MRs) 驗證系統正確性。
 */
public class RoutePlanner {

    /**
     * 路網圖結構 (無向加權圖)
     */
    public static class RoadGraph {
        private final Map<String, Map<String, Double>> adjacencyMap = new HashMap<>();

        public void addEdge(String u, String v, double weight) {
            if (weight < 0) {
                throw new IllegalArgumentException("道路權重不得為負數: " + weight);
            }
            adjacencyMap.computeIfAbsent(u, k -> new HashMap<>()).put(v, weight);
            adjacencyMap.computeIfAbsent(v, k -> new HashMap<>()).put(u, weight);
        }

        public void addNode(String node) {
            adjacencyMap.computeIfAbsent(node, k -> new HashMap<>());
        }

        public Set<String> getNodes() {
            return Collections.unmodifiableSet(adjacencyMap.keySet());
        }

        public Map<String, Double> getNeighbors(String node) {
            return adjacencyMap.getOrDefault(node, Collections.emptyMap());
        }

        /**
         * 建立一個將所有道路權重按比例 k 縮放的新路網圖
         */
        public RoadGraph scaleWeights(double factor) {
            if (factor <= 0) {
                throw new IllegalArgumentException("縮放因子必須為正數");
            }
            RoadGraph scaled = new RoadGraph();
            for (String node : adjacencyMap.keySet()) {
                scaled.addNode(node);
            }
            for (Map.Entry<String, Map<String, Double>> entry : adjacencyMap.entrySet()) {
                String u = entry.getKey();
                for (Map.Entry<String, Double> edge : entry.getValue().entrySet()) {
                    String v = edge.getKey();
                    if (u.compareTo(v) <= 0) { // 避免重複加入無向邊
                        scaled.addEdge(u, v, edge.getValue() * factor);
                    }
                }
            }
            return scaled;
        }

        /**
         * 複製路網圖
         */
        public RoadGraph copy() {
            return scaleWeights(1.0);
        }
    }

    /**
     * 使用 Dijkstra 演算法計算起點到終點的最短距離
     * @return 最短距離，若不可達則回傳 Double.POSITIVE_INFINITY
     */
    public double findShortestDistance(RoadGraph graph, String start, String end) {
        if (!graph.getNodes().contains(start) || !graph.getNodes().contains(end)) {
            return Double.POSITIVE_INFINITY;
        }
        if (start.equals(end)) {
            return 0.0;
        }

        Map<String, Double> distances = new HashMap<>();
        for (String node : graph.getNodes()) {
            distances.put(node, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);

        PriorityQueue<NodeDistance> pq = new PriorityQueue<>(
            Comparator.comparingDouble(nd -> nd.distance)
        );
        pq.add(new NodeDistance(start, 0.0));
        Set<String> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            NodeDistance current = pq.poll();
            String u = current.node;

            if (u.equals(end)) {
                return current.distance;
            }

            if (!visited.add(u)) {
                continue;
            }

            for (Map.Entry<String, Double> edge : graph.getNeighbors(u).entrySet()) {
                String v = edge.getKey();
                double weight = edge.getValue();
                if (!visited.contains(v)) {
                    double newDist = current.distance + weight;
                    if (newDist < distances.get(v)) {
                        distances.put(v, newDist);
                        pq.add(new NodeDistance(v, newDist));
                    }
                }
            }
        }

        return distances.get(end);
    }

    private static class NodeDistance {
        final String node;
        final double distance;

        NodeDistance(String node, double distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
