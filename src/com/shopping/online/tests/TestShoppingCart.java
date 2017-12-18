package com.shopping.online.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.shopping.online.cart.Cart;
import com.shopping.online.coupons.AbstractCoupon;
import com.shopping.online.coupons.CouponPercentOffAllItems;
import com.shopping.online.exceptions.ShoppingCartException;
import com.shopping.online.products.AbstractProduct;
import com.shopping.online.products.ProductJacket;

class TestShoppingCart {
	@Rule
	final ExpectedException expected = ExpectedException.none();

	@Test
	final void TestCase_FromEntrust() {

		Cart shoppingCart = Cart.initialize();

		// Add 3 T-Shirts worth $20 each | $20 x 3 = $60
		for (int count = 3; count > 0; count--)
			shoppingCart.addCartItem(ProductsAndCouponsDictionary.tshirtOldNavy);
		assertEquals(60, shoppingCart.getCartTotal());

		// Add a coupon to reduce 20% off the next item on cart | $60
		shoppingCart.addCartItem(ProductsAndCouponsDictionary.percentTwentyOffNextItem);
		assertEquals(60, shoppingCart.getCartTotal());

		// Add Two Jackets work $100 each. The previous coupon will be applied on the
		// first jacket | $60 + $100 - $20 + $100 = $240
		for (int count = 2; count > 0; count--)
			shoppingCart.addCartItem(ProductsAndCouponsDictionary.jacketRaynolds);
		assertEquals(240, shoppingCart.getCartTotal());

		// Add 10 bracelets worth $10 each | $240 + ($10 x 10) = $340
		for (int count = 10; count > 0; count--)
			shoppingCart.addCartItem(ProductsAndCouponsDictionary.braceletTitan);
		assertEquals(340, shoppingCart.getCartTotal());

		// Add 10% off all items present in cart | $340 - $34 = $306
		shoppingCart.addCartItem(ProductsAndCouponsDictionary.percentTenOffPreviousItems);
		assertEquals(306, shoppingCart.getCartTotal());

		// Add two "$75 off the 5th jacket" coupons | $306
		for (int count = 2; count > 0; count--)
			shoppingCart.addCartItem(ProductsAndCouponsDictionary.dollarsSeventyFiveOffOnFifthJacket);
		assertEquals(306, shoppingCart.getCartTotal());

		// Add two Jackets worth $100 each | $306 + ($100 x 2) = $506
		for (int count = 2; count > 0; count--)
			shoppingCart.addCartItem(ProductsAndCouponsDictionary.jacketRaynolds);
		assertEquals(506, shoppingCart.getCartTotal());

		// Add one more Jacket worth $100, two "$75 off the 5th Jacket" will trigger |
		// $506 + $100 - ($75 x 2) = $456
		shoppingCart.addCartItem(ProductsAndCouponsDictionary.jacketRaynolds);
		assertEquals(456, shoppingCart.getCartTotal());
	}

	@Test
	final void TestCase_CouponOnFutureItems() {

		Cart shoppingCart = Cart.initialize();

		// Add 3 T-Shirts worth $20 each | $20 x 3 = $60
		for (int count = 3; count > 0; count--)
			shoppingCart.addCartItem(ProductsAndCouponsDictionary.tshirtOldNavy);
		assertEquals(60, shoppingCart.getCartTotal());

		// Add 10% off all items in cart | $60 - $6 = $54
		shoppingCart.addCartItem(ProductsAndCouponsDictionary.percentTenOffAllItems);
		assertEquals(54, shoppingCart.getCartTotal());

		// Add 2 T-Shirts worth $20 each | $56 + $34 = $90
		for (int count = 2; count > 0; count--)
			shoppingCart.addCartItem(ProductsAndCouponsDictionary.tshirtOldNavy);
		assertEquals(90, shoppingCart.getCartTotal());

	}

	@Test
	final void TestCase_MultipleCouponsOnSameProduct() {

		Cart shoppingCart = Cart.initialize();

		// Add 4x Jackets worth $100 each
		for (int count = 4; count > 0; count--)
			shoppingCart.addCartItem(ProductsAndCouponsDictionary.jacketRaynolds);
		assertEquals(400, shoppingCart.getCartTotal());

		// Apply coupon 10% off second jacket | $400 - (2 x $10) = $380
		shoppingCart.addCartItem(ProductsAndCouponsDictionary.percentTenOffSecondJacket);
		assertEquals(380, shoppingCart.getCartTotal());

		// Apply coupon Buy 4 and get the 5th Jacket for free. Coupon does not kick in
		// yet | $380
		shoppingCart.addCartItem(ProductsAndCouponsDictionary.freeFifthJacket);
		assertEquals(380, shoppingCart.getCartTotal());

		// Add 1x Jacket. The coupon kicks in. Price does not increase | $380
		shoppingCart.addCartItem(ProductsAndCouponsDictionary.jacketRaynolds);
		assertEquals(380, shoppingCart.getCartTotal());

		// Add 1x Jacket. This is the 6th Jacket 10% off second jacket kicks in | $380 +
		// $90 = $470
		shoppingCart.addCartItem(ProductsAndCouponsDictionary.jacketRaynolds);
		assertEquals(470, shoppingCart.getCartTotal());

		// Add 1x Jacket. This is the 7th Jacket no coupon | $470 + $100 = $570
		shoppingCart.addCartItem(ProductsAndCouponsDictionary.jacketRaynolds);
		assertEquals(570, shoppingCart.getCartTotal());
	}

	@Test
	final void TestCase_CouponsBasedOnCartTotal() {

		Cart shoppingCart = Cart.initialize();

		// Add 1x Jacket worth $100 | $100
		shoppingCart.addCartItem(ProductsAndCouponsDictionary.jacketRaynolds);
		assertEquals(100, shoppingCart.getCartTotal());

		// Add 1x Jacket worth $100 | $100 + $100 = $200
		shoppingCart.addCartItem(ProductsAndCouponsDictionary.jacketRaynolds);
		assertEquals(200, shoppingCart.getCartTotal());

		// Apply coupon that allows one free T-Shirt when cart total exceeds $200 | $200
		shoppingCart.addCartItem(ProductsAndCouponsDictionary.freeTShirtIfCartTotalOverTwoHundred);
		assertEquals(200, shoppingCart.getCartTotal());

		// Add 1x Bracelet worth $10 | $200 + $10 = $210
		shoppingCart.addCartItem(ProductsAndCouponsDictionary.braceletTitan);
		assertEquals(210, shoppingCart.getCartTotal());

		// Add 1x T-shirt worth $20. The coupon kicks in, no change | $210
		shoppingCart.addCartItem(ProductsAndCouponsDictionary.tshirtOldNavy);
		assertEquals(210, shoppingCart.getCartTotal());

		// Add 1x T-shirt worth $20 | $210 + $20 = $230
		shoppingCart.addCartItem(ProductsAndCouponsDictionary.tshirtOldNavy);
		assertEquals(230, shoppingCart.getCartTotal());
	}

	@Test
	final void TestCase_EaseOfAdministration() {

		Cart shoppingCart = Cart.initialize();

		// Creating new products
		AbstractProduct jacket = ProductJacket.instance(450, "Armani Elite");

		// Creating coupons
		AbstractCoupon multiUseCoupon = CouponPercentOffAllItems.instance("30% off everything in the cart", 30, true);
		AbstractCoupon singleUseCoupon = CouponPercentOffAllItems.instance("80% off everything in the cart", 80, false);

		// Add 1x Jacket worth $450 | $450
		shoppingCart.addCartItem(jacket);
		assertEquals(450, shoppingCart.getCartTotal());

		// Apply 30% off cart coupon (allows multi-use) | $450 - 135 = $315
		shoppingCart.addCartItem(multiUseCoupon);
		assertEquals(315, shoppingCart.getCartTotal());


		// Apply 30% off cart coupon (allows multi-use) | $315 - 94.5 = $220.5
		shoppingCart.addCartItem(multiUseCoupon);
		assertEquals(220.5, shoppingCart.getCartTotal());

		// Apply 80% off cart coupon (does not allow multi-use)
		assertThrows(ShoppingCartException.class, () -> shoppingCart.addCartItem(singleUseCoupon));
		// multi-use and single-use coupons belong to the same type of coupons, they
		// cannot be used together because "multi-use" is set to false for single-use
		// coupon.
	}

}
