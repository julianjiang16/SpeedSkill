package com.tengyu.skill.atomic;

public interface Stock {

    long getStock();

    boolean lock(long cnt);

    boolean unlock(long cnt);

    boolean decrease(long cnt);

    boolean increase(long cnt);
}
