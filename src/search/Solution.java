package src.search;

import java.util.List;

public class Solution {
    private List<Action> actions;
    private int nodesExplored;
    private Node finalNode;

    Solution(Node finalNode, int nodesExplored) {
        this.actions = finalNode.getActions();
        this.nodesExplored = nodesExplored;
        this.finalNode = finalNode;
    }

    public List<Action> getActions() {
        return actions;
    }

    public int getNodesExplored() {
        return nodesExplored;
    }

    public Node getFinalNode() {
        return finalNode;
    }
}
