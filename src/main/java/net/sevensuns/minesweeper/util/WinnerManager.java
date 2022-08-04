package net.sevensuns.minesweeper.util;

import net.sevensuns.minesweeper.Application;
import net.sevensuns.minesweeper.config.Args;
import net.sevensuns.minesweeper.mine.Location;
import net.sevensuns.minesweeper.windows.MainWindow;

import javax.swing.*;

/**
 * 裁判，判断游戏输赢
 * e.g. WinnerManager.winOrLose(new Location(0,0)); 可进行一次判断
 *
 * @author FishHave
 * @version 1.0
 */
public class WinnerManager {
    /**
     * 进行一次判断
     * 1.若上次点击为地雷，跳入2,否则跳入4
     * 2.执行失败方法
     * 3.展开所有按钮
     * 4.若可用按钮是否等于地雷数量（i.e. 未点击按钮均为地雷），跳入5，否则执行7
     * 5.执行胜利方法
     * 6.展开所有按钮
     * 7.结束方法
     *
     * @param lastClick 上次点击位置
     */
    public void winOrLose(Location lastClick) {
        if (lastClick.isMine()) {
            lose();
            clickAll();
        } else {
            if (Args.enableButton == Args.mineNumber) {
                win();
                clickAll();
            }
        }
    }

    /**
     * 胜利方法，将跳出一个提示框
     */
    private void win() {
        JOptionPane.showMessageDialog(Application.mainWindow, "你赢了！😀", "提示", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * 展开所有，所有未点击的按钮均会被点击
     */
    public void clickAll() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                MainWindow.BUTTON_TABLE.get(new Location(i, j)).click();
            }
        }
    }

    /**
     * 失败方法，将跳出一个提示框
     */
    private void lose() {
        JOptionPane.showMessageDialog(Application.mainWindow, "你输了！😅", "提示", JOptionPane.ERROR_MESSAGE);
    }
}
