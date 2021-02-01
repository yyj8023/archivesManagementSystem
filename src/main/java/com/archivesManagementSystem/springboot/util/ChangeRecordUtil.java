package com.archivesManagementSystem.springboot.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Vector;

public class ChangeRecordUtil<T> {
    public List<changePojo> contrastObj(Object oldBean, Object newBean) {
        List<changePojo> list=new Vector<changePojo>();

        String str = "";
        T pojo1 = (T) oldBean;
        T pojo2 = (T) newBean;
        try {
            Class clazz = pojo1.getClass();
            Field[] fields = pojo1.getClass().getDeclaredFields();
            int i = 1;
            for (Field field : fields) {
                if ("serialVersionUID".equals(field.getName())) {
                    continue;
                }
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                Method getMethod = pd.getReadMethod();
                Object o1 = getMethod.invoke(pojo1);
                Object o2 = getMethod.invoke(pojo2);
                if (o1 == null || o2 == null) {
                    continue;
                }
/*                if (!o1.toString().equals(o2.toString())) {
                    if (i != 1) {
                        str += ";";
                    }
                    str += i + "字段名称:" + field.getName() + ",旧值:" + o1 + ",新值:" + o2;
                    i++;
                }*/
                if (!o1.toString().equals(o2.toString())) {
/*                    if (i != 1) {
                        str += ";";
                    }*/
                    changePojo change=new changePojo();
                    change.setCheckColumnName(field.getName());
                    change.setOldValue(o1);
                    change.setNewValue(o2);
                   /* str += i + "字段名称:" + field.getName() + ",旧值:" + o1 + ",新值:" + o2;*/
                    i++;
                    list.add(change);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
