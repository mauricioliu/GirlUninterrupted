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

import com.parse.ParseObject;
import com.parse.ParseRelation;
import com.parse.ParseUser;

import java.util.Arrays;


public class MealsProfileActivity extends Activity {

    protected String[]fitnessList;
    protected String workout;

    protected RadioGroup mMealsRadioGroup;
    protected RadioButton mMealsRadioButton;

    protected TextView mPreviousLabel;
    protected TextView mFinishLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_profile);

        fitnessList = getIntent().getStringArrayExtra("FITNESS_LIST");
        workout = getIntent().getStringExtra("WORKOUT");

        mPreviousLabel = (TextView) findViewById(R.id.previousLabel);
        mPreviousLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mMealsRadioGroup = (RadioGroup) findViewById(R.id.MealsRadioGroup);
        mFinishLabel = (TextView) findViewById(R.id.finishLabel);
        mFinishLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = mMealsRadioGroup.getCheckedRadioButtonId();
                mMealsRadioButton = (RadioButton) findViewById(selectedId);

                ParseObject profile = new ParseObject("Profile");
                profile.addAllUnique("fitness", Arrays.asList(fitnessList));
                profile.put("workout", workout);
                profile.put("meals", mMealsRadioButton.getText());
                profile.put("owner", ParseUser.getCurrentUser());
                profile.saveInBackground();

                Intent intent = new Intent(MealsProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.meals_profile, menu);
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
