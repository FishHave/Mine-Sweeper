package net.sevensuns.minesweeper.util;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

/**
 * 主题管理器
 * 用来设置视感
 *
 * @author FishHave
 * @version 1.0
 */
public class ThemeManager {
    /**
     * 设置LookAndFeel为系统LookAndFeel
     */
    public static void setSystemLookAndFeel() {
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置LookAndFeel为Darcula
     */
    public static void setDarculaLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}
