package zzzank.mod.jei_area_fixer.utils;

import zzzank.mod.jei_area_fixer.Tags;

/**
 * @author ZZZank
 */
public final class ScheduledTaskThread extends Thread {

    private final long interval;
    private final Runnable task;

    public ScheduledTaskThread(String name, long intervalMilliseconds, Runnable task) {
        super(name);
        this.interval = intervalMilliseconds;
        this.task = task;
    }

    @Override
    public void run() {
        while (true) {
            task.run();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
