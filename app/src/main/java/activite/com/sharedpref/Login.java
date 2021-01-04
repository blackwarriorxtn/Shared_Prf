package activite.com.sharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class Login extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText mName, mPassword;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mName = (EditText) findViewById(R.id.etName);
        mPassword = (EditText) findViewById(R.id.etPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        mCheckBox = (CheckBox) findViewById(R.id.checkbox);


        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        checkSharedPreferences();

        btnLogin.setOnClickListener(view -> {
            //save the checkbox preference
            if(mCheckBox.isChecked()){
                //set a checkbox when the application starts
                mEditor.putString(getString(R.string.checkbox), "True");
                mEditor.apply();

                //save the name
                String name = mName.getText().toString();
                mEditor.putString(getString(R.string.name), name);
                mEditor.apply();

                //save the password
                String password = mPassword.getText().toString();
                mEditor.putString(getString(R.string.password), password);
                mEditor.apply();

                Intent intent = new Intent(Login.this, Home.class);
                startActivity(intent);

            }else{
                //set a checkbox when the application starts
                mEditor.putString(getString(R.string.checkbox), "False");

                mEditor.apply();

                //save the name
                mEditor.putString(getString(R.string.name), "");
                mEditor.apply();

                //save the password
                mEditor.putString(getString(R.string.password), "");
                mEditor.apply();
            }
        });

    }


    private void checkSharedPreferences(){
        String checkbox = mPreferences.getString(getString(R.string.checkbox), "False");
        String name = mPreferences.getString(getString(R.string.name), "");
        String password = mPreferences.getString(getString(R.string.password), "");



        mName.setText(name);
        mPassword.setText(password);

        mCheckBox.setChecked(checkbox.equals("True"));

    }
}
