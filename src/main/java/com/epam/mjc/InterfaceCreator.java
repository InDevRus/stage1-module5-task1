package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class InterfaceCreator {
    private static final Pattern THREE_WORDS_PATTERN = Pattern.compile("([A-Z][a-zA-Z]+) ((?:[a-zA-Z]+ ){2,})([a-zA-Z]+)\\.");

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for (var line : list) {
                if (!Character.isUpperCase(line.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            var addition = new ArrayList<Integer>();
            for (var number : list) {
                if (number % 2 == 0) {
                    addition.add(number);
                }
            }
            list.addAll(addition);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            var result = new ArrayList<String>();
            for (var line : values) {
                if (THREE_WORDS_PATTERN.matcher(line).matches()) {
                    result.add(line);
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            var map = new HashMap<String, Integer>();
            for (var line : list) {
                map.put(line, line.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            var list3 = new ArrayList<Integer>();
            list3.addAll(list1);
            list3.addAll(list2);
            return list3;
        };
    }
}
