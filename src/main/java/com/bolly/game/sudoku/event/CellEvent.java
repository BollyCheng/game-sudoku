package com.bolly.game.sudoku.event;

import com.bolly.game.sudoku.core.Cell;

import java.util.EventObject;

/**
 * Created by Administrator on 2015/10/14.
 */
public class CellEvent extends EventObject {

    public CellEvent(Cell cell) {
        super(cell);
    }

}
