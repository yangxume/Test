package com.xy.t_bytecode.asm;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-11-11 14:37
 * @Desc:
 */
public class CustomClassVisitor extends ClassVisitor implements Opcodes {

    public CustomClassVisitor(ClassWriter classWriter) {
        super(ASM4,classWriter);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {

        // 方法声明。
        MethodVisitor methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);


        if (name.equals("login")){

            methodVisitor = new MethodVisitor(api,methodVisitor) {
                @Override
                public void visitCode() {
                    super.visitCode();
                    //调用静态方法
                    this.visitMethodInsn(INVOKESTATIC, "com/xy/t_bytecode/bean/LogPrintInterceptor", "startLogPrint", "()V",false);
                }

                @Override
                public void visitInsn(int opcode) {
                    if (opcode == RETURN) {
                        //调用静态方法 LogPrintInterceptor.endLogPrint();
                        mv.visitMethodInsn(INVOKESTATIC, "com/xy/t_bytecode/bean/LogPrintInterceptor", "endLogPrint", "()V",false);
                    }
                    super.visitInsn(opcode);
                }
            };
        }

        return methodVisitor;

    }
}
