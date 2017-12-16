package cart.shopping.generic.products;

import java.util.ArrayList;
import java.util.List;

import cart.shopping.generic.cart.AbstractCartItem;

public class ProductBracelet extends AbstractProduct {

	private ProductBracelet(float cost, String title) {
		super(cost, title);
	}
	
	public static AbstractCartItem initialize() {
		
		AbstractCartItem item = new ProductBracelet(10, "Zara Bracelets");
		return item;
	}
	
	public static List<AbstractCartItem> initialize(int number) {
		
		ArrayList<AbstractCartItem> items = new ArrayList<AbstractCartItem>();
		while(number-- > 0) items.add(initialize());
		return items;
	}

}
