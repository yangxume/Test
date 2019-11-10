package com.xy.t_bytecode;

import com.xy.t_bytecode.asm.MyClassVisitor;
import com.xy.t_bytecode.classloader.DiskClassLoader;

import org.junit.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;
import static org.objectweb.asm.Opcodes.ASM4;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testClassLoader(){

        DiskClassLoader diskClassLoader = new DiskClassLoader("/Users/xuyang/Documents/work_android/Test/t_bytecode/src/main/java/com/xy/t_bytecode/bean");//1
        try {
            Class c = diskClassLoader.loadClass("com.xy.t_bytecode.bean.LoginPresenter");//2
            if (c != null) {
                try {
                    Object obj = c.newInstance();
                    System.out.println(obj.getClass().getClassLoader());
                    Method method = c.getDeclaredMethod("login", null);
                    method.invoke(obj, null);//3
                } catch (InstantiationException | IllegalAccessException
                        | NoSuchMethodException
                        | SecurityException |
                        IllegalArgumentException |
                        InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAsmCreateNewClass(){

        try {

            ClassWriter classWriter = new ClassWriter(0);

            FileInputStream fileInputStream = new FileInputStream("/Users/xuyang/Documents/work_android/Test/t_bytecode/src/main/java/com/xy/t_bytecode/bean/LoginPresenter.class");
            ClassReader classReader = new ClassReader(fileInputStream);
            classReader.accept(new MyClassVisitor(ASM4,classWriter),ClassReader.SKIP_DEBUG);

            byte[] code = classWriter.toByteArray();
            FileOutputStream fos = new FileOutputStream("/Users/xuyang/Documents/work_android/Test/t_bytecode/src/main/java/com/xy/t_bytecode/bean/LoginPresenter_new.class");
            fos.write(code);
            fos.flush();
            fos.close();

//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}