package src.nPuzzleGame;

enum CellType {
    AGENT('☺'),
    A('A'), B('B'), C('C'),
    EMPTY('-');

    private char output;

    CellType(char output) {
        this.output = output;
    }

    private char getOutputChar() {
        return this.output;
    }

    public String toString() {
        return ""+output;
    }

    public static CellType inverseType(char c) {
        for (CellType cellType : CellType.values()) {
            if (cellType.getOutputChar() == c) {
                return cellType;
            }
        }
        return null;
    }
}