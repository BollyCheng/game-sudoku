package com.bolly.game.sudoku.core;

import com.bolly.game.sudoku.event.CellEvent;
import com.bolly.game.sudoku.event.RangeEvent;
import com.bolly.game.sudoku.listener.CellListener;

import java.util.Vector;

/**
 * 一个数独的区间
 * 在一个完整数独区间中只能而且必须包含1~9这几个值。
 *
 * 在本算法中，加入了已使用的值和未使用的值。当自己所管辖的单元格的值
 *
 * 按如下方式理解：
 * 在标准的数独玩法中，这个区间通常为一行或者一列或者3*3的范围格。
 *
 * Created by Bolly on 2015/10/15.
 */
public class Range implements CellListener {

    private final String name;
    private Vector<Cell> cells;
    private Vector<CellValue> usedValues;//使用的值
    private Vector<CellValue> restValues;//未使用的值

    public Range(final String name) {
        this.name = name;
        cells = new Vector<Cell>();
        restValues = new Vector<CellValue>();
        usedValues = new Vector<CellValue>();
        resetRestValue();
    }

    public String getName() {
        return name;
    }

    public void addCell(Cell cell) {
        this.cells.add(cell);
        resetRestValue();
    }

    public Vector<CellValue> getRestValues() {
        return restValues;
    }

    public Vector<CellValue> getUsedValues() {
        return usedValues;
    }

    protected void resetRestValue() {
        usedValues.clear();
        restValues.clear();
        for (CellValue cellValue : CellValue.values()) {
            if (CellValue.Value_Empty != cellValue)
                restValues.add(cellValue);
        }
        for (Cell cell : cells) {
            if (CellValue.Value_Empty != cell.getValue()) {
                restValues.remove(cell.getValue());
                usedValues.add(cell.getValue());
            }
        }
    }

    /**
     * 检查Range的所有单元格中是否存在唯一值。如果存在，
     */
    public void uniqueCellCalulate() {
        Cell uniqueCell;
        for (int i = restValues.size() - 1; i >= 0; i--) {
            CellValue cellValue = restValues.get(i);
            uniqueCell = null;
            for (Cell cell : cells) {
                if (cell.getValue() == CellValue.Value_Empty) {
                    if (cell.getWhiteValues().contains(cellValue)) {
                        if (uniqueCell == null) {
                            uniqueCell = cell;
                        } else {
                            uniqueCell = null;
                            break;
                        }
                    }
                }
            }
            if (uniqueCell != null) {
                uniqueCell.setValue(cellValue);
                if (i > restValues.size()) {
                    i = restValues.size();
                }
            }
        }
    }

    @Override
    public void cellValueChanegd(CellEvent event) {
        resetRestValue();
        for (Cell cell : cells) {
            if (!cell.equals(event.getSource()))
                cell.rangeChanged(new RangeEvent(this, (Cell) event.getSource()));
        }
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("------------- Print Range(" + name + ")------------\r\n");
        strBuilder.append("Range{");
        strBuilder.append("Used[");
        for (CellValue cellValue : usedValues) {
            strBuilder.append(cellValue + ",");
        }
        if (!usedValues.isEmpty()) {
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }
        strBuilder.append("] Rest[");
        for (CellValue cellValue : restValues) {
            strBuilder.append(cellValue + ",");
        }
        if (!restValues.isEmpty()) {
            strBuilder.deleteCharAt(strBuilder.length() - 1);
        }
        strBuilder.append("]}\r\n");
        for (Cell cell : cells) {
            strBuilder.append(cell + "\r\n");
        }
        strBuilder.append("------------ End of Range --------------");
        return strBuilder.toString();
    }
}
