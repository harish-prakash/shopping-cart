package cart.shopping.generic.products;

import java.util.ArrayList;
import java.util.List;

import cart.shopping.generic.cart.AbstractCartItem;

public class ProductJeans extends AbstractProduct {

	private ProductJeans(float cost, String title) {
		super(cost, title);
	}
	
	public static AbstractCartItem initialize() {
		AbstractCartItem jeans = new ProductJeans(25, "Levi's Signature");
		return jeans;
	}
	
	public static List<AbstractCartItem> initialize(int number) {
		ArrayList<AbstractCartItem> jeans = new ArrayList<AbstractCartItem>();
		while (number-- > 0)jeans.add(initialize());
		return jeans;
	}

}
