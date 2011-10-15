package org.katta.labs.concurrency;

import org.junit.Assert;
import org.junit.Test;

public class ExecuteJobsTest {

    @Test
    public void shouldExecuteAJob() {
        BatchExecutor batchExecutor = new BatchExecutor();

        final JobStatus jobStatus = new JobStatus();

        batchExecutor.addJob(new MyJob() {
            @Override
            public void execute() {
                jobStatus.setExecuted(true);
            }
        });

        batchExecutor.execute();
        Assert.assertTrue(jobStatus.isExecuted());
    }

    class JobStatus {
        private boolean executed;

        public boolean isExecuted() {
            return executed;
        }

        public void setExecuted(boolean executed) {
            this.executed = executed;
        }
    }
}
