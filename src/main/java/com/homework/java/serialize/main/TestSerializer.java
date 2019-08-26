package com.homework.java.serialize.main;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import java.util.concurrent.TimeUnit;

import com.homework.java.serialize.model.Serializer;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import org.openjdk.jmh.infra.Blackhole;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;

import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Warmup(iterations = 3)
@Measurement(iterations = 8)
public class TestSerializer {

    @Param({"100"})
    private int N;

    private List<String> DATA__FOR__TESTING;

    public static void main(String[] args) {
        try {
            Options opt = new OptionsBuilder()
                    .include(TestSerializer.class.getSimpleName())
                    .forks(1)
                    .build();

            new Runner(opt).run();

            /*Collection<String> term = new ArrayList<>(0);
            term.add("1200");
            term.add("100");
            term.add("1");
            term.add("-4");
            term.add("5");
            *//*Map<String, String> term = new HashMap<>(0);
            term.put("1","1200");
            term.put("2","100");
            term.put("3","1");
            term.put("4","-4");
            term.put("5","5");*//*
            //int[] term = {1200, 100, 1, -4, 5};
            //Integer[] term = {1200, 100, 1, -4, 5};
            //int term = 1200;
            //Integer term = Integer.valueOf(1200);
            //long term = 1200L;
            System.out.println(" object my: " + Serializer.bytes2objectv1(Serializer.object2bytesv1(term)));
            System.out.println(" object java: " + Serializer.bytes2object(Serializer.object2bytes(term)));
            System.out.println(" object json: " + Serializer.bytes2objectv2(Serializer.object2bytesv2(term)).toString());
            org.openjdk.jmh.Main.main(args);*/
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }

    @Setup
    public void setup() {
        DATA__FOR__TESTING = createData();
    }

    @Benchmark
    public void loopFor(Blackhole bh) {
        for (int i = 0; i < DATA__FOR__TESTING.size(); i++) {
            String s = DATA__FOR__TESTING.get(i);//take out n consume, fair with foreach
            bh.consume(s);
        }
    }

    @Benchmark
    public void loopWhile(Blackhole bh) {
        int i = 0;
        while (i < DATA__FOR__TESTING.size()) {
            String s = DATA__FOR__TESTING.get(i);
            bh.consume(s);
            i++;
        }
    }

    @Benchmark
    public void loopForEach(Blackhole bh) {
        for (String s : DATA__FOR__TESTING) {
            bh.consume(s);
        }
    }

    @Benchmark
    public void loopIterator(Blackhole bh) {
        Iterator<String> iterator = DATA__FOR__TESTING.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            bh.consume(s);
        }
    }

    private List<String> createData() {
        Collection<String> term = new ArrayList<>(0);
        term.add("1200");
        term.add("100");
        term.add("1");
        term.add("-4");
        term.add("5");
        List<String> data = new ArrayList<>(0);
        for (int i = 0; i < N; i++) {
            try {
                data.add("Number : " + i + ", Object: " + Serializer.bytes2object(Serializer.object2bytes(term)));
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

}
