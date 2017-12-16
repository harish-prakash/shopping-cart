package cart.shopping.generic.products;

import java.util.ArrayList;
import java.util.List;

import cart.shopping.generic.cart.AbstractCartItem;

public class ProductTShirt extends AbstractProduct {

	private ProductTShirt(float cost, String title) {
		super(cost, title);
	}
	
	public static AbstractCartItem initialize() {
		AbstractCartItem tshirt = new ProductTShirt(20, "Giovanni Polo");
		return tshirt;
	}
	
	public static List<AbstractCartItem> initialize(int number) {
		
		ArrayList<AbstractCartItem> tshirts = new ArrayList<AbstractCartItem>();
		while(number-- > 0) tshirts.add(initialize());
		return tshirts;
	}

}
