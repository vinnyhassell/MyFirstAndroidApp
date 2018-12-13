package com.example.vinnyhassell.myfirstapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.vinnyhassell.myfirstapp.jobscheduler.DownloadForecastJob;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/*
EXAMPLES:
Setting up RecyclerView: https://www.androidhive.info/2016/01/android-working-with-recycler-view/

 */


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final long MIN_PERIOD_MILLIS = 15 * 60 * 1000L; //minimum 15 mins for job scheduling

    private List<Search> searchesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SearchesAdapter searchesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get data from preferences
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        String[] searchTerms = {
                "Stevie Wonder",
                "Meghan Markle",
                "Noel Edmonds"
        };

        /*
        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("name", "Elena");
        editor.putInt("idName", 12);
        editor.apply();
*/


        //prepare data and add it to recyclerview
        recyclerView = (RecyclerView) findViewById(R.id.searchList);

        searchesAdapter = new SearchesAdapter(searchesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(searchesAdapter);

        prepareSearchesData();

        //#3F51B5
/*
        //Add buttons to activity for each search term
        for (String searchTerm : searchTerms) {
            AppCompatButton myButton = new AppCompatButton(this);
            myButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            myButton.setTextColor(getResources().getColor(R.color.colorTextIcons));
            myButton.setText(searchTerm.toString());

            LinearLayout ll = (LinearLayout)findViewById(R.id.searchButtons);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            ll.addView(myButton, lp);

            //ll.removeView(myButton);


        }

*/

        //Toast.makeText(getApplicationContext(), "Exec reaches here...",Toast.LENGTH_SHORT).show();

        /*
        //Job scheduler stuff here
        JobScheduler jobScheduler = (JobScheduler) getApplicationContext().getSystemService(JOB_SCHEDULER_SERVICE);

        ComponentName compName = new ComponentName(getPackageName(), DownloadForecastJob.class.getName());

        JobInfo jobInfoObj = new JobInfo.Builder(1, compName)
                .setPeriodic(MIN_PERIOD_MILLIS).build();

        jobScheduler.schedule(jobInfoObj);
        */
    }

    //TODO - get this from config file
    private void prepareSearchesData() {
        Search search = new Search("Stevie Wonder", true);
        searchesList.add(search);

        search = new Search("Ariana Grandez", false);
        searchesList.add(search);

        search = new Search("David Cameron", true);
        searchesList.add(search);

        search = new Search("Will Smith", false);
        searchesList.add(search);

        search = new Search("Kool and the Gang", true);
        searchesList.add(search);

        search = new Search("Sean Connery", true);
        searchesList.add(search);

        search = new Search("Pharell", true);
        searchesList.add(search);

        search = new Search("Leonardo Da Vinci", true);
        searchesList.add(search);

        search = new Search("Harry Redknapp", true);
        searchesList.add(search);

        search = new Search("Paul Hollywood", true);
        searchesList.add(search);

        searchesAdapter.notifyDataSetChanged();
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

}
