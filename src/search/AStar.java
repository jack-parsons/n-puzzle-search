package src.search;

import java.util.PriorityQueue;

public class AStar extends Search {
    private PriorityQueue<Node> fringe = new PriorityQueue<>();
    int i = 0;

    public Node getNextNode() {
        i ++;
        System.out.println(i);
        return fringe.poll();
    }

    public void addNode(Node node) {
        fringe.add(node);
    }
}