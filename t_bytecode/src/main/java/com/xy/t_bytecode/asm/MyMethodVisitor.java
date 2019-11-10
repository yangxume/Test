package com.xy.t_bytecode.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

class MyMethodVisitor extends MethodVisitor implements Opcodes {

    public MyMethodVisitor(int api, MethodVisitor mv) {
        super(api, mv);
    }

    public void visitCode() {
        super.visitCode();
        this.visitMethodInsn(INVOKESTATIC, "com/xy/t_bytecode/bean/LogPrintInterceptor", "startLogPrint", "()V");
    }

    public void visitInsn(int opcode) {
        if (opcode == RETURN) {
            mv.visitMethodInsn(INVOKESTATIC, "com/xy/t_bytecode/bean/LogPrintInterceptor", "endLogPrint", "()V");
        }
        super.visitInsn(opcode);
    }

}
