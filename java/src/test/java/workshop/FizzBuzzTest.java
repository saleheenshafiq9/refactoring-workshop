package workshop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    private final FizzBuzz fizzbuzz = new FizzBuzz();
    @Test
    public void returnsANumber() {
        assertEquals("", fizzbuzz.say(1));
        assertEquals("", fizzbuzz.say(4));
        assertEquals("", fizzbuzz.say(7));
    }

    @Test
    public void factorOf3() {
        assertEquals("Fizz", fizzbuzz.say(3));
        assertEquals("Fizz", fizzbuzz.say(6));
        assertEquals("Fizz", fizzbuzz.say(9));
    }

    @Test
    public void factorOf5() {
        assertEquals("Buzz", fizzbuzz.say(5));
        assertEquals("Buzz", fizzbuzz.say(10));
        assertEquals("Buzz", fizzbuzz.say(20));
    }

    @Test
    public void factorOf3And5() {
        assertEquals("FizzBuzz", fizzbuzz.say(15));
        assertEquals("FizzBuzz", fizzbuzz.say(30));
        assertEquals("FizzBuzz", fizzbuzz.say(60));
    }
}