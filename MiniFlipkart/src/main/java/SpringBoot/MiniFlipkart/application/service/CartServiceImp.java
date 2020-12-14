
package SpringBoot.MiniFlipkart.application.service;

import java.util.ArrayList;
import java.util.List;

import SpringBoot.MiniFlipkart.application.rdos.CartItemsRdo;
import SpringBoot.MiniFlipkart.model.entity.*;
import SpringBoot.MiniFlipkart.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * @author Shubham Garg
 */
@Service
public class CartServiceImp implements CartService {
	
    // CartRepository Object
	@Autowired
	private CartRepository cartRepository;
	
	// ProductRepository Object
	@Autowired
	private ProductRepository productRepository;

	// OrderRepository Object
	@Autowired
	private OrderRepository orderRepository;

	// OrderRepository Object
	@Autowired
	private OrderItemsRepository orderItemsRepository;

	// UserRepository Object
	@Autowired
	private UserRepository userRepository;

	// CartItemsRepository Object
	@Autowired
	private CartItemsRepository cartItemsRepository;


	// return the number of intems in the cart
	@Override
	@Transactional
	public int getCartCount(int customerid) {
		// get cart
		Cart cart = cartRepository.findByCustomerId(customerid);
		// return the numberOfItems from the cart
		return cart.getNumberOfItems();
	}

	// add new product to cart
	@Override
	@Transactional
	public void addNewProduct(int productid, int customerid) {
		// get cart by customerid
		Cart cart = cartRepository.findByCustomerId(customerid);
		// get product
		Product product = productRepository.getOne(productid);

		// check if cart contains product
		CartItems ci = null;
		ci = cartItemsRepository.findByCartProductId(cart.getId(),product.getId());

		// cart already has product or new product is made
		if (ci != null) {
			// udate cart and cart item
			cart.setAmount(cart.getAmount() + product.getPrice());
			ci.setQuantity(ci.getQuantity() + 1);
			ci.setTotalPrice(ci.getTotalPrice() + product.getPrice());

			// save cart and cartitem
			cartRepository.save(cart);
			cartItemsRepository.save(ci);

		} else {
			// add to new CartItem
			ci = new CartItems(cart,product,product.getPrice(),1,product.getPrice());
			cartItemsRepository.save(ci);

			// update cart
			cart.setAmount(cart.getAmount() + product.getPrice());
			cart.setNumberOfItems(cart.getNumberOfItems() + 1);
			cartRepository.save(cart);
		}
	}


	// list of items in the cart
	@Override
	@Transactional
	public List<CartItemsRdo> getCartItems(int customerid) {
		// get cart
		Cart cart = cartRepository.findByCustomerId(customerid);
		// get cart items
		List<CartItems> cartitems =  cartItemsRepository.findByCartId(cart.getId());
		List<CartItemsRdo> cartitemsRdo = new ArrayList<CartItemsRdo>();
		for(CartItems ci : cartitems){
			CartItemsRdo cr = new CartItemsRdo();
			cr.setId(ci.getId());
			cr.setProductname(ci.getProduct().getName());
			cr.setUnitPrice(ci.getUnitPrice());
			cr.setQuantity(ci.getQuantity());
			cr.setTotalPrice(ci.getTotalPrice());
			cartitemsRdo.add(cr);
		}
		return cartitemsRdo;
	}

	// delete cartitem from the cart
	@Override
	@Transactional
	public void deleteItem(int id) {
		// get cart item
		CartItems ci = cartItemsRepository.getOne(id);
		// get cart
		Cart c = cartRepository.getOne(ci.getCart().getId());

		// update cart
		c.setNumberOfItems(c.getNumberOfItems() - 1);
		c.setAmount(c.getAmount() - ci.getTotalPrice());
		cartRepository.save(c);
		// delete cart item
		cartItemsRepository.delete(ci);
	}

	// decrease quantity of item in the cart
	@Override
	@Transactional
	public void deleteFromItem(int id) {
		// get cart item
		CartItems ci = cartItemsRepository.getOne(id);
		// get cart
		Cart c = cartRepository.getOne(ci.getCart().getId());

		// check if only one item is left or more is there
		if (ci.getQuantity() > 1) {
			// udate cart and cart item
			c.setAmount(c.getAmount() - ci.getUnitPrice());
			ci.setQuantity(ci.getQuantity() - 1);
			ci.setTotalPrice(ci.getTotalPrice() - ci.getUnitPrice());

			// save cart and cartitem
			cartRepository.save(c);
			cartItemsRepository.save(ci);

		} else {
			// update cart
			c.setNumberOfItems(c.getNumberOfItems() - 1);
			c.setAmount(c.getAmount() - ci.getTotalPrice());
			cartRepository.save(c);

			// delete cart item
			cartItemsRepository.delete(ci);
		}
	}

	// increase quantity of cart
	@Override
	@Transactional
	public void addToItem(int id) {
		// get cart item
		CartItems ci = cartItemsRepository.getOne(id);

		// get cart
		Cart c = cartRepository.getOne(ci.getCart().getId());

		// udate cart and cart item
		c.setAmount(c.getAmount() + ci.getUnitPrice());
		ci.setQuantity(ci.getQuantity() + 1);
		ci.setTotalPrice(ci.getTotalPrice() + ci.getUnitPrice());

		// save cart and cartitem
		cartRepository.save(c);
		cartItemsRepository.save(ci);
	}

	// perform checkout
	@Override
	@Transactional
	public void saveOrder(String ptype, int customerid) {
		// get cart
		Cart c = cartRepository.findByCustomerId(customerid);
		// get customer
		User customer = userRepository.getOne(customerid);

		Order order = new Order(customer, c.getAmount(), ptype);

		// save order
		orderRepository.save(order);

		// get list of cart items
		List<CartItems> cis = cartItemsRepository.findByCartId(c.getId());


		// delete cartitems and save orderitems
		for(int i = 0; i < cis.size(); i++) {
			CartItems ci = cis.get(i);
			c.setAmount(c.getAmount() - ci.getTotalPrice());
			c.setNumberOfItems(c.getNumberOfItems() - 1);
			OrderItems oi = new OrderItems(order,ci.getProduct(),ci.getQuantity(),ci.getUnitPrice(),ci.getTotalPrice());
			cartRepository.save(c);
			cartItemsRepository.delete(ci);
			orderItemsRepository.save(oi);
		}


	}


}
