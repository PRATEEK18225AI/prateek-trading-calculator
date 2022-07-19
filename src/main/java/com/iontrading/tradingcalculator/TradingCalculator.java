package com.iontrading.tradingcalculator;

import  java.lang.Math;

/**
 * Hello world!
 *
 */
public class TradingCalculator 
{
    private TradeTime tradeTime;
    public TradingCalculator(TradeTime tradeTime){
        this.tradeTime=tradeTime;
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public int add(int a, int b) throws NightTimeException {
        if(tradeTime.findTime()=="Night"){
            throw new NightTimeException();
        }
        return a+b>=0?a+b:0;
    }

    public long mul(int a,int b) throws NightTimeException {
        if(tradeTime.findTime()=="Night"){
            throw new NightTimeException();
        }
        long multiplyThreshold=(long)Math.pow(10,9)+7;

        return (a*b>=multiplyThreshold)?multiplyThreshold:a*b;
    }
}
