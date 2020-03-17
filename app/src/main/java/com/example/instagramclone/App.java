package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("XOPqNC1j1SMiSXswARXZV1LNM8NoJcIDFRfJocua")
                // if defined
                .clientKey("CijBTn8InW30ImleAPQCR6yQeNI4tkc1O07TicMf")
                .server("https://parseapi.back4app.com/")
                .build()
        );

    }
}
