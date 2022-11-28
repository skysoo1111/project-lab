package com.study.modeninaction.chapter6;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application6 {
    public static Application6 o = new Application6();

    public static void main(String[] args) {
        getInstance()._main(args);
    }

    public static Application6 getInstance() {
        return o;
    }

    public void _main(String[] args) {
        List<Transaction> transactions = Lists.newArrayList(
                new Transaction(new Trader("Park", "seoul"),2022, 100000, new Currency("dollar"))
                , new Transaction(new Trader("Kim", "busan"),2022, 5000, new Currency("won"))
                , new Transaction(new Trader("Lee", "daegu"),2022, 3000, new Currency("euro"))
                , new Transaction(new Trader("Hong", "kwangju"),2022, 15000, new Currency("dollar"))
                , new Transaction(new Trader("Yum", "jejudo"),2022, 20000, new Currency("won"))
        );

        test(transactions);

        legacyVersion(transactions);


        modernVersion(transactions);

    }

    public void test(List<Transaction> transactions) {
        List<Transaction> collect = transactions.stream().peek(t -> {
            if (t.getValue() < 4000)
//                t.setValue(t.getValue()/0);
                try {
                    t.setValue(t.getValue()/0);
                    throw new Exception("exception" + t.getTrader());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            else
                t.setValue(t.getValue() * 2);
        }).collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

    public void legacyVersion(List<Transaction> transactions) {

        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();

        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();

            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }

        transactionsByCurrencies.forEach((c,l) -> {
            System.out.println(c.getType());
            for (Transaction t : l) {
                System.out.println(t.getValue());
            }
        });
    }

    public void modernVersion(List<Transaction> transactions) {

    }



}
