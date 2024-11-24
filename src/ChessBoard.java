public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8];
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn, String color) {
        ChessPiece currentPiece = board[startLine][startColumn];

        if (currentPiece == null || !currentPiece.getColor().equals(color)) {
            return false;
        }

        if (!currentPiece.canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {
            return false;
        }

        if (currentPiece instanceof King && Math.abs(startColumn - endColumn) == 2) {
            if (endColumn == 2 && castling0(color)) return true;
            if (endColumn == 6 && castling7(color)) return true;
            return false;
        }

        if (currentPiece instanceof King || currentPiece instanceof Rook) {
            currentPiece.check = false;
        }

        board[endLine][endColumn] = currentPiece;
        board[startLine][startColumn] = null;

        return true;
    }

    public boolean castling0(String color) {
        int kingRow = color.equals("White") ? 0 : 7;
        King king = (King) board[kingRow][4];
        Rook rook = (Rook) board[kingRow][0];

        if (king == null || rook == null || !king.check || !rook.check || king.isUnderAttack(this, kingRow, 4)) {
            return false;
        }

        for (int i = 1; i < 4; i++) {
            if (board[kingRow][i] != null) {
                return false;
            }
        }
        if (king.isUnderAttack(this, kingRow, 2) || king.isUnderAttack(this, kingRow, 3)) return false;

        board[kingRow][2] = king;
        board[kingRow][3] = rook;
        board[kingRow][4] = null;
        board[kingRow][0] = null;

        return true;

    }

    public boolean castling7(String color) {
        int kingRow = color.equals("White") ? 0 : 7;
        King king = (King) board[kingRow][4];
        Rook rook = (Rook) board[kingRow][7];

        if (king == null || rook == null || !king.check || !rook.check || king.isUnderAttack(this, kingRow, 4)) {
            return false;
        }

        for (int i = 5; i < 7; i++) {
            if (board[kingRow][i] != null) {
                return false;
            }
        }
        if (king.isUnderAttack(this, kingRow, 5) || king.isUnderAttack(this, kingRow, 6)) return false;

        board[kingRow][6] = king;
        board[kingRow][5] = rook;
        board[kingRow][4] = null;
        board[kingRow][7] = null;
        return true;
    }

    public void printBoard() {
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos < 0 || pos > 7;
    }
}