package java8.optional;

/**
 * 非Optional存在的问题
 * @author qiqi.zhao
 * @date 2019/5/14
 */
public class NoOptionalTest {

    public class Person{
        private Car car;
        public Car getCar() { return car; }
    }

    public class Car{
        private Insurance insurance;
        public Insurance getInsurance() { return insurance; }
    }
    /**
     * 保险类
     */
    public class Insurance{
        private String name;
        public String getName() { return name; }
    }


    /**
     * 空指针代码
     */
    public String getCarInsuranceName(Person person){
        return person.getCar().getInsurance().getName();
    }

    /**
     * 采用防御式检查减少 NullPointerException
     */
    public String getCarInsuranceName1(Person person){
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";
    }

    /**
     * null-安全的第二种尝试：过多的退出语句
     */
    public String getCarInsuranceName2(Person person) {
        if (person == null) {
            return "Unknown";
        }
        Car car = person.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }
        return insurance.getName();
    }
}
