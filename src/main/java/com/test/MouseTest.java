package com.test;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Random;

public class MouseTest {
    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 50;
    public static final int MAX_X = 50;

    public static void main(String... args) throws Exception {
        Robot robot = new Robot();
        Random random = new Random();
        while (true) {
            robot.mouseMove(random.nextInt(MAX_X) + 800, random.nextInt(MAX_Y) + 800);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(FIVE_SECONDS);
        }
    }
}
