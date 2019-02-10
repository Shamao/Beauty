package com.louise.gank;

import com.louise.gank.bean.MHabit;

import org.junit.Test;

/**
 * @author lsd
 * @date 2019/1/4.
 */
public class HabitUnitTest {

    @Test
    public void create_habit() throws Exception {
        MHabit habit = new MHabit();
        habit.setId(MHabit.generateId());
        habit.setName("看书");
        habit.setGoal("陶冶情操");
        habit.setNum(1);
        habit.setUnit("小时");
        habit.setRepeat(0b11111111);
        System.out.println(habit.toString());
    }
}
