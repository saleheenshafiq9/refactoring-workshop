package workshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Requirements:
 * For factor of three print Fizz instead of the number
 * For factor of five print Buzz instead of the number
 * For numbers which are factors of both three and five print FizzBuzz instead of the number
 */

public class FizzBuzz {
    private final List<PatternMatcher> patternMatchers =
            new ArrayList<>
                    (Arrays.asList(new FizzPatternMatcher(), new BuzzPatternMatcher(), new FizzbuzzPatternMatcher()));
    private final ResponseGenerator nullObjectPattern= () -> "";

    public FizzBuzz(){
        super();
    }

    public  String say(int number) {
        String strReturn = nullObjectPattern.generateResponse();
        for (PatternMatcher patternMatcher : patternMatchers) {
            if (patternMatcher.matches(number)) strReturn = patternMatcher.generateResponse();
        }
        return strReturn;
    }
}

