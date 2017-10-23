package com.sagar.android_projects.animation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * create by SAGAR KUMAR NAYAK on 23 OCT 2017
 * this is a project for demonstration of the transition animation in android.
 * this is the index activity. on clicking any option the mentioned animation will be played.
 * the listed animation are -
 * 1. normal slide animation.
 * 2. shared element animation.
 * 3. shared element with arc motion animation.
 */
public class MainActivity extends AppCompatActivity {

    //views
    Button buttonNormalTransition;
    Button buttonSharedElement;
    ConstraintLayout constraintLayout;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ////////////////////////////////////////////////////////////////////////////////////////////
        //view holder
        buttonNormalTransition = (Button) findViewById(R.id.normal_transition);
        buttonSharedElement = (Button) findViewById(R.id.shared_element_transition);
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraint_layout_mainactivity);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        ////////////////////////////////////////////////////////////////////////////////////////////

        /*
        on click for normal transition. this will play a simple slide left transition.
         */
        buttonNormalTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupWindowAnimations();
                startActivity(new Intent(MainActivity.this, NormalTransition.class),
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });

        /*
        on click for shared element transition. this will play a shared element transition.
         */
        buttonSharedElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setSharedElementExitTransition(new android.transition.ChangeBounds());
                startActivity(new Intent(MainActivity.this, SharedElement.class),
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                                Pair.create((View) buttonSharedElement,
                                        ViewCompat.getTransitionName(buttonSharedElement))).toBundle());
            }
        });

        /*
        on click for shared element transition with arc motion.
         */
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupWindowAnimations();
                startActivity(new Intent(MainActivity.this, ArcMotion.class),
                        ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                                Pair.create((View) floatingActionButton,
                                        ViewCompat.getTransitionName(floatingActionButton))).toBundle());
            }
        });
    }

    /*
    set up the exit animation for the activity.
     */
    private void setupWindowAnimations() {
        getWindow().setExitTransition(new Slide(Gravity.LEFT));
    }
}
