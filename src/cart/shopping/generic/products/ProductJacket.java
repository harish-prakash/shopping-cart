package cart.shopping.generic.products;

public class ProductJacket extends AbstractProduct {

	// region: Class Initializers
	private ProductJacket(float cost, String title) {
		super(cost, title);
	}
	
	public static AbstractProduct instance(float cost, String title) {
		
		ProductJacket product = new ProductJacket(cost, title);
		return product;
	}

}
