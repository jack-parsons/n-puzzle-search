package src.nPuzzleGame;

import src.search.*;

import java.util.LinkedList;
import java.util.List;


class NPuzzleNode extends Node {
    private Node parent;
    private Action action;
    private NPuzzleState state;
    private NPuzzleState goalState;
    private int depth;
    private int costSoFar;

    NPuzzleNode(Node parent, Action action, NPuzzleState state, NPuzzleState goalState, int depth, int costSoFar) {
        this.parent = parent;
        this.action = action;
        this.state = state;
        this.goalState = goalState;
        this.depth = depth;
        this.costSoFar = costSoFar;
    }

    @Override
    public int getDepth() {
        return depth;
    }

    @Override
    public boolean goalTest() {
        for (int x = 0; x < state.getWidth(); x++) {
            for (int y = 0; y < state.getHeight(); y++) {
                Vector pos = new Vector(x, y);
                if (state.getCell(pos) != CellType.AGENT && goalState.getCell(pos) != state.getCell(pos)) {
                    return false;
                }
            }
        }
        return true;
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

    private static Vector findCell(CellType c, NPuzzleState state) {
        for (int x = 0; x < state.getWidth(); x++) {
            for (int y = 0; y < state.getHeight(); y++) {
                Vector v = new Vector(x, y);
                if (state.getCell(v) == c) {
                    return v;
                }
            }
        }
        return null;
    }

    @Override
    public Comparable getEstimate() {
        int est = costSoFar;
        for (int x = 0; x < state.getWidth(); x++) {
            for (int y = 0; y < state.getHeight(); y++) {
                Vector v = new Vector(x, y);
                if (state.getCell(v) == CellType.A || state.getCell(v) == CellType.B || state.getCell(v) == CellType.C) {
                    est += v.manhattan(findCell(state.getCell(v), goalState));
                }
            }
        }

        return est;
    }

    @Override
    public List<Node> getSuccessors() {
        List<Node> successors = new LinkedList<>();
        Vector[] moves = {new Vector(1, 0), new Vector(0, 1), new Vector(-1, 0), new Vector(0, -1)};
        for (Vector move : moves) {
            NPuzzleState newState = state.moveAgent(move);
            // Check new state is valid
            if (newState != null) {
                successors.add(new NPuzzleNode(this, new NPuzzleAction(move), newState, goalState, getDepth()+1, costSoFar+1));
            }
        }
        return successors;
    }
}