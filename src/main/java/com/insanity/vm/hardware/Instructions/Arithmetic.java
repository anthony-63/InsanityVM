package com.insanity.vm.hardware.Instructions;

import com.insanity.vm.hardware.InstructionHandler;
import com.insanity.vm.hardware.Processor;

public class Arithmetic {
    public static class ADDWR implements InstructionHandler {
        public void exec(Processor p){
            int reg = p.fetchb();
            int data = p.fetchw();
            p.regs.write(reg, p.regs.read(reg) + data);
        }
    }
    public static class ADDDWR implements InstructionHandler {
        public void exec(Processor p){
            int reg = p.fetchb();
            int data = p.fetchdw();
            p.regs.write(reg, p.regs.read(reg) + data);
        }
    }
    public static class ADDRR implements InstructionHandler {
        public void exec(Processor p){
            int regt = p.fetchb();
            int data = p.regs.read(p.fetchb());
            p.regs.write(regt, p.regs.read(regt) + data);
        }
    }
    public static class SUBWR implements InstructionHandler {
        public void exec(Processor p){
            int reg = p.fetchb();
            int data = p.fetchw();
            p.regs.write(reg, p.regs.read(reg) + data);
        }
    }
    public static class SUBDWR implements InstructionHandler {
        public void exec(Processor p){
            int reg = p.fetchb();
            int data = p.fetchdw();
            p.regs.write(reg, p.regs.read(reg) + data);
        }
    }
    public static class SUBRR implements InstructionHandler {
        public void exec(Processor p){
            int regt = p.fetchb();
            int data = p.regs.read(p.fetchb());
            p.regs.write(regt, p.regs.read(regt) + data);
        }
    }
    public static class MULWR implements InstructionHandler {
        public void exec(Processor p){
            int reg = p.fetchb();
            int data = p.fetchw();
            p.regs.write(reg, p.regs.read(reg) + data);
        }
    }
    public static class MULDWR implements InstructionHandler {
        public void exec(Processor p){
            int reg = p.fetchb();
            int data = p.fetchdw();
            p.regs.write(reg, p.regs.read(reg) + data);
        }
    }
    public static class MULRR implements InstructionHandler {
        public void exec(Processor p){
            int regt = p.fetchb();
            int data = p.regs.read(p.fetchb());
            p.regs.write(regt, p.regs.read(regt) + data);
        }
    }
}
