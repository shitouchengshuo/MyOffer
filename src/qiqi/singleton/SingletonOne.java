package qiqi.singleton;

public class SingletonOne {

    private static final SingletonOne instance = new SingletonOne();

    private SingletonOne() {}

    public static SingletonOne getInstance(){
        return instance;
    }
}
