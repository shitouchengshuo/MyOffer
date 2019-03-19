package java8;

import com.google.common.collect.Lists;
import java8.entity.Apple;
import java8.entity.User;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.comparing;

/**
 * void sort(Comparator<? super E> c);
 */
public class SortTest {

    //被排序的集合
    public List<User> userList = Lists.newArrayList(new User("Jack",11),new User("Jack",10));

    //sort方法签名
    //void sort(Comparator<? super E> c);

    //@Test
    public void test1(){
        //1.Java8之前，使用匿名内部类的基本排序
        Collections.sort(userList,new Comparator<User>(){
            public int compare(User user1, User user2) {
                return user1.getName().compareTo(user2.getName());
            }
        });

        //2.Java8,Lambda表达式
        userList.sort((User user1, User user2)->user1.getName().compareTo(user2.getName()));

        //3.Java8,Lambda表达式可以简化，省略定义类型User
        userList.sort((user1,user2)->user1.getName().compareTo(user2.getName()));

        //4.Java8,提取Comparator进行排序
        Comparator<User> c = Comparator.comparing((User u) ->u.getName());
        Collections.sort(userList,comparing((u)->u.getName()));

        //5.Java8,使用方法引用
        Collections.sort(userList,comparing(User::getName));

        //6.Java8,Lambda表达式，多条件排序
        userList.sort((user1,user2)->{
            if(user1.getName().equals(user2.getName())){
                return user1.getAge()-user2.getAge();
            }else{
                return user1.getName().compareTo(user2.getName());
            }
        });

        //7.Java8,多条件组合排序
        userList.sort(Comparator.comparing(User::getName).thenComparing(User::getAge));




        //8.Java8,反转排序
        Comparator<User> comparator = (user1,user2)->user1.getName().compareTo(user2.getName());
        userList.sort(comparator);//先按name排序
        userList.sort(comparator.reversed());//反转排序

        /**
         *Arrays.sort()使用
         */
        //被排序的字符串数组
        String[]months={"January","February","March","April","May","June","July","August","September","October","December"};
        //按字符串长度排序
        //1.
        Arrays.sort(months,(a, b)->Integer.signum(a.length()-b.length()));
        //2.
        Arrays.sort(months,Comparator.comparingInt(String::length));
        //3.
        Arrays.sort(months,(a,b)->a.length()-b.length());
        //4.
        Arrays.sort(months,(String a,String b)->{
            return Integer.signum(a.length()-b.length());}
        );

        System.out.println(Arrays.toString(months));
    }

}
