package net.sevensuns.minesweeper.util;

import net.sevensuns.minesweeper.Application;
import net.sevensuns.minesweeper.config.Args;
import net.sevensuns.minesweeper.windows.MainWindow;

import javax.swing.*;
import java.util.Scanner;

/**
 * 命令解析器，提供了解析命令的方法
 *
 * @author FishHave
 * @version 1.0
 */
public class CommandParser {
    /**
     * 读取一行命令，并解析
     * e.g. CommandParser.readLine("setTitle(example","Application.mainWindow");
     *
     * @param command    本行命令
     * @param mainWindow 执行的窗体
     */
    public static void readLine(String command, MainWindow mainWindow) {
        /*
        命令标识
         */
        StringBuilder id = new StringBuilder();
        int index = 0;
        for (int i = 0; command.charAt(i) != '('; i++) {
            id.append(command.charAt(i));
            index++;
        }
        index++;
        /*
        设置标题
        e.g.
        setTitle(example
        会设置窗体标题为example
         */
        if (id.toString().equals("setTitle")) {
            StringBuilder title = new StringBuilder();
            for (int i = index; i < command.length(); i++) {
                title.append(command.charAt(i));
            }
            mainWindow.setTitle(title.toString());
        }
        /*
        获取点击次数，将从控制台打印
        e.g.
        getClickTimes(
         */
        if (command.equals("getClickTimes(")) {
            System.out.println(Args.clickTimes);
        }
        /*
        获取地雷数量，将从控制台打印
        e.g.
        getMineNumber(
         */
        if (command.equals("getMineNumber(")) {
            System.out.println(Args.mineNumber);
        }
        /*
        获取可用按钮数量，将从控制台打印
        e.g.
        getEnableButtonNumber(
         */
        if (command.equals("getEnableButtonNumber(")) {
            System.out.println(Args.enableButton);
        }
        /*
        显示所有按钮
        e.g.
        clickAll(
         */
        if (command.equals("clickAll(")) {
            Application.winnerManager.clickAll();
        }
        /*
        获取位置信息
        e.g.
        getLocationState(1,2
         */
        if (id.toString().equals("getLocationState")) {
            StringBuilder x = new StringBuilder();
            for (int i = index; command.charAt(i) != ','; i++) {
                x.append(command.charAt(i));
                index++;
            }
            index++;
            StringBuilder y = new StringBuilder();
            for (int i = index; i < command.length(); i++) {
                y.append(command.charAt(i));
            }
            int ix = Integer.parseInt(x.toString());
            int iy = Integer.parseInt(y.toString());
            System.out.println(MainWindow.locations[ix][iy].getState());
        }
        /*
        设置全屏
        e.g.
        setFullScreen(true
         */
        if (id.toString().equals("setFullScreen")) {
            StringBuilder bool = new StringBuilder();
            for (int i = index; i < command.length(); i++) {
                bool.append(command.charAt(i));
            }
            boolean b = false;
            try {
                b = Boolean.parseBoolean(bool.toString());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(Application.mainWindow, "无效命令", "提示", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
            if (b) {
                MainWindow.graphicsDevice.setFullScreenWindow(Application.mainWindow);
            } else {
                MainWindow.graphicsDevice.setFullScreenWindow(null);
            }
        }
    }

    /**
     * 循环读取命令
     *
     * @param scanner    扫描仪
     * @param mainWindow 执行窗体
     */
    public static void onAction(Scanner scanner, MainWindow mainWindow) {
        CommandParser.readLine(scanner.nextLine(), mainWindow);
    }
}
