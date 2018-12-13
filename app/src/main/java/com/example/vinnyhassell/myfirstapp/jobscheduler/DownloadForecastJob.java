package com.example.vinnyhassell.myfirstapp.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

//https://medium.com/google-developers/scheduling-jobs-like-a-pro-with-jobscheduler-286ef8510129
//http://www.zoftino.com/android-job-scheduler-example

public class DownloadForecastJob extends JobService {

    private long numberOfJobRuns = 0;

    @Override
    public boolean onStartJob(JobParameters params) {

        //call job TODO - need a background thread here
        incrementNumber();
        Toast.makeText(this, "Number of job runs = " + Long.toString(numberOfJobRuns), Toast.LENGTH_LONG) .show();

        //broadcast that the job has finished

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {

        return false; //returning false doesn't reschdeule the job
    }

    private void incrementNumber()
    {
        //increment the number of runs
        numberOfJobRuns ++;


    }
}
