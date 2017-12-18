package cart.shopping.generic;

import cart.shopping.generic.coupons.AbstractCoupon;
import cart.shopping.generic.coupons.CouponPercentOffNextItem;
import cart.shopping.generic.coupons.CouponPercentOffNthItemOfType;
import cart.shopping.generic.coupons.CouponDollarsOffNthItemOfType_Strict;
import cart.shopping.generic.coupons.CouponPercentOffAllItems;
import cart.shopping.generic.coupons.CouponPercentOffPreviousItems;
import cart.shopping.generic.products.AbstractProduct;
import cart.shopping.generic.products.ProductBracelet;
import cart.shopping.generic.products.ProductJacket;
import cart.shopping.generic.products.ProductTShirt;

public class EntrustTestProjectDictionary {

	public static AbstractProduct jacketRaynolds = ProductJacket.instance(100, "Raynolds Premium");
	public static AbstractProduct tshirtOldNavy = ProductTShirt.instance(20, "Old Navy Classic");
	public static AbstractProduct braceletTitan = ProductBracelet.instance(10, "Titan Studio Collection");
	public static AbstractCoupon percentTwentyOffNextItem = CouponPercentOffNextItem.instance("20% off next item", 20);
	public static AbstractCoupon percentTenOffPreviousItems = CouponPercentOffPreviousItems.instance("10% off previous items in cart", 10);
	public static AbstractCoupon percentTenOffAllItems = CouponPercentOffAllItems.instance("10% off all items in cart", 10, true);
	public static AbstractCoupon percentTenOffSecondJacket = CouponPercentOffNthItemOfType.instance("10% off every fifth Jacket", ProductJacket.class, 10, 2, true);
	public static AbstractCoupon freeFifthJacket = CouponPercentOffNthItemOfType.instance("Buy 4 jackets and get one free", ProductJacket.class, 100, 5, true);
	public static AbstractCoupon dollarsSeventyFiveOffOnFifthJacket = CouponDollarsOffNthItemOfType_Strict.instance("$75 Off on fifth Jacket", ProductJacket.class, 5, 75);
	
}
