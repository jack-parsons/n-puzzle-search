package src.search;

import java.util.Stack;

public class IDS extends Search {
    private Stack<Node> fringe = new Stack<>();
    private int depthLimit = 0;

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

    public Node findSolution(Node initialNode) throws NoSolutionException {
        while (true) {
            try {
                return super.findSolution(initialNode);
            } catch (NoSolutionException e) {
                depthLimit++;
            }
        }
    }
}