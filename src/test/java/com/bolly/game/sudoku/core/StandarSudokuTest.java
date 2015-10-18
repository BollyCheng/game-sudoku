package com.bolly.game.sudoku.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2015/10/15.
 */
public class StandarSudokuTest {

    @Test
    public void test01() {
        //初始值
        int[][] values = {
                {0, 0, 8, 3, 0, 9, 1, 0, 0},
                {9, 0, 0, 0, 6, 0, 0, 0, 4},
                {0, 0, 7, 5, 0, 4, 8, 0, 0},
                {0, 3, 6, 0, 0, 0, 5, 4, 0},
                {0, 0, 1, 0, 0, 0, 6, 0, 0},
                {0, 4, 2, 0, 0, 0, 9, 7, 0},
                {0, 0, 5, 9, 0, 7, 3, 0, 0},
                {6, 0, 0, 0, 1, 0, 0, 0, 8},
                {0, 0, 4, 6, 0, 8, 2, 0, 0}
        };
        //期望值
        int[][] expectResult = {
                {4, 2, 8, 3, 7, 9, 1, 6, 5},
                {9, 5, 3, 8, 6, 1, 7, 2, 4},
                {1, 6, 7, 5, 2, 4, 8, 3, 9},
                {8, 3, 6, 7, 9, 2, 5, 4, 1},
                {7, 9, 1, 4, 3, 5, 6, 8, 2},
                {5, 4, 2, 1, 8, 6, 9, 7, 3},
                {2, 8, 5, 9, 4, 7, 3, 1, 6},
                {6, 7, 9, 2, 1, 3, 4, 5, 8},
                {3, 1, 4, 6, 5, 8, 2, 9, 7}
        };
        Sudoku sudoku = new StandarSudoku(convertToCellValue(values));
        sudoku.calculate();
        int[][] actualsResult = sudoku.getResult();
        Assert.assertArrayEquals(expectResult, actualsResult);
    }

    @Test
    public void test02() {
        //初始值
        int[][] values = {
                {8, 9, 0, 1, 7, 0, 0, 0, 0},
                {6, 0, 4, 9, 0, 0, 0, 8, 0},
                {0, 0, 0, 0, 0, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 2, 4, 3, 0},
                {0, 3, 0, 4, 0, 8, 0, 1, 0},
                {0, 1, 2, 7, 0, 0, 0, 0, 0},
                {0, 0, 9, 0, 0, 0, 0, 0, 0},
                {0, 5, 0, 0, 0, 7, 9, 0, 4},
                {0, 0, 0, 0, 6, 9, 0, 2, 7}
        };
        //期望值
        int[][] expectResult = {
                {8, 9, 5, 1, 7, 6, 2, 4, 3},
                {6, 7, 4, 9, 2, 3, 5, 8, 1},
                {1, 2, 3, 8, 5, 4, 6, 7, 9},
                {9, 8, 7, 6, 1, 2, 4, 3, 5},
                {5, 3, 6, 4, 9, 8, 7, 1, 2},
                {4, 1, 2, 7, 3, 5, 8, 9, 6},
                {7, 6, 9, 2, 4, 1, 3, 5, 8},
                {2, 5, 1, 3, 8, 7, 9, 6, 4},
                {3, 4, 8, 5, 6, 9, 1, 2, 7}
        };
        Sudoku sudoku = new StandarSudoku(convertToCellValue(values));
        sudoku.calculate();
        int[][] actualsResult = sudoku.getResult();
        Assert.assertArrayEquals(expectResult, actualsResult);
    }

    @Test
    public void test03() {
        //初始值
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
        //期望值
        int[][] expectResult = {
                {1, 5, 7, 9, 4, 6, 8, 2, 3},
                {8, 6, 2, 7, 1, 3, 9, 4, 5},
                {3, 9, 4, 5, 2, 8, 1, 7, 6},
                {5, 2, 8, 4, 9, 7, 3, 6, 1},
                {4, 3, 6, 2, 8, 1, 5, 9, 7},
                {7, 1, 9, 6, 3, 5, 4, 8, 2},
                {6, 4, 5, 1, 7, 9, 2, 3, 8},
                {9, 7, 3, 8, 5, 2, 6, 1, 4},
                {2, 8, 1, 3, 6, 4, 7, 5, 9}
        };
        Sudoku sudoku = new StandarSudoku(convertToCellValue(values));
        sudoku.calculate();
        int[][] actualsResult = sudoku.getResult();
        Assert.assertArrayEquals(expectResult, actualsResult);
    }

    private CellValue[][] convertToCellValue(int[][] initValue) {
        CellValue[][] cellValues = new CellValue[StandarSudoku.ROW_COUNT][StandarSudoku.COLUMN_COUNT];
        for (int i = 0; i < initValue.length; i++) {
            for (int j = 0; j < initValue[i].length; j++) {
                int value = initValue[i][j];
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
        return cellValues;
    }

}
