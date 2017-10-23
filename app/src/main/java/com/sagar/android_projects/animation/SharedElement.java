package com.sagar.android_projects.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * create by SAGAR KUMAR NAYAK on 23 OCT 2017
 * this is the target activity for shared element transition animation from the mainactivity.
 */
public class SharedElement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getWindow().setSharedElementEnterTransition(new android.transition.ChangeBounds());
    }

}
