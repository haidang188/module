package com.haidang.currency.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyService {
    @Override
    public double convertUSDtoVND(double rate, double usd) {
        return rate * usd;
    }
}
