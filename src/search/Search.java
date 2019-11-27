package src.search;

import java.util.Collections;
import java.util.List;

public abstract class Search {
    public abstract Node getNextNode();
    public abstract void addNode(Node node);

    boolean isRandom() {
        return false;
    }

    public Solution findSolution(Node initialNode) throws NoSolutionException {
        return findSolution(initialNode, isRandom());
    }

    public Solution findSolution(Node initialNode, boolean random) throws NoSolutionException {
        int i = 0;
        addNode(initialNode);
        Node currentNode;
        while ((currentNode=getNextNode()) != null) {
            i++;
            if (currentNode.goalTest()) {
                return new Solution(currentNode, i);
            }
            List<Node> l = currentNode.getSuccessors();

            if (random) Collections.shuffle(l);

            for (Node newNode : l) {
                addNode(newNode);
            }
        }
        throw new NoSolutionException("No solution found");
    }
}