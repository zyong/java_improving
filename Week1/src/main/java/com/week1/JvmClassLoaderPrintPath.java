package com.week1;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

public class JvmClassLoaderPrintPath {
    public static void main(String[] args) {

        // 扩展类加载器
        printClassloader("扩张了加载器", JvmClassLoaderPrintPath.class.getClassLoader().getParent());

        // 应用类加载器
        printClassloader("应用类加载器", JvmClassLoaderPrintPath.class.getClassLoader());
    }


    private static void printClassloader(String name, ClassLoader classLoader) {
        System.out.println();
        if (null != classLoader) {
            System.out.println(name + " Classloader ->" + classLoader.toString());
            printURLForClassloader(classLoader);
        } else {
            System.out.println(name + "Classloader -> null");
        }
    }

    private static void printURLForClassloader(ClassLoader classLoader) {
        Object ucp = insightField(classLoader, "ucp");
        Object path = insightField(ucp, "path");
        List paths = (List)path;
        for (Object p : paths) {
            System.out.println(" ===> " + p.toString());
        }
    }

    private static Object insightField(Object obj, String fName) {
        Field f = null;
        try {
            if (obj instanceof URLClassLoader) {
                f = URLClassLoader.class.getDeclaredField(fName);
            } else {
                f = obj.getClass().getDeclaredField(fName);
            }
            f.setAccessible(true);
            return f.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
