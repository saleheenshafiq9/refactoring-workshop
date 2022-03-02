package workshop;

public class FizzbuzzPatternMatcher implements PatternMatcher {
    @Override
    public boolean matches(int number) {
        return number % 5 == 0 && number % 3 == 0;
    }

    @Override
    public String generateResponse() {
        return "FizzBuzz";
    }
}
