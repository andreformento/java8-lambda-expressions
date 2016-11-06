package com.formento.java8.lambda.expressions.service;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProcessorService {

    public <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

}
