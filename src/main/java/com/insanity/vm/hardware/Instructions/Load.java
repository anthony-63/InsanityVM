package com.insanity.vm.hardware.Instructions;

import com.insanity.vm.hardware.InstructionHandler;
import com.insanity.vm.hardware.Processor;

public class Load {
    public static class LWR implements InstructionHandler {
        public void exec(Processor p) {
            int reg = p.fetchb();
            int data = p.fetchw();
            p.regs.write(reg, data);
        }
    }
    public static class LDWR implements InstructionHandler {
        public void exec(Processor p) {
            int reg = p.fetchb();
            int data = p.fetchdw();
            p.regs.write(reg, data);
        }
    }
    public static class LBR implements InstructionHandler {
        public void exec(Processor p) {
            int reg = p.fetchb();
            int data = p.fetchb();
            p.regs.write(reg, data);
        }
    }
    public static class LRR implements InstructionHandler {
        public void exec(Processor p) {
            int reg = p.fetchb();
            int rval = p.regs.read(p.fetchb());
            p.regs.write(reg, rval);
        }
    }
}
