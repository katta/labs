package org.katta.labs.concurrency;

import java.util.ArrayList;
import java.util.List;

public class BatchExecutor {

    List<Job> jobs = new ArrayList<Job>();

    public void addJob(Job job) {
        jobs.add(job);
    }

    public void execute() {
        for (Job job : jobs) {
            job.execute();
        }
    }
}
