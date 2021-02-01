package com.archivesManagementSystem.springboot.util;

public class Page {
    private static final long serialVersionUID = -961843753319341L;
    int start;
    int size;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
