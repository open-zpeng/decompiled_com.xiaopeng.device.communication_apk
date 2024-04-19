package com.xiaopeng.lib.framework.netchannelmodule.remotestorage.util;

import b.d.b.e.b;
import b.d.b.e.i;
import java.io.File;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public class LogFileCleaner {
    private static final int CLEANING_THRESHOLD = 512;
    private static final long FILE_EXPIRED_TIME = 604800000;
    private static final int MAX_DELETED_FILES_EACH_TIME = 20;
    private static final long ONE_DAY_MILLS = 86400000;
    private CleaningTask mCleaningTask;
    private AtomicLong mLastCleaningDate;
    private String mLogFileFolder;

    /* loaded from: classes.dex */
    private final class CleaningTask implements Runnable {
        private CleaningTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] listFiles;
            File file = new File(LogFileCleaner.this.mLogFileFolder);
            if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 512) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i = 0;
            for (File file2 : listFiles) {
                if (currentTimeMillis - file2.lastModified() > LogFileCleaner.FILE_EXPIRED_TIME) {
                    b.b(file2.getAbsolutePath());
                    i++;
                }
                if (i > 20) {
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class Holder {
        private static final LogFileCleaner INSTANCE = new LogFileCleaner();

        private Holder() {
        }
    }

    public static LogFileCleaner getInstance() {
        return Holder.INSTANCE;
    }

    public void cleanLogAsNeeded() {
        if (this.mLogFileFolder == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() / ONE_DAY_MILLS;
        if (this.mLastCleaningDate.get() > currentTimeMillis) {
            return;
        }
        if (this.mCleaningTask == null) {
            this.mCleaningTask = new CleaningTask();
        }
        i.i(this.mCleaningTask);
        this.mLastCleaningDate.set(currentTimeMillis);
    }

    public void setLogFileFolder(String str) {
        this.mLogFileFolder = str;
    }

    private LogFileCleaner() {
        this.mLastCleaningDate = new AtomicLong(0L);
    }
}
