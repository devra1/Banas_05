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

//    public final static String ACTIVITY_NAME = "ActivityName";
    public final static String USERS_NAME = "UserName";


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
//        Intent secondScreenIntent = new Intent(this, SecondActivity.class);
//        secondScreenIntent.putExtra(ACTIVITY_NAME, "MainActivity");

        Human bob = new Human("Bob", 6.25, 185);

        Intent sendHuman = new Intent(this, SecondActivity.class);
        sendHuman.putExtra("human_name", bob);

        final int result = 1;
        startActivityForResult(sendHuman, result);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String returnedName = data.getStringExtra(USERS_NAME);
        TextView nameTextView = (TextView) findViewById(R.id.users_name_message);
        nameTextView.append(" " + returnedName);
    }
}
