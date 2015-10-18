package com.bolly.game.sudoku.core;

import com.bolly.game.sudoku.event.CellEvent;
import com.bolly.game.sudoku.event.RangeEvent;
import com.bolly.game.sudoku.listener.CellListener;

import java.util.Vector;

/**
 * Created by Administrator on 2015/10/15.
 */
public class Range implements CellListener {

    private final String name;
    private Vector<Cell> cells;
    private Vector<CellValue> usedValues;//�Ѿ�ʹ�õ�ֵ
    private Vector<CellValue> restValues;//ʣ�µ�ֵ

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
     * Range�е�Ԫ��Ψһֵ�ж�
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

    public void clearUsedValue() {

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
