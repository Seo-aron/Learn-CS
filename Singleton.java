class SingletonClass {
    private static class singleInstanceHolder {
        private static final SingletonClass INSTANCE = new SingletonClass();
    }
    public static SingletonClass getInstance(){
        return singleInstanceHolder.INSTANCE;
    }
}

public class Singleton {
    public static void main(String[] args) {
        SingletonClass a = SingletonClass.getInstance();
        SingletonClass b = SingletonClass.getInstance();
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        if(a == b){
            System.out.println(true);
        }
    }
}

/*
    싱글톤 패턴의 단점
    TDD(Test Driven Development)를 할 때 걸림돌이 됨.
    TDD를 할 때 단위 테스트를 주로 하는데, 단위 테스트는 서로 독립적이어야 하며
    테스트를 어떤 순서로든 실행할 수 있어야함
    하지만 싱글톤 패턴은 미리 생성된 하나의 인스턴스를 기반으로 구현하는 패턴이므로
    각 테스트마다 '독립적인' 인스턴스를 만들기가 어렵다.
 */