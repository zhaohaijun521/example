/* 
 * Copyright 2005 James House 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */

package com.zhj.quartz.example2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * This Example will demonstrate all of the basics of scheduling capabilities
 * of Quartz using Simple Triggers.
 * 
 * @author Bill Kratzer
 */
public class SimpleTriggerExample {

    
    public void run() throws Exception {
        Log log = LogFactory.getLog(SimpleTriggerExample.class);


        // First we must get a reference to a scheduler
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        long ts = TriggerUtils.getNextGivenSecondDate(null, 15).getTime();

        // job1 will only fire once at date/time "ts"
        JobDetail job = new JobDetail("job1", "group1", SimpleJob.class);
        SimpleTrigger trigger = 
            new SimpleTrigger("trigger1", "group1", new Date(ts));


        Date ft = sched.scheduleJob(job, trigger);

        job = new JobDetail("job2", "group1", SimpleJob.class);
        trigger = new SimpleTrigger("trigger2", "group1", "jobz", "group1",
                new Date(ts), null, 0, 0);
        ft = sched.scheduleJob(job, trigger);
        job = new JobDetail("job3", "group1", SimpleJob.class);
        trigger = new SimpleTrigger("trigger3", "group1", "job3", "group1",
                new Date(ts), null, 10, 10000L);
        ft = sched.scheduleJob(job, trigger);
        trigger = new SimpleTrigger("trigger3", "group2", "job3", "group1",
                new Date(ts), null, 2, 70000L);
        ft = sched.scheduleJob(trigger);
        job = new JobDetail("job4", "group1", SimpleJob.class);
        trigger = new SimpleTrigger("trigger4", "group1", "job4", "group1",
                new Date(ts), null, 5, 10000L);
        ft = sched.scheduleJob(job, trigger);

        job = new JobDetail("job5", "group1", SimpleJob.class);
        trigger = new SimpleTrigger("trigger5", "group1", "job5", "group1",
                new Date(ts + 300000L), null, 0, 0);
        ft = sched.scheduleJob(job, trigger);

        job = new JobDetail("job6", "group1", SimpleJob.class);
        trigger = new SimpleTrigger("trigger6", "group1", "job6", "group1",
                new Date(ts), null, SimpleTrigger.REPEAT_INDEFINITELY, 50000L);
        ft = sched.scheduleJob(job, trigger);
        sched.start();

        job = new JobDetail("job7", "group1", SimpleJob.class);
        trigger = new SimpleTrigger("trigger7", "group1", "job7", "group1",
                new Date(ts), null, 20, 300000L);
        ft = sched.scheduleJob(job, trigger);
        job = new JobDetail("job8", "group1", SimpleJob.class);
        job.setDurability(true);
        sched.addJob(job, true);

        sched.triggerJob("job8", "group1");
        try {
            // wait 30 seconds to show jobs
            Thread.sleep(30L * 1000L); 
            // executing...
        } catch (Exception e) {
        }

        trigger = new SimpleTrigger("trigger7", "group1", "job7", "group1", 
                new Date(), null, 10, 1000L);
        ft = sched.rescheduleJob("trigger7", "group1", trigger);

        try {
            // wait five minutes to show jobs
            Thread.sleep(300L * 1000L); 
            // executing...
        } catch (Exception e) {
        }
        sched.shutdown(true);

        SchedulerMetaData metaData = sched.getMetaData();
    }

    public static void main(String[] args) throws Exception {

        SimpleTriggerExample example = new SimpleTriggerExample();
        example.run();

    }

}