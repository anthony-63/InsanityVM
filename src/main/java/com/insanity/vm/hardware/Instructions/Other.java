package com.insanity.vm.hardware.Instructions;

import com.insanity.vm.hardware.InstructionHandler;
import com.insanity.vm.hardware.Processor;

public class Other {
    public static class VR implements InstructionHandler {
        public void exec(Processor p){
            int reg = p.fetchb();
            System.out.printf("(%02x) -> %08x\n", reg, p.regs.read(reg));
        }
    }
    public static class VW implements InstructionHandler {
        public void exec(Processor p){
            int addr = p.fetchw();
            System.out.printf("&%08x -> %08x\n", addr, p.mem.read(addr));
        }
    }
    public static class VDW implements InstructionHandler {
        public void exec(Processor p){
            int addr = p.fetchdw();
            System.out.printf("&%08x -> %08x\n", addr, p.mem.read(addr));
        }
    }
    public static class Q implements InstructionHandler {
        public void exec(Processor p){
            p.status = 0x60;
        }
    }
}
