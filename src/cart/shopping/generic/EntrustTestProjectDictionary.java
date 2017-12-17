package cart.shopping.generic;

import cart.shopping.generic.coupons.AbstractCoupon;
import cart.shopping.generic.coupons.CouponPercentOffNextItem;
import cart.shopping.generic.products.AbstractProduct;
import cart.shopping.generic.products.ProductJacket;

public class EntrustTestProjectDictionary {

	public static AbstractProduct jacketRaynolds = ProductJacket.instance(100, "Raynolds Premium");
	public static AbstractCoupon percentOffNextItem = CouponPercentOffNextItem.instance("20% off next item", 20); 	
	
}
