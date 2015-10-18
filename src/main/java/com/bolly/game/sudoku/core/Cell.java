package com.bolly.game.sudoku.core;

import com.bolly.game.sudoku.event.CellEvent;
import com.bolly.game.sudoku.event.RangeEvent;
import com.bolly.game.sudoku.listener.RangeListener;

import java.util.Vector;

/**
 * Created by Administrator on 2015/10/14.
 */
public class Cell implements RangeListener {

    private int rowIndex;
    private int columnIndex;
    private CellValue value;//实际的值
    private Vector<CellValue> whiteValues;//备选值

    private Vector<Range> relatedRanges;//所属的组

    public Cell(int rowIndex, int columnIndex) {
        this(rowIndex, columnIndex, CellValue.Value_Empty);
    }

    public Cell(int rowIndex, int columnIndex, CellValue value) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.value = value;
        //初始化备选值
        this.whiteValues = new Vector<CellValue>();
        if (value == CellValue.Value_Empty) {
            for (CellValue cellValue : CellValue.values())
                this.whiteValues.add(cellValue);
            this.whiteValues.remove(CellValue.Value_Empty);
        }
        //初始化
        this.relatedRanges = new Vector<Range>();
    }

    public CellValue getValue() {
        return value;
    }

    public void setValue(CellValue value) {
        this.value = value;
        this.whiteValues.clear();
        notifyCellValueChanged();
    }

    public Vector<CellValue> getWhiteValues() {
        return whiteValues;
    }

    public void addRelatedRange(Range range) {
        this.relatedRanges.add(range);
    }

    protected void notifyCellValueChanged() {
        for (Range range : relatedRanges) {
            range.cellValueChanegd(new CellEvent(this));
        }
    }

    @Override
    public void rangeChanged(RangeEvent event) {
        if (whiteValues.isEmpty())
            return;
        Cell cell = event.getCell();
        whiteValues.remove(cell.getValue());
        if (whiteValues.size() == 1) {
            setValue(whiteValues.get(0));
        }
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Cell{");
        strBuilder.append("[" + rowIndex + "," + columnIndex + "] ");
        strBuilder.append(value);
        if (!whiteValues.isEmpty()) {
            strBuilder.append(" [");
            for (CellValue value : whiteValues) {
                strBuilder.append(value + ",");
            }
            strBuilder.deleteCharAt(strBuilder.length() - 1);
            strBuilder.append("]");
        }
        strBuilder.append("}");
        return strBuilder.toString();
    }

}
