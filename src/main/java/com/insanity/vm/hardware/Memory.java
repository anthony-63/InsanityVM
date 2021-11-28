package com.insanity.vm.hardware;

public class Memory {
    private int mem[];
    public Memory(int size) {
        this.mem = new int[size];
    }
    public int read(int addr){
        return this.mem[addr];
    }
    public void write(int addr, int data){
        this.mem[addr] = data;
    }
}
