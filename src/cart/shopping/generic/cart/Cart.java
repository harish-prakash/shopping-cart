package cart.shopping.generic.cart;

import java.util.ArrayList;
import java.util.List;

import cart.shopping.generic.coupons.AbstractCoupon;
import cart.shopping.generic.products.AbstractProduct;

public class Cart {

	// region: Instance variables	
	private ICartItem firstItem;
	private ICartItem lastItem;

	private ArrayList<CartProductWrapper> cartProducts;
	private ArrayList<CartCouponWrapper> cartCoupons;
	
	// region: Class Initializers
	private Cart() {

		this.firstItem = null;
		this.lastItem = null;

		this.cartProducts = new ArrayList<CartProductWrapper>();
		this.cartCoupons = new ArrayList<CartCouponWrapper>();
	}

	public static Cart initialize() {
		Cart cart = new Cart();
		return cart;
	}

	// region: Getters and setters	
	public ICartItem getFirstItem() {
		return firstItem;
	}

	private void setFirstItem(ICartItem firstItem) {
		this.firstItem = firstItem;
	}

	private ICartItem getLastItem() {
		return lastItem;
	}

	private void setLastItem(ICartItem lastItem) {
		this.lastItem = lastItem;
	}

	public List<CartCouponWrapper> getCoupons() {
		return cartCoupons;
	}

	// region: Utility Methods
	private void addProduct(CartProductWrapper product) {
		this.cartProducts.add(product);
	}

	private void addCoupon(CartCouponWrapper coupon) {
		this.cartCoupons.add(coupon);
	}

	public List<CartProductWrapper> getProducts() {

		for (CartProductWrapper product : cartProducts) {
			product.resetDiscounts();
		}

		for (CartCouponWrapper coupon : getCoupons()) {
			coupon.validateAndApply(this);
		}

		return cartProducts;
	}
	
	public float getCartTotal() {

		float total = 0;

		for (CartProductWrapper product : getProducts()) {
			total += product.getReducedCost();
		}

		return total;
	}

	public void addCartItem(AbstractProduct product) {
		CartProductWrapper Product = CartProductWrapper.wrap(product);
		addProduct(Product);
		addCartItem(Product);
	}
	
	public void addCartItem(AbstractCoupon coupon) {
		
		CartCouponWrapper Coupon = CartCouponWrapper.wrap(coupon);
		addCoupon(Coupon);
		addCartItem(Coupon);
	}
	
	private void addCartItem (ICartItem cartItem) {
		
		if (getFirstItem() == null) {
			setFirstItem(cartItem);
			setLastItem(cartItem);
		}
		
		else {
			cartItem.setPreviousCartItem(getLastItem());
			getLastItem().setNextCartItem(cartItem);
			setLastItem(cartItem);
		}
	}
}
