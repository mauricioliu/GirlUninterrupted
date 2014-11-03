package magpie.com.girluninterrupted;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FitnessProfileActivity extends Activity {

    protected CheckBox mRunCheckBox;
    protected CheckBox mWalkCheckBox;
    protected CheckBox mYogaCheckBox;
    protected CheckBox mPilatesCheckBox;
    protected CheckBox mCrossfitCheckBox;
    protected CheckBox mNoneCheckBox;

    protected TextView mNextLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_profile);

        mRunCheckBox = (CheckBox) findViewById(R.id.runCheckBox);
        mWalkCheckBox = (CheckBox) findViewById(R.id.walkCheckBox);
        mYogaCheckBox = (CheckBox) findViewById(R.id.yogaCheckBox);
        mPilatesCheckBox = (CheckBox) findViewById(R.id.pilatesCheckBox);
        mCrossfitCheckBox = (CheckBox) findViewById(R.id.crossfitCheckBox);
        mNoneCheckBox = (CheckBox) findViewById(R.id.noneCheckBox);

        /*mPreviousLabel = (TextView) findViewById(R.id.previousLabel);
        mPreviousLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FitnessProfileActivity.this, GetStartedActivity.class);
                startActivity(intent);
            }
        });*/

        mNoneCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    mRunCheckBox.setChecked(false);
                    mWalkCheckBox.setChecked(false);
                    mYogaCheckBox.setChecked(false);
                    mPilatesCheckBox.setChecked(false);
                    mCrossfitCheckBox.setChecked(false);

                    mRunCheckBox.setClickable(false);
                    mWalkCheckBox.setClickable(false);
                    mYogaCheckBox.setClickable(false);
                    mPilatesCheckBox.setClickable(false);
                    mCrossfitCheckBox.setClickable(false);
                } else {
                    mRunCheckBox.setClickable(true);
                    mWalkCheckBox.setClickable(true);
                    mYogaCheckBox.setClickable(true);
                    mPilatesCheckBox.setClickable(true);
                    mCrossfitCheckBox.setClickable(true);
                }
            }
        });

        mNextLabel = (TextView) findViewById(R.id.nextLabel);
        mNextLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                List<String> fitnessList = new ArrayList<String>();

                int count = 0;
                if (mRunCheckBox.isChecked()) {
                    fitnessList.add(mRunCheckBox.getText().toString());
                    count++;
                }
                if (mWalkCheckBox.isChecked()) {
                    fitnessList.add(mWalkCheckBox.getText().toString());
                    count++;
                }
                if (mYogaCheckBox.isChecked()) {
                    fitnessList.add(mYogaCheckBox.getText().toString());
                    count++;
                }
                if (mPilatesCheckBox.isChecked()) {
                    fitnessList.add(mPilatesCheckBox.getText().toString());
                    count++;
                }
                if (mCrossfitCheckBox.isChecked()) {
                    fitnessList.add(mCrossfitCheckBox.getText().toString());
                    count++;
                }
                if (mNoneCheckBox.isChecked()) {
                    fitnessList.add(mNoneCheckBox.getText().toString());
                    count++;
                }
                if (!mNoneCheckBox.isChecked()) {
                    intent = new Intent(FitnessProfileActivity.this, WorkoutProfileActivity.class);
                } else {
                    intent = new Intent(FitnessProfileActivity.this, MealsProfileActivity.class);
                }

                intent.putExtra("FITNESS_LIST", fitnessList.toArray(new String[fitnessList.size()]));
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.fitness_profile, menu);
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
