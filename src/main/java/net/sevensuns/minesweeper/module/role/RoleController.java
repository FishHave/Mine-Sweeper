package net.sevensuns.minesweeper.module.role;

import net.sevensuns.minesweeper.Application;
import net.sevensuns.minesweeper.util.CommandParser;
import net.sevensuns.minesweeper.util.ThemeManager;
import net.sevensuns.minesweeper.windows.MainWindow;

import java.util.Scanner;

/**
 * 控制器
 *
 * @author Fishhave
 * @version 1.0
 */
public class RoleController {
    /**
     * 初始化方法，可以初始化本应用程序，并且开始读取命令
     */
    public static void init() {
        ThemeManager.setDarculaLookAndFeel();
        Application.mainWindow = getMainWindow();
        CommandParser.onAction(getScanner(), Application.mainWindow);
    }

    /**
     * 获取控制台扫描仪
     *
     * @return 控制台扫描仪
     */
    private static Scanner getScanner() {
        return new Scanner(System.in);
    }

    /**
     * 获取主窗体
     *
     * @return 主窗体
     */
    private static MainWindow getMainWindow() {
        return new MainWindow();
    }
}
