package cart.shopping.generic.products;

import java.util.ArrayList;
import java.util.List;

import cart.shopping.generic.cart.AbstractCartItem;

public class ProductJacket extends AbstractProduct {

	private ProductJacket(float cost, String title) {
		super(cost, title);
	}

	public static AbstractCartItem initialize() {
		AbstractCartItem jacket = new ProductJacket(100, "Old Navy Classic");
		return jacket;
	}
	
	public static List<AbstractCartItem> initialize(int number) {
		
		ArrayList<AbstractCartItem> jackets = new ArrayList<AbstractCartItem>();
		while (number-- > 0) jackets.add(initialize());
		return jackets;
	}
}
