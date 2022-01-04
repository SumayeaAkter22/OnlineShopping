package com.exam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	CategoryAccess ca = new CategoryAccess();
	ProductAccess pa = new ProductAccess();

	@RequestMapping("/")
	public String show( Model m) {
		System.out.println("shown");
		ProductAccess pa = new ProductAccess();
		// m.addAttribute("cartList", pa.doShow());
		m.addAttribute("products", pa.doShow());
		return "index";
	}

	@RequestMapping("/login")
	public String admin() {
		GlobalData.cart.clear();
		return "login";
	}
	@RequestMapping("/customerloginpage")
	public String customer() {
		GlobalData.cart.clear();
		return "customerLogin";
	}


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminlogin(@ModelAttribute() Login log, Model model) {

		String userid = log.getEmail();
		String email = log.getPassword();

		LoginAccess da = new LoginAccess();
		Login u = da.findUser(log);

		if (userid == (u.email) && email.equals(u.password)) {
			// if adminId and password is correct, we are returning home page
			model.addAttribute("Login", u);


			return "adminHome";
		} else {
			// if adminId and password is wrong return again login page
			model.addAttribute("invalidCredentials", "error");

			return "adminHome";
		}

	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerInsert(@ModelAttribute("user") User user, Model m) {
		UserDataAccess usa = new UserDataAccess();
		usa.doInsert(user);
		m.addAttribute("register", user);
		return "customerLogin";
	}
	
	@RequestMapping(value="/customerlogin", method = RequestMethod.POST)
	public String userlogin(@ModelAttribute("user") User user, Model model) {

		String email = user.getEmail();
		String password = user.getPassword();

		UserDataAccess da = new UserDataAccess();
		User u = da.findUser(user);
		

		if (u!=null) {

		model.addAttribute("register", u);
			ca = new CategoryAccess();
			pa = new ProductAccess();
			model.addAttribute("categories", ca.doShow());
			model.addAttribute("products", pa.doShow());
			model.addAttribute("errmsg", "");
			//model.addAttribute("cartCount", GlobalData.cart.size());

			return "shop";
		} else {
//			// if adminId and password is wrong return again login page
			model.addAttribute("errmsg", "Invalid username or password");

			return "customerLogin";
		}
		
	}

	@RequestMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("categories", ca.doShow());
		model.addAttribute("products", pa.doShow());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "shop";
	}

	@RequestMapping("/chooklate/{category}")
	public String shopByCategory(Model model, @PathVariable String category) {
		model.addAttribute("categories", ca.doShow());
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("products", pa.productByCategory(category));
		return "shop";
	}

	@RequestMapping("/productview/{id}")
	public String viewProduct(Model model, @PathVariable int id) {
		Product p = pa.productId(id);
		model.addAttribute("products", p);
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "viewProduct";
	}

}
