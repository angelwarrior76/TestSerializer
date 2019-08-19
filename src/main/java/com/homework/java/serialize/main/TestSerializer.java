package com.homework.java.serialize.main;

import com.homework.java.serialize.model.Serializer;
import org.openjdk.jmh.runner.RunnerException;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

public class TestSerializer {

    public static void main(String[] args) {
        try {
            /*Collection<String> term = new ArrayList<>(0);
            term.add("1200");
            term.add("100");
            term.add("1");
            term.add("-4");
            term.add("5");*/
            int[] term = {1200, 100, 1, -4, 5};
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
