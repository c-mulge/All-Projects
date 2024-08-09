package com.example.tictactoe;

public class tictactoegame {
        private char[][] board;
        private char currentPlayer;

        public tictactoegame() {
            board = new char[3][3];
            currentPlayer = 'X';
            initializeBoard();
        }

        // Initialize the board with empty spaces
        private void initializeBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = '-';
                }
            }
        }

        // Print the board
        public void printBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

        // Check if the board is full
        public boolean isBoardFull() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == '-') {
                        return false;
                    }
                }
            }
            return true;
        }

        // Check for a win
        public boolean checkForWin() {
            return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
        }

        private boolean checkRowsForWin() {
            for (int i = 0; i < 3; i++) {
                if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                    return true;
                }
            }
            return false;
        }

        private boolean checkColumnsForWin() {
            for (int i = 0; i < 3; i++) {
                if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                    return true;
                }
            }
            return false;
        }

        private boolean checkDiagonalsForWin() {
            return ((checkRowCol(board[0][0], board[1][1], board[2][2]) || checkRowCol(board[0][2], board[1][1], board[2][0])));
        }

        private boolean checkRowCol(char c1, char c2, char c3) {
            return ((c1 != '-') && (c1 == c2) && (c2 == c3));
        }

        // Change player
        public void changePlayer() {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        // Make a move
        public boolean placeMark(int row, int col) {
            if ((row >= 0) && (row < 3)) {
                if ((col >= 0) && (col < 3)) {
                    if (board[row][col] == '-') {
                        board[row][col] = currentPlayer;
                        return true;
                    }
                }
            }
            return false;
        }

        public char getCurrentPlayer() {
            return currentPlayer;
        }
    }
