package com.example.esteproject4.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class MJobScheduler extends JobService {

    private MJobExecuter mJobExecuter;

    @Override
    public boolean onStartJob(final JobParameters jobParameters){

        mJobExecuter = new MJobExecuter() {
            @Override
            protected void onPostExecute(String s) {
//                super.onPostExecute(s);

                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                jobFinished(jobParameters,false);

            }
        };
        mJobExecuter.execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters){

        mJobExecuter.cancel(true);
        return false;
    }

}
