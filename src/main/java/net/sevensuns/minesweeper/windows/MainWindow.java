package net.sevensuns.minesweeper.windows;

import net.sevensuns.minesweeper.mine.Location;
import net.sevensuns.minesweeper.mine.MineButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;

/**
 * 主窗体
 *
 * @author FishHave
 * @version 1.0
 * @see javax.accessibility.Accessible
 * @see java.awt.MenuContainer
 * @see java.awt.image.ImageObserver
 * @see java.awt.Container
 * @see java.awt.Component
 * @see java.io.Serializable
 * @see java.awt.Frame
 * @see java.awt.Window
 * @see javax.swing.JFrame
 * @see javax.swing.RootPaneContainer
 * @see javax.swing.TransferHandler.HasGetTransferHandler
 * @see javax.swing.WindowConstants
 */
public class MainWindow extends JFrame {
    /**
     * 按钮哈希表，通过传入一个位置对象获取按钮
     */
    public static final Hashtable<Location, MineButton> BUTTON_TABLE = new Hashtable<>();
    /**
     * 位置数组，通过传入数组的x、y轴获取位置
     * e.g. locations[0][1]
     */
    public static Location[][] locations = new Location[10][10];
    /**
     * GraphicsDevice对象，用于设置全屏
     */
    public static GraphicsDevice graphicsDevice;
    /**
     * 窗体的容器，在此容器中添加控件
     */
    Container container = getContentPane();

    /**
     * 构造方法，执行初始化方法
     */
    public MainWindow() {
        init();
    }

    /**
     * 初始化方法
     * 1.设置窗体大小
     * 2.设置容器网格布局
     * 3.跳入10次循环，i值0-9，若循环结束，跳入10
     * 4.跳入10次循环，j值0-9
     * 5.新建按钮，位置为i，j
     * 6.添加按钮至窗体
     * 7.添加按钮至按钮哈希表
     * 8.添加位置至位置数组
     * 9.回到5
     * 10.安装窗体监听（i.e.窗体关闭时结束程序）
     * 11.设置标题
     * 12.设置可见
     */
    public void init() {
        setBounds(10, 10, 480, 320);
        container.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                MineButton mineButton = new MineButton(new Location(i, j));
                container.add(mineButton);
                BUTTON_TABLE.put(new Location(i, j), mineButton);
                locations[i][j] = new Location(i, j);
            }
        }
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setTitle("扫雷🐟");
        setVisible(true);
    }
}
