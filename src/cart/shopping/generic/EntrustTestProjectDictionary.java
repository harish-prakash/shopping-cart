package cart.shopping.generic;

import cart.shopping.generic.coupons.AbstractCoupon;
import cart.shopping.generic.coupons.CouponPercentOffNextItem;
import cart.shopping.generic.coupons.CouponPercentOffPreviousItems;
import cart.shopping.generic.products.AbstractProduct;
import cart.shopping.generic.products.ProductJacket;

public class EntrustTestProjectDictionary {

	public static AbstractProduct jacketRaynolds = ProductJacket.instance(100, "Raynolds Premium");
	public static AbstractProduct tshirtOldNavy = ProductJacket.instance(20, "Old Navy Classic");
	public static AbstractProduct braceletTitan = ProductJacket.instance(10, "Titan Studio Collection");
	public static AbstractCoupon percentTwentyOffNextItem = CouponPercentOffNextItem.instance("20% off next item", 20);
	public static AbstractCoupon percentTenOffPreviousItems = CouponPercentOffPreviousItems.instance("10% off previous items in cart", 10);
	
}
