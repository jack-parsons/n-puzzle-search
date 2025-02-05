package src.nPuzzleGame;

import src.search.*;

import java.util.HashMap;
import java.util.Map;

class NPuzzleState extends State {
    private CellType[][] board;
//    private Map<Vector, CellType> cellTypeMap = new HashMap<>();
    private Vector actorVector;

    NPuzzleState(CellType[][] board) {
        this.board = board;
        findActorVector();
    }

    NPuzzleState(String[] board) {
        this.board = new CellType[board.length][board[0].length()];
        for (int y = 0; y < this.board.length; y++) {
            for (int x = 0; x < this.board[0].length; x++) {
                this.board[y][x] = CellType.inverseType(board[y].charAt(x));
            }
        }
        findActorVector();
    }

    public int getWidth() {
        return board[0].length;
    }

    public int getHeight() {
        return board.length;
    }

    public Vector findActorVector() {
        for (int y = 0; y < this.board.length; y++) {
            for (int x = 0; x < this.board[0].length; x++) {
                Vector pos = new Vector(x, y);
                if (getCell(pos) == CellType.AGENT) {
                    this.actorVector = pos;
                    return this.actorVector;
                }
            }
        }
        return null;
    }

    public CellType getCell(Vector pos) {
        return board[pos.y][pos.x];
    }

    private CellType[][] copyBoard() {
        CellType[][] newBoard = new CellType[board.length][board[0].length];
        for (int y = 0; y < this.board.length; y++) {
            for (int x = 0; x < this.board[0].length; x++) {
                newBoard[y][x] = board[y][x];
            }
        }
        return newBoard;
    }

    public Vector getActorVector() {
        return this.actorVector;
    }

    public boolean posInRange(Vector p) {
        return 0 <= p.x && p.x < board.length && 0 <= p.y && p.y < board.length;
    }

    /**
     * Generate a move for the agent to make, and return the new state
     * @param moveV The displacement vector representing the agent's move
     * @return The new NPuzzleState when the agent is moved
     */
    public NPuzzleState moveAgent(Vector moveV) {
        int newX = actorVector.x+moveV.x;
        int newY = actorVector.y+moveV.y;

        if (posInRange(new Vector(newX, newY))) {
            CellType[][] newBoard = copyBoard();
            newBoard[actorVector.y][actorVector.x] = newBoard[newY][newX];
            newBoard[newY][newX] = CellType.AGENT;
            return new NPuzzleState(newBoard);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int y = 0; y < this.board.length; y++) {
            for (int x = 0; x < this.board[0].length; x++) {
                s.append(getCell(new Vector(x, y)).toString());
            }
            s.append("\n");
        }
        return s.toString();
    }
}