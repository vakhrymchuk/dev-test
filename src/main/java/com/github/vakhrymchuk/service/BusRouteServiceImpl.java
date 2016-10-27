package com.github.vakhrymchuk.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;

@Service
public class BusRouteServiceImpl implements BusRouteService, CommandLineRunner {

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
        Paths.get(filename);
        return true;
    }
}
