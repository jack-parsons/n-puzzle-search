package src.nPuzzleGame;

import src.search.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;


class NPuzzleNode extends Node {
    private Node parent;
    private Action action;
    private NPuzzleState state;
    private Function<NPuzzleState, Boolean> goalFunction;

    NPuzzleNode(Node parent, Action action, NPuzzleState state, Function<NPuzzleState, Boolean> goalFunction) {
        this.parent = parent;
        this.action = action;
        this.state = state;
        this.goalFunction = goalFunction;
    }

    @Override
    public boolean goalTest() {
        return goalFunction.apply(state);
    }

    @Override
    public Node getParent() {
        return parent;
    }

    @Override
    public Action getAction() {
        return action;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public Comparable getEstimate() {
        // TODO implement this
        return 0;
    }

    @Override
    public List<Node> getSuccessors() {
        List<Node> successors = new LinkedList<>();
        Vector[] moves = {new Vector(1, 0), new Vector(0, 1), new Vector(-1, 0), new Vector(0, -1)};
        for (Vector move : moves) {
            NPuzzleState newState = state.moveActor(move);
            // Check new state is valid
            if (newState != null) {
                successors.add(new NPuzzleNode(this, new NPuzzleAction(move), newState, goalFunction));
            }
        }
        return successors;
    }
}