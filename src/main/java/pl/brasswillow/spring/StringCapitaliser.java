package pl.brasswillow.spring;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

@Component
public class StringCapitaliser {

    public String capitalise(String aString){
        String[] words = aString.split(" +");
        Stream<String> stream = stream(words);
        Function<String, String> firstUp = s -> s.substring(0,1).toUpperCase() + s.substring(1);
        String collect = stream.map(firstUp).collect(Collectors.joining(" "));


        String tricky = Stream.concat(
            stream(words).limit(1),
            stream(words).
                skip(1).
                map(firstUp)).
            collect(Collectors.joining(" "));

        return tricky;
    }
}
