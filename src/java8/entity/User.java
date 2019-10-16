package java8.entity;

import com.google.common.base.Objects;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class User {

    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareByAgeThenName(){
        return 1;
    }

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(null);
        System.out.println(userList.size());
    }

}
