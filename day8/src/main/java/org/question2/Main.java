package org.question2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args){



        List<List<String>> number = new ArrayList<>();
        number.add(Arrays.asList("ajay", "ashish"));
        number.add(Arrays.asList("karan", "kiran"));
        number.add(Arrays.asList("ajay", "nilesh"));
        number.add(Arrays.asList("karan", "subrata"));
        number.add(Arrays.asList("akash", "ajay"));
        number.add(Arrays.asList("vivek", "kiran"));
        number.add(Arrays.asList("aditya", "nilesh"));
        number.add(Arrays.asList("karan", "abhijeet"));
        number.add(Arrays.asList("nilesh", "amey"));
        number.add(Arrays.asList("rohit", "pravat"));
        number.add(Arrays.asList("gowrish", "aayush"));
        number.add(Arrays.asList("naman", "rishav"));
        number.add(Arrays.asList("Gowrish", "aayush"));

        List<String> ansList = number.stream()
                .flatMap(List::stream)
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());

        logger.info(ansList.toString());

        boolean allLengthGreater2 = ansList.stream().allMatch(s -> s.length() > 2);
        logger.info("All elements have length greater than 2: "+allLengthGreater2);

        boolean anyLengthGreater2 = ansList.stream().anyMatch(s -> s.length() > 2);
        logger.info("Any elements have length greater than 2: "+anyLengthGreater2);

        String startsWithK = ansList.stream().filter(s -> s.startsWith("k")).findFirst().orElse(null);
        logger.info(String.valueOf(startsWithK));

        String startsWithQ = ansList.stream().filter(s -> s.startsWith("Q")).reduce((first, second) -> second).orElse(null);
        logger.info(startsWithQ);

        Set<String> setOfStrings = new HashSet<>();
        setOfStrings.add("preeti");
        setOfStrings.add("vivek");
        setOfStrings.add("ajay");

        boolean hasOccurrence = ansList.stream().anyMatch(setOfStrings::contains);
        logger.info(String.valueOf(hasOccurrence));



    }
}
