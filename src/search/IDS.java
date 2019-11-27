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

    @Override
    public Solution findSolution(Node initialNode) throws NoSolutionException {
        int nodesExplored = 0;
        while (true) {
            try {
                Solution sol = super.findSolution(initialNode);
                nodesExplored += sol.getNodesExplored();
                return new Solution(sol.getFinalNode(), nodesExplored);
            } catch (NoSolutionException e) {
                depthLimit++;
            }
        }
    }
}