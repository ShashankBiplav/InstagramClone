package com.example.instagramclone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpLoginActivity extends AppCompatActivity {

    private EditText editTextUsernameSignup, editTextPasswordSignup, editTextUsernameLogin, editTextPasswordLogin;

    private Button buttonSignup, buttonLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) { // savedInstanceState holds the state of the application
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup_login_activity);

        editTextUsernameSignup = findViewById(R.id.editTextUsernameSignup);
        editTextPasswordSignup = findViewById(R.id.editTextPasswordSignup);
        editTextUsernameLogin = findViewById(R.id.editTextUsernameLogin);
        editTextPasswordLogin = findViewById(R.id.editTextPasswordLogin);
        buttonSignup = findViewById(R.id.buttonSignUp);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ParseUser appUser = new ParseUser();
                appUser.setUsername(editTextUsernameSignup.getText().toString());
                appUser.setPassword(editTextPasswordSignup.getText().toString());
                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if ( e== null){
                            FancyToast.makeText(SignUpLoginActivity.this,
                                    appUser.get("username")+" is Signed Up Successfully!",
                                    FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                        }
                        else{
                            FancyToast.makeText(SignUpLoginActivity.this,
                                    e.getMessage(),
                                    FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

                        }
                    }
                });
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground(editTextUsernameLogin.getText().toString(),
                        editTextPasswordLogin.getText().toString(), new LogInCallback() {
                            @Override
                            public void done(ParseUser user, ParseException e) {
                                if (user != null && e== null){
                                    FancyToast.makeText(SignUpLoginActivity.this, user.get("username")+" is Logged in Successfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

                                }
                                else {
                                    FancyToast.makeText(SignUpLoginActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

                                }
                            }
                        });
            }
        });
    }
}
