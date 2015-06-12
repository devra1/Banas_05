package com.example.ray.banas_05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

//
//  How to Make Android Apps 5  (Derek Banas)
//
//  - Multple Activities
//  - Passing Data Between Activities
//

public class MainActivity extends Activity {

    public final static String EXTRA_MESSAGE = "MESSAGE";
    public final static String USERS_NAME = "USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onGetNameClick(View view) {
        Intent getSecondScreen = new Intent(this, SecondActivity.class);

        final int result = 1;

        getSecondScreen.putExtra(EXTRA_MESSAGE, "MainActivity");
        startActivityForResult(getSecondScreen, result);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView userTextView = (TextView) findViewById(R.id.users_name_message);
        String nameSentBack = data.getStringExtra(USERS_NAME);
        userTextView.append(" " + nameSentBack);
    }
}
