package net.sevensuns.minesweeper;

import net.sevensuns.minesweeper.module.role.RoleController;
import net.sevensuns.minesweeper.util.WinnerManager;
import net.sevensuns.minesweeper.windows.MainWindow;


/**
 * 应用程序的入口类，
 *
 * @author FishHave
 * @version 1.0
 */
public class Application {
    /**
     * 主窗体，调用构造函数以启动主窗体
     * e.g. Application.mainWindow = new MainWindow();
     *
     * @see MainWindow
     */
    public static MainWindow mainWindow;
    /**
     * 裁判，用来判断全局游戏胜利
     * e.g. Application.winnerManager.winOrLose()可以判断一次胜负
     *
     * @see WinnerManager
     */
    public static WinnerManager winnerManager = new WinnerManager();

    /**
     * 应用程序的主方法，用来启动程序，启动后调用RoleController的布局方法
     *
     * @param args main方法的参数
     */
    public static void main(String[] args) {
        RoleController.init();
    }


}
