package com.test.algorithm.backtracking;

public class Sudoku {
    public static void main(String[] args) {
        int[][] sudoku = new int [][] {
                {0,7,0,0,0,1,0,0,8},
                {6,0,0,0,0,0,0,3,7},
                {0,2,0,0,0,0,1,0,0},
                {0,6,0,7,1,0,0,0,4},
                {0,0,0,2,0,8,0,0,0},
                {7,0,0,0,4,9,0,8,0},
                {0,0,5,0,0,0,0,7,0},
                {9,3,0,0,0,0,0,0,2},
                {4,0,0,3,0,0,0,6,0}
        };
        printSudoku(sudoku);
        if (solveSudoku(sudoku)) {
            System.out.println("*************Solution**************");
            printSudoku(sudoku);
        } else {
            System.out.println("can't solve");
        }
    }

    private static boolean solveSudoku(int[][] sudoku) {
        // get unsolved index
        int unsolvedRow = -1;
        int unsolvedColumn = -1;
        boolean isUnsolvedElementFound = false;

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                if (sudoku[i][j] == 0) {
                    unsolvedRow = i;
                    unsolvedColumn = j;
                    isUnsolvedElementFound = true;
                    break;
                }
            }
            if (isUnsolvedElementFound) {
                break;
            }
        }
        // if no unsolved index, return true
        if (!isUnsolvedElementFound) {
            return true;
        }

        // check what value is safe to place for unsolved index
        for (int newValue=1; newValue<=9; newValue++) {
            if (isSafeToPlace(sudoku, unsolvedRow, unsolvedColumn, newValue)) {
                sudoku[unsolvedRow][unsolvedColumn] = newValue;
                if (solveSudoku(sudoku)) {
                    return true;
                } else {
                    sudoku[unsolvedRow][unsolvedColumn] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isSafeToPlace(int[][] sudoku, int unsolvedRow, int unsolvedColumn, int newValue) {
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[unsolvedRow][i] == newValue) {
                return false;
            }
            if (sudoku[i][unsolvedColumn] == newValue) {
                return false;
            }
        }
        int sudokuSquareRowStart = unsolvedRow - unsolvedRow % 3;
        int sudokuSquareColumnStart = unsolvedColumn - unsolvedColumn % 3;
        for (int i = sudokuSquareRowStart; i < sudokuSquareRowStart+3; i++) {
            for (int j = sudokuSquareColumnStart; j < sudokuSquareColumnStart+3; j++) {
                if (sudoku[i][j] == newValue) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printSudoku(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
}
