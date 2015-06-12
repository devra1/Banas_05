package com.example.ray.banas_05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView callingTextView = (TextView) findViewById(R.id.calling_activity_info_text_view);
        callingTextView.append(" " + previousActivity);
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

    public void onSendUsersName(View view) {
        EditText usersEditText = (EditText) findViewById(R.id.user_name_edit_text);
        String usersName = usersEditText.getText().toString();

        Intent getMainIntent = new Intent(this, MainActivity.class);
        getMainIntent.putExtra(MainActivity.USERS_NAME, usersName);
        setResult(RESULT_OK, getMainIntent);
        finish();
    }
}
