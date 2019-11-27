package src.search;

import java.util.Stack;

public class DFS extends Search {
    private Stack<Node> fringe = new Stack<>();

    @Override
    boolean isRandom() {
        return true;
    }

    public Node getNextNode() {
        return fringe.pop();
    }

    public void addNode(Node node) {
        fringe.add(node);
    }
}