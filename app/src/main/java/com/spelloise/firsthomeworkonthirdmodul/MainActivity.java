package com.spelloise.firsthomeworkonthirdmodul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textCount;
    private int count = 0;

    private Button button;
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            count++;
            textCount.setText(Integer.toString(count));
        }
    };

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        count = savedInstanceState.getInt("count");
        Toast toast = Toast.makeText(this, R.string.toastRestore, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.LEFT, 200, 200);
        LinearLayout toastConteiner = (LinearLayout) toast.getView();
        ImageView cat = new ImageView(this);
        cat.setImageResource(R.drawable.cat);
        toastConteiner.addView(cat, 1);

        toast.show();
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {

        Toast toast = Toast.makeText(this, R.string.toastStart, Toast.LENGTH_LONG);
        toast.show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Toast toast = Toast.makeText(this, R.string.toastStop, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.RIGHT, 0, 0);
        toast.show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast toast = Toast.makeText(this, R.string.toastDestroy, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 200, 200);
        toast.show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast toast = Toast.makeText(this, R.string.toastPause, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast toast = Toast.makeText(this, R.string.toastResume, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 200, 300);
        toast.show();
        textCount.setText(Integer.toString(count));
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("count", count);
        Toast toast = Toast.makeText(this, R.string.toastSave, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.LEFT, 0, 0);
        toast.show();
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        textCount = findViewById(R.id.textCount);

        button = findViewById(R.id.button);
        button.setOnClickListener(listener);

        super.onCreate(savedInstanceState);
    }
}
