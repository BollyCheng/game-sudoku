package com.bolly.game.sudoku.core;

/**
 * 标准数独
 * 9*9单元格。
 *
 * Created by Bolly on 2015/10/14.
 */
public class StandarSudoku extends Sudoku {

    public static final int ROW_COUNT = 9;
    public static final int COLUMN_COUNT = 9;
    public static final int GRID_ROW_COUNT = 3;
    public static final int GRID_COLUMN_COUNT = 3;
    public static final int GRID_COUNT = ROW_COUNT * COLUMN_COUNT / GRID_ROW_COUNT / GRID_COLUMN_COUNT;

    public StandarSudoku(CellValue[][] initValues) {
        super(initValues);
        if (initValues.length != ROW_COUNT)
            throw new IllegalArgumentException("行数必须是9");
        if (initValues[0].length != COLUMN_COUNT)
            throw new IllegalArgumentException("列数必须是9");
    }

    @Override
    protected void initRanges() {
        for (int i = 0; i < ROW_COUNT; i++) {
            ranges.add(new Range("Row-" + (i + 1)));
        }
        for (int i = 0; i < COLUMN_COUNT; i++) {
            ranges.add(new Range("Column-" + (i + 1)));
        }
        for (int i = 0; i < GRID_COUNT; i++) {
            ranges.add(new Range("Grid-" + (i + 1)));
        }

        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                Cell cell = cells.get(i * ROW_COUNT + j);
                Range rowRange = ranges.get(i);
                Range columnRange = ranges.get(ROW_COUNT + j);
                Range gridRange = ranges.get(ROW_COUNT + COLUMN_COUNT + (i / GRID_ROW_COUNT) * GRID_ROW_COUNT + j / GRID_COLUMN_COUNT);
                cell.addRelatedRange(rowRange);
                cell.addRelatedRange(columnRange);
                cell.addRelatedRange(gridRange);
                rowRange.addCell(cell);
                columnRange.addCell(cell);
                gridRange.addCell(cell);
            }
        }
    }

    @Override
    protected void printSudoku() {
        System.out.println("------------ Print Sudoku --------------");
        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                CellValue cellValue = cells.get(i * ROW_COUNT + j).getValue();
                System.out.print(cellValue + ",");
            }
            System.out.println();
        }
//        System.out.println("----------- All Cell Values ---------------");
//        for (Cell cell : cells) {
//            System.out.println(cell);
//        }
//        System.out.println("--------- All Range Values ---------------");
//        for (Range range : ranges) {
//            System.out.println(range);
//        }
    }

    @Override
    public int[][] getResult() {
        int[][] result = new int[ROW_COUNT][COLUMN_COUNT];
        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                result[i][j] = cells.get(i * ROW_COUNT + j).getValue().getValue();
            }
        }
        return result;
    }
}
