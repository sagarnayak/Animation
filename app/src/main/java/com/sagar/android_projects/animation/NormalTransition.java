package com.sagar.android_projects.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Window;

/**
 * create by SAGAR KUMAR NAYAK on 23 OCT 2017
 * this is the target activity for normal left slide transition from the Index Activity.
 */
public class NormalTransition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_normal_transition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupWindowAnimations();
    }

    /**
     * set up the enter animation for the activity.
     */
    private void setupWindowAnimations() {
        getWindow().setEnterTransition(new Slide(Gravity.RIGHT));
    }

}
