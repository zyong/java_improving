package com.week1;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Class<?> cls1 = new HelloClassLoader().findClass("Hello");
            Method method = cls1.getDeclaredMethod("hello");
            method.invoke(cls1.getDeclaredConstructor().newInstance());
            // 加载并初始化Hello类
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String pathName = "Hello/Hello.xlass";
        File f = new File(pathName);
        Path path = Paths.get(f.getAbsolutePath());
        byte[] data = null;
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i=0; i<data.length; i++) data[i] = (byte) (255 - data[i]);

        return defineClass(name, data,0, data.length);
    }
}