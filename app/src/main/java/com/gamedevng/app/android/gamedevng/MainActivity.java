package com.gamedevng.app.android.gamedevng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static long FIVE_MILLISECONDS = 5000;
    long quitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed()
    {
        if(quitTime < System.currentTimeMillis())
        {
            // on hardware back button pressed, confirm notification by toast
            confirmQuit();
        }
        else
        {
            // on hardware back button pressed, quit the app
            quitApp();
        }
    }

    void confirmQuit()
    {
        // display confirm toast
        Toast.makeText(getApplicationContext(), "Press back again to exit", Toast.LENGTH_LONG).show();
        quitTime = System.currentTimeMillis() + FIVE_MILLISECONDS;
    }

    /**
     * Quit and exit the application.
     */
    void quitApp()
    {
        // drop activity from memory
        finish();

        // kill the current activity
        int pid = android.os.Process.myPid();
        android.os.Process.killProcess(pid);

        System.exit(0);
    }
}


