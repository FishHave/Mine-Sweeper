package net.sevensuns.minesweeper.mine;

import java.util.Objects;

/**
 * 位置类，用来存储每个格子的位置信息
 *
 * @author FishHave
 * @version 1.0
 */
public class Location {
    /**
     * 状态常量，表示该位置有地雷
     */
    public static final String MINE = "mine";
    /**
     * 状态常量，表示该位置无地雷
     */
    public static final String EMPTY = "empty";
    /**
     * x轴位置
     */
    private final int x;
    /**
     * y轴位置
     */
    private final int y;
    /**
     * 状态信息
     */
    private String state;

    /**
     * 构造方法，用来初始化一个位置对象，同时会设置默认状态为EMPTY
     * x和y的值不能小于零或大于com.sevensuns.mine.MineButton.locations[][]的x和y值，否则会抛出NullPointerException
     *
     * @param x 该位置的x轴
     * @param y 该位置的y轴
     *          <p>
     *          e.g. Location example = new Location(0,0);
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        setState(EMPTY);
    }

    /**
     * 获取该位置的x轴信息
     *
     * @return x轴
     */
    public int getX() {
        return x;
    }

    /**
     * 获取该位置的y轴信息
     *
     * @return y轴
     */
    public int getY() {
        return y;
    }

    /**
     * 获取状态
     *
     * @return 该位置的状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态，当状态非EMPTY或MINE会抛出InvaildMineButtonException
     *
     * @param state 该位置的状态
     * @throws InvaildMineButtonException
     * @see InvaildMineButtonException
     */
    public void setState(String state) {
        if (!(state.equals(MINE) || state.equals(EMPTY))) {
            try {
                throw new InvaildMineButtonException();
            } catch (InvaildMineButtonException e) {
                e.printStackTrace();
            }
        }
        this.state = state;
    }

    /**
     * 判断该位置是否为地雷
     * e.g.
     * Location mineExample = new Location(0,0);
     * mineExample.setState(Location.MINE);
     * mineExample.isMine()返回结果为true
     *
     * @return 是否为地雷
     */
    public boolean isMine() {
        return state.equals(MINE);
    }

    /**
     * 比较位置，若x和y轴信息相同，则返回true
     *
     * @param o 比较的对象
     * @return 比较结果，若为相同则返回true
     * @see Object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x && y == location.y;
    }

    /**
     * 获取哈希码
     *
     * @return 该位置的哈希码
     * @see Object
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
