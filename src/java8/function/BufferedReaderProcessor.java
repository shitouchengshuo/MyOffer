package java8.function;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *  函数式接口
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
