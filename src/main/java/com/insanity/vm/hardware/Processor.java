package com.insanity.vm.hardware;

public class Processor {
    public Memory mem;
    public Registers regs;
    public Stack stack;
    public int pc;
    public int status;
    public InstructionsRunner instructionRunner;
    public Processor(Memory memory){
        this.mem = memory;
        this.regs = new Registers(16);
        this.stack = new Stack();
        this.pc = 0;
        this.status = 0;
        this.instructionRunner = new InstructionsRunner(this);
    }
    private void viewMemory(int n) {
        System.out.printf("%04x -> ", this.pc);
        for(int i = 0; i < n; i++) {
            System.out.printf("%02x ", this.mem.read(this.pc + i));
        }
        if(this.pc == 0) {
            System.out.printf("<---- Starting Program");
        }
        System.out.println();
    }
    public int fetchb() {
        viewMemory(8);
        return this.mem.read(this.pc++) & 0xff;

    }
    public int fetchw() {
        viewMemory(8);
        return ((this.mem.read(this.pc++) << 8) & 0xff00) | (this.mem.read(this.pc++) & 0xff);
    }
    public int fetchdw() {
        viewMemory(8);
        int f4 = (this.mem.read(this.pc++) & 0xff) << 24;
        int s4 = (this.mem.read(this.pc++) & 0xff) << 16;
        int t4 = (this.mem.read(this.pc++) & 0xff) << 8;
        int l4 = (this.mem.read(this.pc++) & 0xff);
        return f4 | s4 | t4 | l4;
    }
    public void execute(int instruction) {
        this.instructionRunner.run(instruction);
    }
    public void run(int location){
        this.status = 0xff;
        while(this.status == 0xff) {
            int inst = this.fetchb();
            this.execute(inst);
        }
    }
}
