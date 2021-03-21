package com.mark;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloClassLoader  {
    public static void main(String[] args) {
        String appPath = "file:/Users/zhaoyong/Develop/JAVA/java_improving/week1/Hello/";
        URLClassLoader urlClassLoader = (URLClassLoader) HelloClassLoader.class.getClassLoader();
        try {
            Method  addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            addURL.setAccessible(true);
            URL url = new URL(appPath);
            addURL.invoke(urlClassLoader, url);
            Class.forName("Hello");
//            Hello hello = (Hello) new HelloClassLoader().findClass("Hello").getDeclaredConstructor().newInstance();
            // 加载并初始化Hello类
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        String pathName = "week1/Hello/Hello.xlass";
//        File f = new File(pathName);
//        Path path = Paths.get(f.getAbsolutePath());
//        byte[] data = null;
//        try {
//            data = Files.readAllBytes(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for (int i=0; i<data.length; i++) data[i] = (byte) (255 - data[i]);
//
//        return defineClass(name, data,0, data.length);
//    }
}