package java8.entity;

import lombok.Data;


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
}
