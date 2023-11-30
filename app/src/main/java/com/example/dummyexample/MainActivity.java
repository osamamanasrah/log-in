package com.example.dummyexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String NAME = "NAME";
    private static final String PASSWORD = "PASS";
    private static final String FLAG = "FLAG";
    private EditText editText1;
    private EditText editText2;
    private CheckBox checkBox;
    private Button button;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
        setUpSharedPreferences();
        checkPreference();
    }

    private void checkPreference() {
        boolean flag = sharedPreferences.getBoolean(FLAG,false);
        if(flag){
            editText1.setText(sharedPreferences.getString(NAME,""));
            editText2.setText(sharedPreferences.getString(PASSWORD,""));
            checkBox.setChecked(true);
        }
    }

    private void setUpSharedPreferences() {
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor=sharedPreferences.edit();
    }

    private void setUpViews() {
        editText1=findViewById(R.id.edt1);
        editText2=findViewById(R.id.edt2);
        checkBox=findViewById(R.id.checkbox);
        button=findViewById(R.id.btnSubmit);
    }


    public void btnSubmitOnclick(View view) {
        String Name = editText1.getText().toString();
        String Password = editText2.getText().toString();

        if(checkBox.isChecked()){
            editor.putString(NAME, Name);
            editor.putString(PASSWORD, Password);
            editor.putBoolean(FLAG, true);
            editor.commit();
        }
    }
}