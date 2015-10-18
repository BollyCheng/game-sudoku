package com.bolly.game.sudoku.listener;

import com.bolly.game.sudoku.event.CellEvent;

/**
 * 单元格监听器，监听单元格是否发生变化
 * Created by Bolly on 2015/10/14.
 */
public interface CellListener {

    public void cellValueChanegd(CellEvent event);

}
