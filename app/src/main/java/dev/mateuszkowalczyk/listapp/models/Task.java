package dev.mateuszkowalczyk.listapp.models;

public class Task {
    private String name;
    private boolean done = false;

    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    public Task(boolean done, String title) {
        this.name = title;
        this.done = done;
    }

    public String getName() {
        return this.name;
    }

    public Boolean isDone() {
        return this.done;
    }

    public void markAsDone() {
        this.done = true;
    }
}
