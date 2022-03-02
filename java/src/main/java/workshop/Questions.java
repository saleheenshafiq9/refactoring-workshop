package workshop;

import java.util.*;

public class questions {
    private final Map<quesCategory, List<String>> quesCategoryListMap = new HashMap<>();

    public questions() {
        for (quesCategory quesCategory : quesCategory.values()) {
            quesCategoryListMap.put(quesCategory, new ArrayList<>());
        }

        for (int i = 0; i < 50; i++) {
            quesCategoryListMap.get(quesCategory.POP).add("Pop Question " + i);
            quesCategoryListMap.get(quesCategory.SCIENCE).add("Science Question " + i);
            quesCategoryListMap.get(quesCategory.SPORTS).add("Sports Question " + i);
            quesCategoryListMap.get(quesCategory.ROCK).add("Rock Question " + i);
        }
    }

    public String extractNextQuestion(int index) {
        quesCategory quesCategory = currentCategory(index);
        return quesCategoryListMap.get(quesCategory).remove(0);
    }

    public quesCategory currentCategory(int index) {
        return quesCategory.values()[index % quesCategory.values().length];
    }
}
