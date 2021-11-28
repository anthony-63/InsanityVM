package com.insanity.vm.hardware;

public class Registers {
    private int regs[];
    Registers(int count) {
        regs = new int[16];
    }
    public int read(int register){
        return regs[register];
    }
    public void write(int register, int data){
        this.regs[register] = data;
    }
}
