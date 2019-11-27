package src.search;

import java.util.PriorityQueue;

public class AStar extends Search {
    private PriorityQueue<Node> fringe = new PriorityQueue<>();

    public Node getNextNode() {
        return fringe.poll();
    }

    public void addNode(Node node) {
        fringe.add(node);
    }
}