package activite.com.sharedpref;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // get the empty name ( text view )
        TextView mName = (TextView) findViewById(R.id.NameResult);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();

        String NewName = mPreferences.getString(getString(R.string.name), "");
       // show back the login name into the home
        mName.setText("hello " + NewName);

    }
}
