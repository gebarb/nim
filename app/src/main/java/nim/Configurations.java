package nim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;


public class Configurations extends AppCompatActivity {

    public static final String STARTPLAYER = "com.nim.player";
    public static final String NUMROWS = "com.nim.numrows";
    public static final String PLAYERNAME = "com.nim.username";
    public static final String DIFFICULTY = "com.nim.difficulty";


    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurations);

        Intent intent = getIntent();


        username = intent.getStringExtra(MainActivity.USERNAME);


        //if username provided at user to the database
        if(!(MainActivity.get().is_guest()))
        {
            final UserData user = new UserData();

            user.setLosses(0);
            user.setWins(0);
            user.setUsername(username);

            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    MainActivity.get().getDB().userDao().addUser(user);
                }
            }).start();
        }

    }


    public void startGame(View view) {

        Intent intent = new Intent(this, Gameplay.class);


        int whoStarts;
        int numRows;
        int difficulty;


        //gets the start player from the radio buttons
        if (((RadioButton) findViewById(R.id.computerStart)).isChecked()) {
            whoStarts = 1;
        } else {
            whoStarts = 0;
        }

        //gets the number of rows from the radio button
        if (((RadioButton) findViewById(R.id.rows5)).isChecked()) {
            numRows = 5;
        } else if (((RadioButton) findViewById(R.id.rows6)).isChecked()) {
            numRows = 6;
        } else {
            numRows = 7;
        }

        //gets the difficulty level .....1 for easy, 2 for medium and 3 for hard.
        if (((RadioButton) findViewById(R.id.easy)).isChecked())
            difficulty=1;
        else difficulty=2;

        //attaches the values to the activity
        intent.putExtra(STARTPLAYER, whoStarts);
        intent.putExtra(NUMROWS, numRows);
        intent.putExtra(DIFFICULTY, difficulty);
        intent.putExtra(PLAYERNAME, username);


        //starts the next activity
        finish();
        startActivity(intent);

    }
}
