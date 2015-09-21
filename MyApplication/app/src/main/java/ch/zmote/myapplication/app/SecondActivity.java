package ch.zmote.myapplication.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRestart(){
        super.onRestart();
        stateChangedTo("Second: Restart");
    }

    @Override
    public void onResume(){
        super.onResume();
        stateChangedTo("Second: Resume");
    }

    @Override
    public void onStart(){
        super.onStart();
        stateChangedTo("Second: Started");
    }

    @Override
    public void onStop(){
        super.onStop();
        stateChangedTo("Second: Stopped");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        stateChangedTo("Second: Destroyed");
    }

    @Override
    public void onPause(){
        super.onPause();
        stateChangedTo("Second: Paused");
    }

    private void stateChangedTo(String state) {
        String currentTimeString = getCurrentTimeString();
        Notification notification =
                new Notification.Builder(this)
                        .setContentTitle(state)
                        .setSmallIcon(android.R.drawable.presence_busy)
                        .setContentText(currentTimeString)
                        .getNotification();
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify((int) System.currentTimeMillis(), notification);
        Log.d(getString(R.string.app_name), state + " at " + currentTimeString);
    }

    private String getCurrentTimeString() {
        return new SimpleDateFormat("HH:mm:ss.SSS")
                .format(new Date());
    }
}
