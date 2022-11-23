package itsa.patterns.sol;

/* "Product" */
class Pizza2 {
    private String dough = "";
    private String sauce = "";
    private String topping = "";

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getDough() {
        return dough;
    }
	
    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getSauce() {
        return sauce;
    }
    public void setTopping(String topping) {
        this.topping = topping;
    }
	
	public String getTopping() {
        return topping;
    }

}

/* "Abstract Builder" */
abstract class PizzaBuilder2 {
    protected Pizza2 pizza;

    public String getPizza() {
        return pizza.getDough()+pizza.getSauce()+pizza.getTopping();
    }

    public void createNewPizzaProduct() {
        pizza = new Pizza2();
    }

    public abstract PizzaBuilder2 buildDough();
    public abstract PizzaBuilder2 buildSauce();
    public abstract PizzaBuilder2 buildTopping();
}

/* "ConcreteBuilder" */
class HawaiianPizzaBuilder2 extends PizzaBuilder2 {
    public PizzaBuilder2 buildDough() {
        pizza.setDough("cross");
        return this;
    }

    public PizzaBuilder2 buildSauce() {
        pizza.setSauce("mild");
        return this;
    }

    public PizzaBuilder2 buildTopping() {
        pizza.setTopping("pineapple");
        return this;
    }
}

/* "ConcreteBuilder" */
class SpicyPizzaBuilder2 extends PizzaBuilder2 {
    public PizzaBuilder2 buildDough() {
        pizza.setDough("baked");
        return this;
    }

    public PizzaBuilder2 buildSauce() {
        pizza.setSauce("hot");
        return this;
    }

    public PizzaBuilder2 buildTopping() {
        pizza.setTopping("pepperoni");
        return this;
    }
}

/* "Director" */
class Waiter2 {
    private PizzaBuilder2 pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder2 pb) {
        pizzaBuilder = pb;
    }

    public String getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void constructPizza() {
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildDough().buildSauce().buildTopping();
    }
}

/* A customer ordering a pizza. */
public class BuildPizza2 {
    public static void main(String[] args) {
        Waiter2 waiter = new Waiter2();
        PizzaBuilder2 hawaiianPizzabuilder = new HawaiianPizzaBuilder2();
        PizzaBuilder2 spicyPizzaBuilder = new SpicyPizzaBuilder2();

        waiter.setPizzaBuilder( hawaiianPizzabuilder );
        waiter.constructPizza();
        String pizza = waiter.getPizza();
		System.out.println(pizza);
		assert pizza.equals("crossmildpineapple") : "Pizza is not right";
		
		waiter.setPizzaBuilder( spicyPizzaBuilder );
        waiter.constructPizza();
        pizza = waiter.getPizza();
		System.out.println(pizza);
		assert pizza.equals("bakedhotpepperoni") : "Pizza is not right";

    }
}