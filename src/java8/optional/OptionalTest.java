package java8.optional;

import java.util.Optional;

/**
 * 使用Optional<>避免频繁的空指针检查
 * @author qiqi.zhao
 * @date 2019/5/14
 */
public class OptionalTest {

    public class Person{
        private Optional<Car> car;
        public Optional<Car> getCar() { return car; }
    }

    public class Car{
        private Optional<Insurance> insurance;
        public Optional<Insurance> getInsurance() { return insurance; }
    }
    /**
     * 保险类
     */
    public class Insurance{
        private String name;
        public String getName() { return name; }
    }

    /**
     * 非常简洁的使用
     * @param person
     * @return
     */
    public String getCarInsuranceName(Optional<Person> person){
        return person.flatMap(Person::getCar)
                     .flatMap(Car::getInsurance)
                     .map(Insurance::getName)
                .orElse("Unknown");
    }
}
