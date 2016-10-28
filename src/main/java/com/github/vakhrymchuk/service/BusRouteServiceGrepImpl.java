package com.github.vakhrymchuk.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
@Profile("grep")
public class BusRouteServiceGrepImpl implements BusRouteService, CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(BusRouteServiceGrepImpl.class);
    private static final String GREP_COMMAND_PATTERN = "egrep -c \" %d (.* )?%d( |$)\" %s";

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

        final String command = String.format(GREP_COMMAND_PATTERN, depSid, arrSid, filename);

        return Integer.parseInt(runCommand(command)) > 0;
    }

    private String runCommand(final String command) {
        try {
            final Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", command});
            process.waitFor();
            return new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
        } catch (IOException | InterruptedException e) {
            LOG.error("Failed to run process");
            throw new RuntimeException();
        }
    }
}
