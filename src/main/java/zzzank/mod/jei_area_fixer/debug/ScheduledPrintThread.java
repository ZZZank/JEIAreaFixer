package zzzank.mod.jei_area_fixer.debug;

import zzzank.mod.jei_area_fixer.Tags;

/**
 * @author ZZZank
 */
public class ScheduledPrintThread extends Thread {

    private final long interval;
    private final Runnable task;

    public ScheduledPrintThread(long intervalMilliseconds, Runnable task) {
        super(Tags.MOD_ID + " scheduled print");
        this.setDaemon(true);
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
