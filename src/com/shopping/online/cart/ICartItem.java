package com.shopping.online.cart;

public interface ICartItem {

	public ICartItem getNextCartItem();

	public void setNextCartItem(ICartItem nextCartItem);

	public ICartItem getPreviousCartItem();

	public void setPreviousCartItem(ICartItem previousCartItem);

}
