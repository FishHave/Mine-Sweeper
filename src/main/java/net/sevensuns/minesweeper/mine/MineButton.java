package net.sevensuns.minesweeper.mine;

import net.sevensuns.minesweeper.Application;
import net.sevensuns.minesweeper.config.Args;
import net.sevensuns.minesweeper.windows.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * 按钮对象，继承自JButton
 *
 * @author FishHave
 * @version 1.0
 * @see java.io.Serializable
 * @see java.awt.Component
 * @see java.awt.Container
 * @see java.awt.image.ImageObserver
 * @see java.awt.ItemSelectable
 * @see java.awt.MenuContainer
 * @see javax.accessibility.Accessible
 * @see javax.swing.AbstractButton
 * @see javax.swing.JButton
 * @see javax.swing.SwingConstants
 * @see javax.swing.TransferHandler.HasGetTransferHandler
 */
public class MineButton extends JButton {
    /**
     * 该按钮位置信息
     */
    private final Location location;

    /**
     * 构造方法，创建一个按钮
     *
     * @param location 按钮位置
     */
    public MineButton(Location location) {
        this.location = location;
        addActionListener(e -> getWinOrLose());
        setFont(new Font(getFont().getFontName(), getFont().getStyle(), 16));
    }

    /**
     * 获取一个随机骰子
     * e.g.
     * Random random = MineButton.getRandom();
     *
     * @return 一个Random对象
     */
    public static Random getRandom() {
        return new Random();
    }

    /**
     * 添加地雷
     * 将设置该按钮位置为MINE
     * 具体算法：
     * 1.生成一个当前已生成地雷数numberNow为0
     * 2.进入一个10次的循环，循环变量i从0-9，循环结束结束方法
     * 3.进入一个10次的循环，循环变量j从0-9，循环结束跳入12
     * 4.如果当前位置非第一次点击位置，跳入5，否则跳入4
     * 5.获取一个0-99的随机数
     * 6.如果获取到的随机数小于预设地雷数减去已生成地雷数的差，跳入7，否则跳入10
     * 7.设置当前位置为地雷
     * 8.地雷数增加
     * 9.跳入4
     * 10.设置当前位置为空
     * 11.跳入4
     * 12.跳入3
     * e.g. MineButton.addMine(new Location(0,0),10);
     * 会在场地上生成约10个地雷，但是(0,0)一定不是地雷
     *
     * @param firstClick 第一次点击的位置
     * @param number     地雷预设数量(PS:生成的地雷由于算法，不一定与传入地雷数相同)
     */
    public static void addMine(Location firstClick, int number) {
        int numberNow = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!(new Location(i, j).equals(firstClick))) {
                    int random = getRandom().nextInt(100);
                    if (random < number - numberNow) {
                        MainWindow.locations[i][j].setState(Location.MINE);
                        Args.mineNumber++;
                        numberNow++;
                    } else {
                        MainWindow.locations[i][j].setState(Location.EMPTY);
                    }
                }
            }
        }
    }

    /**
     * 获取本按钮的位置
     *
     * @return 位置
     */
    public Location getMineLocation() {
        return MainWindow.locations[getLine()][getLie()];
    }

    /**
     * 获取行
     *
     * @return 行数
     */
    public int getLine() {
        return location.getX();
    }

    /**
     * 获取列数
     *
     * @return 列数
     */
    public int getLie() {
        return location.getY();
    }

    /**
     * 点击时执行的方法
     * 1.增加点击次数
     * 2.减少可用按钮数
     * 3.如果点击次数为1，跳入4，否则跳入6
     * 4.设置地雷，firstClick为当前位置，number为10
     * 5.设置当前位置为空
     * 6.设置文字
     * 7.设置不可用
     */
    public void click() {
        Args.clickTimes++;
        Args.enableButton--;
        if (Args.clickTimes == 1) {
            addMine(getMineLocation(), 10);
            MainWindow.locations[getLine()][getLie()].setState(Location.EMPTY);
        }
        setText();
        setEnabled(false);
    }

    /**
     * 获取输赢信息
     * 1.执行点击
     * 2.裁判判断输赢
     */
    public void getWinOrLose() {
        click();
        Application.winnerManager.winOrLose(getMineLocation());
    }

    /**
     * 设置文字
     * 如果当前位置状态为MINE，则设置为雷
     * 否则数周围的地雷数，如果为0，设置为空，否则设置为地雷数
     */
    public void setText() {
        int mineNumber = 0;
        if (MainWindow.locations[getLine()][getLie()].isMine()) {
            setText("雷");
        } else {
            if (!(getLine() == 0 || getLie() == 0)) {
                if (MainWindow.locations[getLine() - 1][getLie() - 1].isMine()) {
                    mineNumber++;
                }
            }
            if (!(getLine() == 0)) {
                if (MainWindow.locations[getLine() - 1][getLie()].isMine()) {
                    mineNumber++;
                }
            }
            if (!(getLine() == 0 || getLie() == 9)) {
                if (MainWindow.locations[getLine() - 1][getLie() + 1].isMine()) {
                    mineNumber++;
                }
            }
            if (!(getLie() == 0)) {
                if (MainWindow.locations[getLine()][getLie() - 1].isMine()) {
                    mineNumber++;
                }
            }
            if (!(getLie() == 9)) {
                if (MainWindow.locations[getLine()][getLie() + 1].isMine()) {
                    mineNumber++;
                }
            }
            if (!(getLine() == 9 || getLie() == 0)) {
                if (MainWindow.locations[getLine() + 1][getLie() - 1].isMine()) {
                    mineNumber++;
                }
            }
            if (!(getLine() == 9)) {
                if (MainWindow.locations[getLine() + 1][getLie()].isMine()) {
                    mineNumber++;
                }
            }
            if (!(getLine() == 9 || getLie() == 9)) {
                if (MainWindow.locations[getLine() + 1][getLie() + 1].isMine()) {
                    mineNumber++;
                }
            }
            if (mineNumber == 0) {
                setText("");
            } else {
                setText(Integer.toString(mineNumber));
            }
        }
    }
}
