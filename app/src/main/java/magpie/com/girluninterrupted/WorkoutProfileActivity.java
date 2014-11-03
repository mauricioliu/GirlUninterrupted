package magpie.com.girluninterrupted;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class WorkoutProfileActivity extends Activity {

    protected String[]fitnessList;

    protected RadioGroup mWorkoutRadioGroup;
    protected RadioButton mWorkoutRadioButton;

    protected TextView mPreviousLabel;
    protected TextView mNextLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_profile);

        fitnessList = getIntent().getStringArrayExtra("FITNESS_LIST");

        mPreviousLabel = (TextView) findViewById(R.id.previousLabel);
        mPreviousLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mWorkoutRadioGroup = (RadioGroup) findViewById(R.id.workoutRadioGroup);
        mNextLabel = (TextView) findViewById(R.id.nextLabel);
        mNextLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = mWorkoutRadioGroup.getCheckedRadioButtonId();
                mWorkoutRadioButton = (RadioButton) findViewById(selectedId);

                Intent intent = new Intent(WorkoutProfileActivity.this, MealsProfileActivity.class);
                intent.putExtra("FITNESS_LIST", fitnessList);
                intent.putExtra("WORKOUT", mWorkoutRadioButton.getText());
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.workout_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
