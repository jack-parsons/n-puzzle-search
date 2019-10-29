package src.nPuzzleGame;

import src.search.*;

class NPuzzleAction extends Action {
    private Vector move;

    NPuzzleAction(Vector move) {
        this.move = move;
    }

    public Vector getMove() {
        return move;
    }

    @Override
    public String toString() {
        return "{"+move.x+","+move.y+"}";
    }
}