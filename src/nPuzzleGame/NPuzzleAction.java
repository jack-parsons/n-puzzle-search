package src.nPuzzleGame;

import src.search.*;

class NPuzzleAction extends Action {
    private Vector move;
    private String string;

    NPuzzleAction(Vector move) {
        this.move = move;
        if (move.x == -1 && move.y == 0) string = "LEFT";
        if (move.x == 1 && move.y == 0) string = "RIGHT";
        if (move.x == 0 && move.y == -1) string = "UP";
        if (move.x == 0 && move.y == 1) string = "DOWN";
    }

    public Vector getMove() {
        return move;
    }

    @Override
    public String toString() {
//        return "{"+move.x+","+move.y+"}";
        return string;
    }
}