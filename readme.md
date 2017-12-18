# Design Objectives
- The shopping cart should allow consumers to add products and coupons to their cart.
- Coupon types will change in the future.

# Design Decisions
- **Cart Ledger** Stores products and coupons preserving the sequence of addition
- **Inversion of Control (IoC)** Evolving nature of coupons can benefit from IoC. Coupons operate on the ledger instead of the ledger operating on Coupons.
- **Separation of Concerns (SoC)** Isolate code areas to simplify design and testing
- **Abstraction and Fascade pattern**

# Case study
Research different types of coupons, interview (pro) shoppers and find a list of coupon types.

## Coupons included in this version
- Buy two get one free
- %off all items
- %off next item
- %off Nth item of type
- %off when cart total exceeds
- Free item when cart total exceeds

## Other Coupon types
These are other coupon types which can be effortlessly implemented in the current version of shopping cart.
- Beat the clock sale
- %off most expensive item
- %off when type total exceeds value

# Next Iteration
The current version applies coupons on products. There may be situations where a coupon is applied on the entire cart or on product groups. Although, this result is achivable in the current version, the solution will be inefficient. Ideally, create ecapsulations called 'Product Group' and implement an interface called 'IDiscountable'. Implement the interface on the 'Cart' and 'Porduct Group'. This opens the door to more degrees of flexibility, e.g. Buy 3 for $6 (my personal favorite at Walmart).