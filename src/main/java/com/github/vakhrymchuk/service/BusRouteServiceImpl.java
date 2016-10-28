package com.github.vakhrymchuk.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class BusRouteServiceImpl implements BusRouteService, CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(BusRouteServiceImpl.class);

    @Value("${bus.route.challenge.example.file}")
    private String filename;

    @Override
    public void run(final String... args) throws Exception {
        if (args.length > 0) {
            filename = args[0];
        }
    }

    @Override
    public boolean direct(final Integer depSid, final Integer arrSid) {
        LOG.debug("direct depSid: [{}], arrSid: [{}]", depSid, arrSid);
        final String dep = " " + depSid + " ";
        final String arr = " " + arrSid + " ";

        return readStream().skip(1).anyMatch(line -> checkLine(line, dep, arr));
    }

    private Stream<String> readStream() {
        try {
            return Files.lines(Paths.get(filename));
        } catch (IOException e) {
            LOG.error("Failed to open file", e);
            throw new RuntimeException("Failed to open file", e);
        }
    }

    private boolean checkLine(final String line, final String dep, final String arr) {
        final int depIndex = line.indexOf(dep);
        return depIndex > -1 && (line + ' ').indexOf(arr, depIndex) > -1;
    }
}
