package cart.shopping.generic.cart;

import java.util.ArrayList;
import java.util.List;

import cart.shopping.generic.coupons.AbstractCoupon;
import cart.shopping.generic.products.AbstractProduct;

public class Cart {

	private AbstractCartItem firstItem;
	private AbstractCartItem lastItem;

	private ArrayList<AbstractProduct> cartProducts;
	private ArrayList<AbstractCoupon> cartCoupons;

	private Cart() {

		this.firstItem = null;
		this.lastItem = null;

		this.cartProducts = new ArrayList<AbstractProduct>();
		this.cartCoupons = new ArrayList<AbstractCoupon>();
	}

	public AbstractCartItem getFirstItem() {
		return firstItem;
	}

	private void setFirstItem(AbstractCartItem firstItem) {
		this.firstItem = firstItem;
	}

	private AbstractCartItem getLastItem() {
		return lastItem;
	}

	private void setLastItem(AbstractCartItem lastItem) {
		this.lastItem = lastItem;
	}

	public void addCartItems(AbstractCartItem item) {

		if (item == null)
			return;

		if (getFirstItem() == null) {
			setFirstItem(item);
			setLastItem(item);
		}

		else {
			getLastItem().setNextCartItem(item);
			item.setPreviousCartItem(getLastItem());
			setLastItem(item);
		}

		if (item instanceof AbstractProduct)
			addProduct((AbstractProduct) item);
		else
			addCoupon((AbstractCoupon) item);
	}

	public void addCartItems(List<AbstractCartItem> items) {
		for (AbstractCartItem item : items)
			addCartItems(item);
	}

	private void addProduct(AbstractProduct product) {
		this.cartProducts.add(product);
	}

	private void addCoupon(AbstractCoupon coupon) {
		this.cartCoupons.add(coupon);
	}

	public List<AbstractProduct> getProducts() {

		for (AbstractProduct product : cartProducts) {
			product.resetReducedCostAndCoupons();
		}

		for (AbstractCoupon coupon : getCoupons()) {
			coupon.validateAndApplyCoupon(getFirstItem(), cartProducts, getCoupons());
		}

		return cartProducts;
	}

	public List<AbstractCoupon> getCoupons() {
		return cartCoupons;
	}

	public float getCartTotal() {

		float total = 0;

		for (AbstractProduct product : getProducts()) {
			total += product.getReducedCost();
		}

		return total;
	}

	public static Cart initialize() {
		Cart cart = new Cart();
		return cart;
	}

}
