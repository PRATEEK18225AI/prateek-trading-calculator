package com.iontrading.tradingcalculator;
import static org.junit.Assert.assertEquals;
import  java.lang.Math;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Unit test for simple App.
 */
public class TradingCalculatorTest 
{
    /**
     * Rigorous Test :-)
     */
    @Mock
    private TradeTime tradeTime;
    private TradingCalculator tradingCalculator;
    private long multiplyThreshold=(long)Math.pow(10,9)+7;

    public TradingCalculatorTest(){
        MockitoAnnotations.initMocks(this);
        tradingCalculator = new TradingCalculator(tradeTime);
    }

    // Day Time
    @Test
    public void test_add_answerGreaterOrEqualZeroDay() throws NightTimeException{
        //Given
        Mockito.when(tradeTime.findTime()).thenReturn("Day");
        int a=10;
        int b=15;
        int ans=25;
        //when
        int res= tradingCalculator.add(a,b);
        //Then
        assertEquals(ans, res);
    }
    @Test
    public void test_add_answerLessThanZeroDay() throws NightTimeException{
        //Given
        Mockito.when(tradeTime.findTime()).thenReturn("Day");
        int a=11;
        int b=-12;
        int ans=0;
        //when
        int res= tradingCalculator.add(a,b);
        //Then
        assertEquals(ans, res);
    }

    @Test
    public void test_mul_answerLessThanThresholdDay() throws NightTimeException {
        //Given
        Mockito.when(tradeTime.findTime()).thenReturn("Day");
        int a=10;
        int b=20;
        long ans= 200;
        //when
        long res= tradingCalculator.mul(a, b);
        System.out.println(10^9+7);
        //Then
        assertEquals(ans, res);
    }

    @Test
    public void test_mul_answerGreaterThanThresholdDay() throws NightTimeException {
        //Given
        Mockito.when(tradeTime.findTime()).thenReturn("Day");
        int a=(int)Math.pow(10, 5);
        int b=(int)Math.pow(10, 5);
        long ans= multiplyThreshold;
        //when
        long res= tradingCalculator.mul(a, b);
        //Then
        assertEquals(ans, res);
    }

    // Night Time
    @Test(expected= NightTimeException.class)
    public void test_add_answerGreaterOrEqualZeroNight() throws NightTimeException{
        //Given
        Mockito.when(tradeTime.findTime()).thenReturn("Night");
        int a=10;
        int b=15;
        int ans=25;
        //when
        int res= tradingCalculator.add(a,b);
        //Then
        assertEquals(ans, res);
    }
    @Test(expected= NightTimeException.class)
    public void test_add_answerLessThanZeroNight() throws NightTimeException{
        //Given
        Mockito.when(tradeTime.findTime()).thenReturn("Night");
        int a=11;
        int b=-12;
        int ans=0;
        //when
        int res= tradingCalculator.add(a,b);
    }

    @Test(expected= NightTimeException.class)
    public void test_mul_answerLessThanThresholdNight() throws NightTimeException {
        //Given
        Mockito.when(tradeTime.findTime()).thenReturn("Night");
        int a=10;
        int b=20;
        long ans= 200;
        //when
        long res= tradingCalculator.mul(a, b);
        //Then
        assertEquals(ans, res);
    }

    @Test(expected= NightTimeException.class)
    public void test_mul_answerGreaterThanThresholdNight() throws NightTimeException {
        //Given
        Mockito.when(tradeTime.findTime()).thenReturn("Night");
        int a=10^5;
        int b=10^5;
        long ans= multiplyThreshold;
        //when
        long res= tradingCalculator.mul(a, b);
        //Then
        assertEquals(ans, res);
    }

}
