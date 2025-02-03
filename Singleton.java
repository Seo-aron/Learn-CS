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