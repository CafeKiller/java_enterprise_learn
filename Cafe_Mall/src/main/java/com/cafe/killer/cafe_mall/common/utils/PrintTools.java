package com.cafe.killer.cafe_mall.common.utils;

public class PrintTools {

    /**
     * @param colorCode 颜色代号：背景颜色代号(41-46)；前景色代号(31-36)
     * @param fontStyle 数字+m：1加粗；3斜体；4下划线
     * @param content 要打印的内容
     */
    public static void PrintColorText( String content, int colorCode, int fontStyle){
        System.out.format("\33[%d;%dm%s\33[0m %n", colorCode, fontStyle, content);
    }

    public static void PrintGreenerText(String content){
        System.out.format("\33[32;2m%s\33[0m %n", content);
    }

    public static void PrintRedText(String content){
        System.out.format("\33[31;2m%s\33[0m %n", content);
    }
}
