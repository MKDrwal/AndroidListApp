package dev.mateuszkowalczyk.listapp.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import dev.mateuszkowalczyk.listapp.CreateTaskDialog;
import dev.mateuszkowalczyk.listapp.R;
import dev.mateuszkowalczyk.listapp.fragments.TaskFragment;
import dev.mateuszkowalczyk.listapp.models.Task;

public class MainActivity extends AppCompatActivity implements TaskFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        FloatingActionButton floatingActionButton = findViewById(R.id.floating_button_add_new_task);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateTaskDialog bottomSheetDialog = new CreateTaskDialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "createTaskBottomSheet");
            }
        });

    }

    @Override
    public void onListFragmentInteraction(Task item) {

    }
}
