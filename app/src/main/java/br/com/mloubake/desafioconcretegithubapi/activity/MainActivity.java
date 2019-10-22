package br.com.mloubake.desafioconcretegithubapi.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;

import br.com.mloubake.desafioconcretegithubapi.R;

public class MainActivity extends AppCompatActivity {

 int screenOrientation;

 RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupView();
        getScreenOrientation();

    }

    private void getScreenOrientation() {
        if(screenOrientation == Configuration.ORIENTATION_PORTRAIT) {

        } else {

        }
    }

    private void setupView() {
        screenOrientation = this.getResources().getConfiguration().orientation;
        mRecyclerView = findViewById(R.id.recyclerView);
    }

}
