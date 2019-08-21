package com.homework.java.serialize.main;

import com.homework.java.serialize.model.Serializer;

import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

public class TestSerializer {

    public static void main(String[] args) {
        try {

            /*Collection<String> term = new ArrayList<>(0);
            term.add("1200");
            term.add("100");
            term.add("1");
            term.add("-4");
            term.add("5");*/
            Map<String, String> term = new HashMap<>(0);
            term.put("1","1200");
            term.put("2","100");
            term.put("3","1");
            term.put("4","-4");
            term.put("5","5");
            //int[] term = {1200, 100, 1, -4, 5};
            //Integer[] term = {1200, 100, 1, -4, 5};
            //int term = 1200;
            //Integer term = Integer.valueOf(1200);
            //long term = 1200L;
            System.out.println(" object v1: " + Serializer.object2bytesv1(term));
            System.out.println(" object v2: " + Serializer.bytes2objectv2(Serializer.object2bytesv2(term)).toString());
            org.openjdk.jmh.Main.main(args);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (RunnerException e) {
            e.printStackTrace();
        }

    }

}
