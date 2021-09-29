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
    private Button hideSheet;
    private BottomSheetBehavior bottomSheetBehavior;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Adding code for full screen
        if (Build.VERSION.SDK_INT>=21)
        {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        showSheet = findViewById(R.id.showSheet);
        hideSheet = findViewById(R.id.hideSheet);

        LinearLayout bottomSheetLayout = findViewById(R.id.buttonSheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout);


        //visible part of button sheet default
        bottomSheetBehavior.setPeekHeight(320);

//        //setting bottom peak layout unhideable
//        bottomSheetBehavior.setHideable(false);


        showSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetLayout.setVisibility(View.VISIBLE);
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });


        hideSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                bottomSheetLayout.setVisibility(View.INVISIBLE);

            }
        });
    }
}
