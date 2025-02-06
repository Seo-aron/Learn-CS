import java.util.ArrayList;
import java.util.List;

interface PaymentStrategy {
    public void pay(int amount);
}

class KAKAOCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public KAKAOCardStrategy(String nm, String ccNum, String cvv, String expiryDate){
        this.name = nm;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }

    @Override
    public void pay(int amount){
        System.out.println(amount + " paid using KAKAOCard");
    }
}

class LUNACardStarategy implements PaymentStrategy{
    private String emailId;
    private String password;

    public LUNACardStarategy(String email, String pwd){
        this.emailId = email;
        this.password = pwd;
    }

    @Override
    public void pay(int amount){
        System.out.println(amount + " paid using LUNACard.");
    }
}

class Item {
    private String name;
    private int price;
    public Item(String name, int cost){
        this.name = name;
        this.price = cost;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }
}

class ShoppingCart {
    List<Item> items;

    public ShoppingCart(){
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public int calculateTotal(){
        int sum = 0;
        for (Item item : items){
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentMethod){
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}

public class Strategy {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item A = new Item("kundolA", 100);
        Item B = new Item("kundolB", 300);

        cart.addItem(A);
        cart.addItem(B);

        cart.pay(new LUNACardStarategy("kundol@example.com", "pukukubababo"));
        cart.pay(new KAKAOCardStrategy("Juhongchul", "123456789", "123", "12/01"));
    }
}

/*
    cart.pay(new LUNACardStarategy("kundol@example.com", "pukukubababo"));
    cart.pay(new KAKAOCardStrategy("Juhongchul", "123456789", "123", "12/01"));

    업캐스팅 : 부모타입이 자식타입을 참조한다.

    public void pay(PaymentStrategy paymentMethod){
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }

     = public void pay (PaymentStrategy LUNACardStrategy)
     Payment인터페이스가 LUNA객체를 참조해서
     LUNA가 Payment타입으로 받을 수 있고
     .pay(amount) 이런게 가능하다

 */