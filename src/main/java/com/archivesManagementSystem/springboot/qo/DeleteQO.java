package com.archivesManagementSystem.springboot.qo;

/**
 * 用于删除数据传参
 */
public class DeleteQO {

    private int id;

    private int[] ids;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }
}
