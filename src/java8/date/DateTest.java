package java8.date;

import java8.entity.Apple;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * @author qiqi.zhao
 * @date 2019/4/28
 */
public class DateTest {

    @Test
    public void test1(){

        LocalDate date = LocalDate.of(2019, 4, 27);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        date.getDayOfWeek();
        System.out.println(date);

        LocalTime time = LocalTime.of(10, 29, 28);
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.of(2019, 1, 12, 12, 10);
        System.out.println(dateTime);
    }
}
