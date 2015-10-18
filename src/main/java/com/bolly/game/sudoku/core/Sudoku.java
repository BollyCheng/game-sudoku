package com.bolly.game.sudoku.core;

import java.util.Vector;

/**
 * 抽象的数独
 * Created by Administrator on 2015/10/14.
 */
public abstract class Sudoku {

    protected Vector<Cell> cells;
    protected Vector<Range> ranges;

    public Sudoku(CellValue[][] initValues) {
        cells = new Vector<Cell>();
        ranges = new Vector<Range>();

        initCells(initValues);
        initRanges();
        System.out.println("----- Init -----");
        printSudoku();
    }

    protected void initCells(CellValue[][] initValues) {
        for (int i = 0; i < initValues.length; i++) {
            for (int j = 0; j < initValues[i].length; j++) {
                CellValue value = initValues[i][j];
                cells.add(new Cell(i, j, value));
            }
        }
    }

    protected abstract void initRanges();

    private int getSuccessCellCount() {
        int valuedCellCount = 0;
        for (Cell cell : cells) {
            if (cell.getValue() != CellValue.Value_Empty)
                valuedCellCount++;
        }
        return valuedCellCount;
    }

    public void calculate() {
        int successCellCount = getSuccessCellCount();
        int totalCount = cells.size();
        System.out.println(String.format("-------- Before Calculate :(%d/%d) %f%%", successCellCount, totalCount, (double) successCellCount * 100 / totalCount));
        //第一轮，对有值的数据进行运算
        for (Cell cell : cells) {
            if (cell.getValue() != CellValue.Value_Empty) {
                cell.notifyCellValueChanged();
            }
        }
        successCellCount = getSuccessCellCount();
        System.out.println(String.format("-------- First Calculate:(%d/%d) %f%%", successCellCount, totalCount, (double) successCellCount * 100 / totalCount));
        if (successCellCount == totalCount)
            return;
        //第二轮，针对每个Range，判断Range中是否存在唯一值的情况
        for (Range range : ranges) {
            range.uniqueCellCalulate();
        }
        successCellCount = getSuccessCellCount();
        System.out.println(String.format("-------- Second Calculate:(%d/%d) %f%%", successCellCount, totalCount, (double) successCellCount * 100 / totalCount));
        //第三轮

    }

    protected abstract void printSudoku();

    public abstract int[][] getResult();

    public void showResult() {
        System.out.println("------- Finished -------");
        printSudoku();
    }
}
