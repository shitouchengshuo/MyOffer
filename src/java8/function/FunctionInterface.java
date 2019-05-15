package java8.function;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 函数式接口
 * @author qiqi.zhao
 */
public class FunctionInterface {

    public static String processFile(BufferedReaderProcessor p) throws IOException {

        try(BufferedReader br =
                    new BufferedReader(new FileReader("data.txt"))) {
           return p.process(br);
        }
     }

     public void test()throws IOException{
         String oneLine = processFile((BufferedReader br) ->br.readLine());

     }
}
