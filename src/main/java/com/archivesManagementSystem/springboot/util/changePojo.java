package com.archivesManagementSystem.springboot.util;

public class changePojo {
    String checkColumnName;
    Object oldValue;
    Object newValue;

    public String getCheckColumnName() {
        return checkColumnName;
    }

    public void setCheckColumnName(String checkColumnName) {
        this.checkColumnName = checkColumnName;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }
}
