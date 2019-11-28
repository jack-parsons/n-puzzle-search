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
        while (true) {        // ***Next iteration***
//            System.out.printf("\n+++Depth limit=%d+++", depthLimit);
            Search search = new DLS(depthLimit);
            try {
                Solution sol = search.findSolution(initialNode); // Throws exception if no solution found
                nodesExplored += search.nodesGenerated;
                return new Solution(sol.getFinalNode(), nodesExplored, sol.getNodesStored());
            } catch (NoSolutionException e) {
                // If no solution is found, explore one deeper
                nodesExplored += search.nodesGenerated;
                depthLimit++;
            }
        }
    }

    @Override
    public String getFringeOutput() {
        return "";
    }

    @Override
    public Node[] getFringe() {
        return fringe.toArray(new Node[0]);
    }
}