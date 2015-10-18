package com.bolly.game.sudoku.event;

import com.bolly.game.sudoku.core.Cell;
import com.bolly.game.sudoku.core.Range;

import java.util.EventObject;

/**
 * Created by Administrator on 2015/10/15.
 */
public class RangeEvent extends EventObject {

    private final Cell cell;

    public RangeEvent(Range range,final Cell cell) {
        super(range);
        this.cell=cell;
    }

    public Cell getCell() {
        return cell;
    }
}
