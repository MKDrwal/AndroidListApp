package dev.mateuszkowalczyk.listapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Task> listOfTask = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listOfTask.add(new Task(false, "Yeeey"));
        this.listOfTask.add(new Task(true, "Yeezzz"));
        this.listOfTask.add(new Task(false, "Yeexxx"));

        ListView listView = (ListView)findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return listOfTask.size();
        }

        @Override
        public Object getItem(int position) {
            return listOfTask.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.custom_list, null);

            //CheckBox checkBox = convertView.findViewById(R.id.task_status);
            EditText editText = (EditText) convertView.findViewById(R.id.task_title);

            editText.setText(((Task)this.getItem(position)).getTitle());

            return convertView;
        }
    }

    class Task {
        private String title = "";
        private boolean done = false;

        public Task(boolean done, String title) {
            this.title = title;
            this.done = done;
        }

        public String getTitle() {
            return this.title;
        }
    }
}
