package com.github.vakhrymchuk.service;

import org.springframework.stereotype.Service;

@Service
public class BusRouteServiceImpl implements BusRouteService {
    @Override
    public boolean direct(final Integer depSid, final Integer arrSid) {
        return false;
    }
}
