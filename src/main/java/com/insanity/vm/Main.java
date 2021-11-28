package com.insanity.vm;
import com.insanity.vm.hardware.Processor;
import com.insanity.vm.hardware.Memory;
import com.insanity.vm.hardware.Loader;
public class Main {
    public static void main(String[] args){
        Loader loader = new Loader();
        Memory mem = new Memory(0xFFFF);
        Processor proc = new Processor(mem);
        loader.loadHexFile(proc, 0x0000, "programs/test.ihex");
        proc.run(0x0000);
    }
}