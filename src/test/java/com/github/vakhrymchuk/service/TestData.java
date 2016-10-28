package com.github.vakhrymchuk.service;import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TestData {

    private static final int COUNT_ROUTES = 100_000;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws IOException {
        final FileWriter writer = new FileWriter("tests/docker/example");

        writer.write(String.valueOf(COUNT_ROUTES));
        writer.write('\n');
        for (int i = 0; i < COUNT_ROUTES; i++) {
            writer.write(String.valueOf(i));

            final int stations = 1_000;
            final Set<Integer> set = new HashSet<>();
            for (int j = 0; j < stations; j++) {
                int num;
                do {
                    num = RANDOM.nextInt(1_000_000);
                } while (!set.add(num));

                writer.append(' ')
                        .write(String.valueOf(num));
            }
            writer.write('\n');

        }

        writer.close();
    }
}
