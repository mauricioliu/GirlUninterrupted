package magpie.com.girluninterrupted;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.SaveCallback;


public class InitialLogo extends Activity {

    private static final String TAG = InitialLogo.class.getSimpleName();
    private static final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Initializing Parse
        Parse.initialize(this, "0yEbEZekduRUsnfYWpBCpgm2WmE7kLz8PPSwVmya", "ZGg1AnOLbqobXdlmZwnxH4c34hctbzjbAM4bJ5aB");
        //ParseFacebookUtils.initialize("930217893673266");
        ParseAnalytics.trackAppOpenedInBackground(getIntent(), new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_logo);
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                //Finish the splash activity so it can't be returned to.
                InitialLogo.this.finish();
                // Create an Intent that will start the main activity.
                Intent mainIntent = new Intent(InitialLogo.this, ConnectActivity.class);
                InitialLogo.this.startActivity(mainIntent);
            }
        }, SPLASH_DISPLAY_LENGTH);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.initial_logo, menu);
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
