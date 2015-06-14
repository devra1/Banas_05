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
        Intent firstActivityIntent = getIntent();
        TextView callingName = (TextView)findViewById(R.id.calling_activity_info_text_view);

//        String activityName = firstActivityIntent.getStringExtra(MainActivity.ACTIVITY_NAME);
//        callingName.append(" " + activityName);

        Human person = (Human) firstActivityIntent.getSerializableExtra("human_name");
        callingName.append(" " + person.getName() + " " + person.getHeight() +
        " ft.  " + person.getWeight() + " lb.");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onSendUsersName(View view) {
        EditText usersEditText = (EditText) findViewById(R.id.user_name_edit_text);
        String usersName = usersEditText.getText().toString();

        Intent returnIntent = new Intent(this,MainActivity.class);
        returnIntent.putExtra(MainActivity.USERS_NAME, usersName);
        setResult(RESULT_OK,returnIntent);
        finish();
    }
}
