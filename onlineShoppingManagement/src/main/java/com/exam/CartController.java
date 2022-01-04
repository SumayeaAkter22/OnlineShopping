package com.exam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {
	ProductAccess pa = new ProductAccess();
	CategoryAccess ca = new CategoryAccess();

	@RequestMapping("/addToCart/{id}")
	public String addToCart(@PathVariable int id, Model model) {
		GlobalData.cart.add(pa.productId(id));
		model.addAttribute("categories", ca.doShow());
		model.addAttribute("products", pa.doShow());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "shop";
	}

	@RequestMapping("/cart")
	public String getCart(Model model) {
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("cart", GlobalData.cart);
		return "cart";
	}

	@RequestMapping("/cart/removeItem/{index}")
	public String cartItemRemove(Model model, @PathVariable int index) {
		GlobalData.cart.remove(index);
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("cart", GlobalData.cart);
		return "cart";
	}

	@RequestMapping("/checkout")
	public String checkout(Model model) {
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		return "checkout";
	}

	@RequestMapping("/payNow")
	public String billl(@ModelAttribute() Billing bill, Model model) {
	BillingAccess ba = new BillingAccess();
		ba.doInsert(bill);
	model.addAttribute("total", 100);
		return "checkout";
	}
	
//	@RequestMapping("/receive")
//	public String received(Model model) {
//		BillingAccess ba = new BillingAccess();
//		model.addAttribute("result", ba.doShow());
//		return "orderPlaced";
//	}

}
