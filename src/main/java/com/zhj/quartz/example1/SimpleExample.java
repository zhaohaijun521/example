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

package com.zhj.quartz.example1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * This Example will demonstrate how to start and shutdown the Quartz
 * scheduler and how to schedule a job to run in Quartz.
 *
 * @author Bill Kratzer
 */
public class SimpleExample {


    public void run() throws Exception {
        Log log = LogFactory.getLog(SimpleExample.class);
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();
        Date runTime = TriggerUtils.getEvenMinuteDate(new Date());
        JobDetail job = new JobDetail("job1", "group1", HelloJob.class);
        SimpleTrigger trigger =
                new SimpleTrigger("trigger1", "group1", runTime, null, 10, 10);
        sched.scheduleJob(job, trigger);
        sched.start();
        /*try {
            // wait 90 seconds to show jobs
            Thread.sleep(90L * 1000L);
            // executing...
        } catch (Exception e) {
        }
        sched.shutdown(true);*/
    }

    public static void main(String[] args) throws Exception {

        SimpleExample example = new SimpleExample();
        example.run();

    }

}