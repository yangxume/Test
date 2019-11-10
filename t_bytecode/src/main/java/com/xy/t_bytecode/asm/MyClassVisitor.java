package com.xy.t_bytecode.asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MyClassVisitor extends ClassVisitor implements Opcodes {

    public MyClassVisitor(int api, ClassVisitor cv) {
        super(api, cv);
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        //更改类名，并使新类继承原有的类。
        super.visit(version, access, name + "_new", signature, name, interfaces);
        {
            MethodVisitor mv = super.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, name, "<init>", "()V",false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
    }
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {

        if ("<init>".equals(name))
            return null;
        if (!name.equals("login"))
            return null;

        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);

        return new MyMethodVisitor(this.api, mv);
    }
}

