package com.bolly.game.sudoku.core;

/**
 * ������Ԫ���ֵ
 *
 * ����������е�ֵ����1~9������Ӧ���滻ֵ���ɡ�
 *
 * ������ֻ�ܴ���1~9����ֵ��0������ֵ�����ڴ����ʼû��ֵ�ĵ�Ԫ�����ݡ�
 *
 * Created by Bolly on 2015/10/14.
 */
public enum CellValue {

    /**
     * Ĭ��ֵ
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
