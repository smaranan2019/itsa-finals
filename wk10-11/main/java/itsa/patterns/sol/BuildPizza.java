package itsa.patterns.sol;

/* "Product" */
class Pizza {
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
abstract class PizzaBuilder {
    protected Pizza pizza;

    public String getPizza() {
        return pizza.getDough()+pizza.getSauce()+pizza.getTopping();
    }

    public void createNewPizzaProduct() {
        pizza = new Pizza();
    }

    public abstract void buildDough();
    public abstract void buildSauce();
    public abstract void buildTopping();
}

/* "ConcreteBuilder" */
class HawaiianPizzaBuilder extends PizzaBuilder {
    public void buildDough() {
        pizza.setDough("cross");
    }

    public void buildSauce() {
        pizza.setSauce("mild");
    }

    public void buildTopping() {
        pizza.setTopping("pineapple");
    }
}

/* "ConcreteBuilder" */
class SpicyPizzaBuilder extends PizzaBuilder {
    public void buildDough() {
        pizza.setDough("baked");
    }

    public void buildSauce() {
        pizza.setSauce("hot");
    }

    public void buildTopping() {
        pizza.setTopping("pepperoni");
    }
}

/* "Director" */
class Waiter {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pb) {
        pizzaBuilder = pb;
    }

    public String getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void constructPizza() {
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }
}

/* A customer ordering a pizza. */
public class BuildPizza {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiianPizzabuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

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