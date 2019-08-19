package dev.mateuszkowalczyk.listapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dev.mateuszkowalczyk.listapp.R;
import dev.mateuszkowalczyk.listapp.fragments.TaskFragment.OnListFragmentInteractionListener;
import dev.mateuszkowalczyk.listapp.models.Task;

import java.util.List;

///**
// * {@link RecyclerView.Adapter} that can display a {@link Task} and makes a call to the
// * specified {@link OnListFragmentInteractionListener}.
// */
public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskRecyclerViewAdapter.ViewHolder> {

    private final List<Task> taskList;
    private final OnListFragmentInteractionListener listener;

    public TaskRecyclerViewAdapter(List<Task> items, OnListFragmentInteractionListener listener) {
        taskList = items;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.taskName.setText(taskList.get(position).getName());

        holder.taskFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    listener.onListFragmentInteraction(holder.task);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View taskFragment;
        public final TextView taskName;
        public Task task;

        public ViewHolder(View view) {
            super(view);
            taskFragment = view;
            taskName = (TextView) view.findViewById(R.id.task_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + taskName.getText() + "'";
        }
    }
}
