package com.shopping.online.tests;

import com.shopping.online.coupons.AbstractCoupon;
import com.shopping.online.coupons.CouponDollarsOffNthItemOfType_Strict;
import com.shopping.online.coupons.CouponPercentOffAllItems;
import com.shopping.online.coupons.CouponPercentOffNextItem;
import com.shopping.online.coupons.CouponPercentOffNthItemOfType;
import com.shopping.online.coupons.CouponPercentOffPreviousItems;
import com.shopping.online.products.AbstractProduct;
import com.shopping.online.products.ProductBracelet;
import com.shopping.online.products.ProductJacket;
import com.shopping.online.products.ProductTShirt;

public class ProductsAndCouponsDictionary {

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
