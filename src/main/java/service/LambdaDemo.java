package service;


import iface.AgeChecker;
import model.Human;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;


public class LambdaDemo {
    public static final Function<String, Integer> stringLength = s -> s == null? null : s.length();
    
    
    public static final Function<String, Character> firstChar = s -> (s == null || s.length() == 0)? null : s.charAt(0);
    
    
    public static final Predicate<String> noSpaces = s -> s == null || !s.contains(" ");
    
    
    public static final Function<String, Integer> countCommaSeparatedWords = s -> s == null? null : s.split(",").length + 1;
    
    
    public static final Function<Human, Integer> getAge = human -> human == null? null : human.getAge();
    
    
    public static final BiPredicate<Human, Human> sameSecondName = (human1, human2) -> human1 != null && human2 != null &&
            human1.getSecondName().equals(human2.getSecondName());
    
    
    public static final Function<Human, String> joinNames = human -> human == null? null :
            String.format("%s %s%s", human.getSecondName(), human.getFirstName(),
                    human.getPatronymicName() == null? "" : " " + human.getPatronymicName());
    
    
    public static final UnaryOperator<Human> makeOlder = human -> human == null? null :
            new Human(
                    human.getFirstName(),
                    human.getPatronymicName(),
                    human.getSecondName(),
                    human.getAge() + 1,
                    human.getSex()
            );
    
    
    public static final AgeChecker checkYoungerThan = (maxAge, human1, human2, human3) ->
            human1.getAge() < maxAge && human2.getAge() < maxAge && human3.getAge() < maxAge;
}
