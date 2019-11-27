package src.search;

import java.util.Stack;

public class IDS extends Search {
    private Stack<Node> fringe = new Stack<>();
    private int depthLimit = 1;

    public Node getNextNode() {return null;}

    public void addNode(Node node) {}

    @Override
    public Solution findSolution(Node initialNode) throws NoSolutionException {
        int nodesExplored = 0;
        while (true) {
            try {
                Search search = new DLS(depthLimit);
                Solution sol = search.findSolution(initialNode);
                nodesExplored += sol.getNodesExplored();
                return new Solution(sol.getFinalNode(), nodesExplored);
            } catch (NoSolutionException e) {
                // If no solution is found, explore one deeper
                depthLimit++;
            }
        }
    }
}