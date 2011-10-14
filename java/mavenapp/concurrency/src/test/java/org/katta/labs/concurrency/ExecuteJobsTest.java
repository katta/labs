package org.katta.labs.concurrency;

import org.junit.Test;

public class ExecuteJobsTest {

    @Test
    public void shouldExecuteAJob() {
        BatchExecutor batchExecutor = new BatchExecutor();

        batchExecutor.addJob(new MyJob() {
            @Override
            public void execute() {
                System.out.println("executed");
            }
        });

        batchExecutor.execute();
    }
}
