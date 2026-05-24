package com.vogella.java.library.gson;

public class Task {
    private final long id;
    private String summary;
    private String description;
    private Status status;
    private int priority;

    public enum Status {
        CREATED, ASSIGNED, CANCELED, COMPLETED
    }

    public Task(long id, String summary, String description, Status status, int priority) {
        this.id = id;
        this.summary = summary;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{id=" + id +
                ", summary='" + summary + '\'' +
                ", status=" + status +
                ", priority=" + priority + '}';
    }
}