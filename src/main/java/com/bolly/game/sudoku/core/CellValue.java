package com.bolly.game.sudoku.core;

/**
 * 数独单元格的值
 *
 * 如果在数独中的值不是1~9，请相应的替换值即可。
 *
 * 数独中只能存在1~9几个值，0是特殊值，用于代替初始没有值的单元格内容。
 *
 * Created by Bolly on 2015/10/14.
 */
public enum CellValue {

    /**
     * 默认值
     */
    Value_Empty(0),

    Value_1(1),

    Value_2(2),

    Value_3(3),

    Value_4(4),

    Value_5(5),

    Value_6(6),

    Value_7(7),

    Value_8(8),

    Value_9(9);

    private final int value;

    CellValue(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value + "";
    }
}
