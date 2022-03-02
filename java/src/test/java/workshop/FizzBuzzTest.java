package workshop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    workshop.FizzBuzz fbuzz = new workshop.FizzBuzz();

    @Test
    public void returnsANumber() {
        assertEquals("1", fbuzz.say(1));
        assertEquals("4", fbuzz.say(4));
        assertEquals("7", fbuzz.say(7));
    }

    @Test
    public void factorOf3() {
        assertEquals("Fizz", fbuzz.say(3));
        assertEquals("Fizz", fbuzz.say(6));
        assertEquals("Fizz", fbuzz.say(9));
    }

    @Test
    public void factorOf5() {
        assertEquals("Buzz", fbuzz.say(5));
        assertEquals("Buzz", fbuzz.say(10));
        assertEquals("Buzz", fbuzz.say(20));
    }

    @Test
    public void factorOf3And5() {
        assertEquals("FizzBuzz", fbuzz.say(15));
        assertEquals("FizzBuzz", fbuzz.say(30));
        assertEquals("FizzBuzz", fbuzz.say(60));
    }
}