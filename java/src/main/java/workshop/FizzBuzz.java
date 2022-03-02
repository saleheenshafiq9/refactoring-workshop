package workshop;

import java.util.List;

/**
 * Requirements:
 * For factor of three print Fizz instead of the number
 * For factor of five print Buzz instead of the number
 * For numbers which are factors of both three and five print FizzBuzz instead
 * of the number
 */
public class FizzBuzz {
	private List<PatternMatcher> patternMatchers;
	private PatternMatcher nullObjectPattern;

	public FizzBuzz(List<PatternMatcher> patternMatchers, PatternMatcher nullObjectPattern) {
		super();
		this.patternMatchers = patternMatchers;
		this.nullObjectPattern = nullObjectPattern;
	}

	public FizzBuzz() {
	}

	public String say(int number) {
		String strReturn = nullObjectPattern.generateRresponse(number);

		for (PatternMatcher patternMatcher : patternMatchers) {
			if (patternMatcher.matches(number))
				strReturn = patternMatcher.generateRresponse(number);
		}

		if (strReturn.equals(""))
			return String.valueOf(number);
		else
			return strReturn;
	}
}
