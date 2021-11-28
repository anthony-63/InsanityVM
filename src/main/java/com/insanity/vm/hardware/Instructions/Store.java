package com.insanity.vm.hardware.Instructions;

import com.insanity.vm.hardware.InstructionHandler;
import com.insanity.vm.hardware.Processor;

public class Store {
    public static class SR implements InstructionHandler {
        public void exec(Processor p) {
            int addr = p.fetchw();
            int regv = p.regs.read(p.fetchb());
            p.mem.write(addr, regv);
        }
    }
    public static class SW implements InstructionHandler {
        public void exec(Processor p) {
            int addr = p.fetchw();
            int data = p.fetchw();
            p.mem.write(addr, data);
        }
    }
    public static class SDW implements InstructionHandler {
        public void exec(Processor p) {
            int addr = p.fetchw();
            int data = p.fetchdw();
            p.mem.write(addr, data);
        }
    }public static class SB implements InstructionHandler {
        public void exec(Processor p) {
            int addr = p.fetchw();
            int data = p.fetchb();
            p.mem.write(addr, data);
        }
    }
}
