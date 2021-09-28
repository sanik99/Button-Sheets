package com.example.bottonsheet_persistent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    private Button showSheet;
    private BottomSheetBehavior bottomSheetBehavior;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Adding code for full screen
        if (Build.VERSION.SDK_INT>=21)
        {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        showSheet = findViewById(R.id.showSheet);

        LinearLayout bottomSheetLayout = findViewById(R.id.buttonSheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);


        //visible part of button sheet default
        bottomSheetBehavior.setPeekHeight(200);

        //setting set unhideable
        bottomSheetBehavior.setHideable(false);



        showSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetBehavior.setPeekHeight(200);
                bottomSheetBehavior.setHideable(false);


            }
        });

        //set callback for changes
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

               if ( newState==BottomSheetBehavior.STATE_COLLAPSED)
               {

                   bottomSheetBehavior.setPeekHeight(0);
                   showSheet.setVisibility(View.VISIBLE);
               }

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                // hiding view on slide
                showSheet.setVisibility(View.INVISIBLE);


            }
        });




    }
}