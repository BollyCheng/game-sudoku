package com.bolly.game.sudoku.listener;

import com.bolly.game.sudoku.event.CellEvent;

/**
 * ��Ԫ���������������Ԫ���Ƿ����仯
 * Created by Bolly on 2015/10/14.
 */
public interface CellListener {

    public void cellValueChanegd(CellEvent event);

}
