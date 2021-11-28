package com.insanity.vm.hardware;

import com.insanity.vm.hardware.Instructions.*;

class Inst {
    // Loading instructions
    public static int LWR = 0x00, LDWR = 0x01, LBR = 0x02;
    public static int LRR = 0x03;
    // Storing instructions
    public static int SR = 0x10;
    public static int SW = 0x11, SDW = 0x12, SB = 0x13;
    // Arithmetic Operations
    public static int ADDWR = 0x20, ADDDWR = 0x21;
    public static int ADDRR = 0x22;
    public static int SUBWR = 0x23, SUBDWR = 0x24;
    public static int SUBRR = 0x25;
    public static int MULWR = 0x26, MULDWR = 0x27;
    public static int MULRR = 0x28;
    //Logical operations
    public static int XORWR = 0x30, XORDWR = 0x31; 
    public static int XORRR = 0x32;
    public static int NOTR = 0x33;
    public static int ANDWR = 0x34, ANDDWR = 0x35; 
    public static int ANDRR = 0x36;
    public static int ORWR = 0x37, ORDWR = 0x38; 
    public static int ORRR = 0x39;
    // Comparison instructions
    public static int CMPWR = 0x40, CMPDWR = 0x41;
    public static int CMPRR = 0x42;
    // Branching instructions 
    public static int JER = 0x50;
    public static int JEW = 0x51, JEDW = 0x52;
    public static int JLR = 0x53;
    public static int JLW = 0x54, JLDW = 0x55;
    public static int JGR = 0x56;
    public static int JGW = 0x57, JGDW = 0x58;
    public static int JLER = 0x59;
    public static int JLEW = 0x5a, JLEDW = 0x5b;
    public static int JGER = 0x5c;
    public static int JGEW = 0x5d, JGEDW = 0x5e;
    public static int JMPA = 0x5f;
    public static int JMPW = 0x60, JMPDW = 0x61;
    // Other stuff
    public static int VR = 0x70;
    public static int VW = 0x71, VDW = 0x72;
    public static int Q = 0xff;
}

public class InstructionsRunner {
    private InstructionHandler handlers[] = new InstructionHandler[Inst.Q + 1];
    private Processor p;
    InstructionsRunner(Processor p) {
        handlers[Inst.LWR] = new Load.LWR();
        handlers[Inst.LDWR] = new Load.LDWR();
        handlers[Inst.LBR] = new Load.LBR();
        handlers[Inst.LRR] = new Load.LRR();
        handlers[Inst.SR] = new Store.SR();
        handlers[Inst.SW] = new Store.SW();
        handlers[Inst.SDW] = new Store.SDW();
        handlers[Inst.SB] = new Store.SB();
        handlers[Inst.ADDWR] = new Arithmetic.ADDWR();
        handlers[Inst.ADDDWR] = new Arithmetic.ADDDWR();
        handlers[Inst.ADDRR] = new Arithmetic.ADDRR();
        handlers[Inst.SUBWR] = new Arithmetic.SUBWR();
        handlers[Inst.SUBDWR] = new Arithmetic.SUBDWR();
        handlers[Inst.SUBRR] = new Arithmetic.SUBRR();
        handlers[Inst.MULWR] = new Arithmetic.MULWR();
        handlers[Inst.MULDWR] = new Arithmetic.MULDWR();
        handlers[Inst.MULRR] = new Arithmetic.MULRR();
        handlers[Inst.XORWR] = new Logical.XORWR();
        handlers[Inst.XORDWR] = new Logical.XORDWR();
        handlers[Inst.XORRR] = new Logical.XORRR();
        handlers[Inst.NOTR] = new Logical.NOTR();
        handlers[Inst.ANDWR] = new Logical.ANDWR();
        handlers[Inst.ANDDWR] = new Logical.ANDDWR();
        handlers[Inst.ANDRR] = new Logical.ANDRR();
        handlers[Inst.ORWR] = new Logical.ORWR();
        handlers[Inst.ORDWR] = new Logical.ORDWR();
        handlers[Inst.ORRR] = new Logical.ORRR();
        handlers[Inst.CMPWR] = new Comparison.CMPWR();
        handlers[Inst.CMPDWR] = new Comparison.CMPDWR();
        handlers[Inst.CMPRR] = new Comparison.CMPRR();
        handlers[Inst.JER] = new Branching.JER();
        handlers[Inst.JEW] = new Branching.JEW();
        handlers[Inst.JEDW] = new Branching.JEDW();
        handlers[Inst.JLR] = new Branching.JLR();
        handlers[Inst.JLW] = new Branching.JLW();
        handlers[Inst.JLDW] = new Branching.JLDW();
        handlers[Inst.JGR] = new Branching.JGR();
        handlers[Inst.JGW] = new Branching.JGW();
        handlers[Inst.JGDW] = new Branching.JGDW();
        handlers[Inst.JLER] = new Branching.JLER();
        handlers[Inst.JLEW] = new Branching.JLEW();
        handlers[Inst.JLEDW] = new Branching.JLEDW();
        handlers[Inst.JGER] = new Branching.JGER();
        handlers[Inst.JGEW] = new Branching.JGEW();
        handlers[Inst.JGEDW] = new Branching.JGEDW();
        handlers[Inst.JMPA] = new Branching.JMPA();
        handlers[Inst.JMPW] = new Branching.JMPW();
        handlers[Inst.JMPDW] = new Branching.JMPDW();
        handlers[Inst.VR] = new Other.VR();
        handlers[Inst.VW] = new Other.VW();
        handlers[Inst.VDW] = new Other.VDW();
        handlers[Inst.Q] = new Other.Q();
        this.p = p;
    }
    public void run(int code) {
        this.handlers[code].exec(this.p);
    }
}
