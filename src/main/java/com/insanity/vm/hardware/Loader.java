package com.insanity.vm.hardware;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loader {
    public void loadArray(Processor p, int location, int arr[]) {
        int i = 0;
        for (int e : arr) {
            p.mem.write(i + location, e);
            i++;
        }
    }
    public void loadHexFile(Processor p, int location, String filename) {
        List<Integer> prog = new ArrayList<Integer>();
        File file = new File(filename);
        try {
            Scanner fscanner = new Scanner(file);
            while(fscanner.hasNext()){
                prog.add(Integer.parseInt(fscanner.next(), 16));
            }
            fscanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.loadArray(p, location, prog.stream().mapToInt(i->i).toArray());
    }
}
