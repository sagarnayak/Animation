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

public class MainActivity extends AppCompatActivity {

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

        buttonNormalTransition = (Button) findViewById(R.id.normal_transition);
        buttonSharedElement = (Button) findViewById(R.id.shared_element_transition);
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraint_layout_mainactivity);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        buttonNormalTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupWindowAnimations();
                startActivity(new Intent(MainActivity.this, NormalTransition.class), ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });

        buttonSharedElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setSharedElementExitTransition(new android.transition.ChangeBounds());
                startActivity(new Intent(MainActivity.this, SharedElement.class), ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, Pair.create((View) buttonSharedElement, ViewCompat.getTransitionName(buttonSharedElement))).toBundle());
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ArcMotion.class), ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, Pair.create((View) floatingActionButton, ViewCompat.getTransitionName(floatingActionButton))).toBundle());
            }
        });
    }

    private void setupWindowAnimations() {
        getWindow().setExitTransition(new Slide(Gravity.LEFT));
    }
}
