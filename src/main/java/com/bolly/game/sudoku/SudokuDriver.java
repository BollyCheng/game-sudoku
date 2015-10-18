package com.bolly.game.sudoku;

import com.bolly.game.sudoku.core.CellValue;
import com.bolly.game.sudoku.core.StandarSudoku;
import com.bolly.game.sudoku.core.Sudoku;

/**
 * Created by Administrator on 2015/10/14.
 */
public class SudokuDriver {


    private static String[] allValues = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static void main(String[] args) {

        int[][] values = {
                {0, 0, 0, 0, 4, 0, 0, 0, 3},
                {0, 6, 0, 0, 0, 0, 9, 4, 0},
                {3, 0, 4, 5, 0, 8, 1, 0, 0},
                {0, 2, 0, 4, 0, 0, 0, 0, 0},
                {4, 3, 6, 0, 0, 0, 5, 9, 7},
                {0, 0, 0, 0, 0, 5, 0, 8, 0},
                {0, 0, 5, 1, 0, 9, 2, 0, 8},
                {0, 7, 3, 0, 0, 0, 0, 1, 0},
                {2, 0, 0, 0, 6, 0, 0, 0, 0}
        };

        CellValue[][] cellValues = new CellValue[9][9];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                int value = values[i][j];
                CellValue cellValue;
                switch (value) {
                    case 1:
                        cellValue = CellValue.Value_1;
                        break;
                    case 2:
                        cellValue = CellValue.Value_2;
                        break;
                    case 3:
                        cellValue = CellValue.Value_3;
                        break;
                    case 4:
                        cellValue = CellValue.Value_4;
                        break;
                    case 5:
                        cellValue = CellValue.Value_5;
                        break;
                    case 6:
                        cellValue = CellValue.Value_6;
                        break;
                    case 7:
                        cellValue = CellValue.Value_7;
                        break;
                    case 8:
                        cellValue = CellValue.Value_8;
                        break;
                    case 9:
                        cellValue = CellValue.Value_9;
                        break;
                    case 0:
                    default:
                        cellValue = CellValue.Value_Empty;
                        break;
                }
                cellValues[i][j] = cellValue;
            }
        }

        Sudoku sudoku = new StandarSudoku(cellValues);
        sudoku.calculate();
        sudoku.showResult();
    }

}
