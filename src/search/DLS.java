package src.search;

import java.util.Stack;

public class DLS extends Search {
    private Stack<Node> fringe = new Stack<>();
    private int depthLimit;

    DLS (int depthLimit) {
        this.depthLimit = depthLimit;
    }

    /**
     * DFS needs the order the nodes are added to the queue to be random for an infinite depth
     * This is to stop it getting trapped in a cycle, for example contiguously going left.
     */
    @Override
    boolean isRandom() {
        return true;
    }

    public Node getNextNode() {
        if (!fringe.empty())
            return fringe.pop();
        else
            return null;
    }

    public void addNode(Node node) {
        if (node.getDepth() <= depthLimit)
            fringe.add(node);
    }
}