package net.sevensuns.minesweeper.mine;

/**
 * 无效位置状态异常
 * 当用户传入除MINE和EMPTY两个参数后抛出
 * e.g. new Location(1,1).setState("Example State");会抛出本异常
 *
 * @author FishHave
 * @version 1.0
 * @see java.io.Serializable
 * @see java.lang.Exception
 * @see java.lang.Throwable
 */
public class InvaildMineButtonException extends Exception {
    /**
     * 异常的构造方法
     * 异常消息：Invaild Button State
     */
    public InvaildMineButtonException() {
        super("Invaild Button State");
    }
}
