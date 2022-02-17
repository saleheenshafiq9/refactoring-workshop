package workshop;

public class BuzzPatternMatcher implements PatternMatcher {

	@Override
	public boolean matches(int number) {
		return number % 3 == 0 || number % 5 == 0 || number % 15 == 0;
	}

	@Override
	public String generateRresponse(int number) {
		return number % 15 == 0 ? "FizzBuzz" : number % 3 == 0 ? "Fizz" : number % 5 == 0 ? "Buzz" : " ";
	}
}
