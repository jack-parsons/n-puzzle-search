package src.nPuzzleGame;

import src.search.*;

class NPuzzleState extends State {
    private CellType[][] board;
    private Vector actorVector;

    NPuzzleState(CellType[][] board) {
        this.board = board;
        findActorVector();
    }

    NPuzzleState(String[] board) {
        this.board = new CellType[board.length][board[0].length()];
        for (int x = 0; x < this.board.length; x++) {
            for (int y = 0; y < this.board[0].length; y++) {
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
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                Vector pos = new Vector(x, y);
                if (getCell(pos) == CellType.AGENT) {
                    this.actorVector = pos;
                    return this.actorVector;
                }
            }
        }
        return null;
    }

    public CellType getCell(Vector Vector) {
        return board[Vector.y][Vector.x];
    }

    private CellType[][] copyBoard() {
        CellType[][] newBoard = new CellType[board.length][board[0].length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
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
     * Generate a move for the actor to make, and return the new state
     * @param newLoc
     * @return The new Node
     */
    public NPuzzleState moveActor(Vector newLoc) {
        int newX = actorVector.y+newLoc.y;
        int newY = actorVector.x+newLoc.x;

        if (posInRange(new Vector(newX, newY))) {
            CellType[][] newBoard = copyBoard();
            newBoard[actorVector.y][actorVector.x] = newBoard[newY][newX];
            newBoard[newY][newX] = CellType.AGENT;
            return new NPuzzleState(newBoard);
        } else {
            return null;
        }
    }
}