package com.exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AdminHomeController {

	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";
	CategoryAccess ca = new CategoryAccess();

	@RequestMapping("/adminHome")
	public String m1() {
		return "adminHome";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "adminHome";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "index";
	}

	@RequestMapping("/admin/categories")
	public String cat(Model model) {
		model.addAttribute("categories", ca.doShow());
		return "categories";
	}

	@RequestMapping("/admin/categories/add")
	public String getcatAdd(@ModelAttribute("categories") Category category, Model model) {
		model.addAttribute("category", category);
		return "categoriesAdd";
	}

	@RequestMapping(value = "/admin/categories/add", method = RequestMethod.POST)
	public String insertcatAdd(@ModelAttribute("category") Category category, Model m) {
		CategoryAccess ca = new CategoryAccess();
		ca.doInsert(category);
		m.addAttribute("categories", ca.doShow());
		return "categories";
	}

	@RequestMapping("/admin/categories/delete/{id}")
	public String deletecat(@ModelAttribute("category") Category category, Model model) {
		CategoryAccess ca = new CategoryAccess();
		ca.doDelete(category);
		model.addAttribute("categories", ca.doShow());
		return "categories";
	}

	@RequestMapping("/admin/products")
	public String products(Model model) {
		ProductAccess pa = new ProductAccess();
		model.addAttribute("products", pa.doShow());
		return "products";
	}
	
	@RequestMapping("/lowQuantity")
	public String lowQuatity(Model model) {
		ProductAccess pa = new ProductAccess();
		model.addAttribute("products", pa.doShowLowQuantity());
		System.out.println("lowQuatity");
		return "LowQuantity";
	}
	
	@RequestMapping("/highQuantity")
	public String highQuatity(Model model) {
		ProductAccess pa = new ProductAccess();
		model.addAttribute("products", pa.doShowHighQuantity());
		System.out.println("highQuatity");
		return "LowQuantity";
	}


	@RequestMapping("admin/products/add")
	public String productsAdd(@ModelAttribute("products") Product product, Model model) {
		List<Category> categorylist = ca.doShow();
		model.addAttribute("product", product);
		model.addAttribute("categorylist", categorylist);

		return "productsAdd";
	}

	@RequestMapping(value = "/admin/products/add", method = RequestMethod.POST)
	public String insertProductAdd(@ModelAttribute("product") Product product, Model m,
			@RequestParam("productImage") MultipartFile file, @RequestParam("imgName") String imgName)
			throws IOException {
		ProductAccess pa = new ProductAccess();

		String imageUUID;
		if (!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			Path fileNameAnePath = Paths.get(uploadDir, imageUUID);
			Files.write(fileNameAnePath, file.getBytes());
		} else {
			imageUUID = imgName;
		}
		
		product.setImageName("/productImages/"+imageUUID);
		pa.doInsert(product);
		m.addAttribute("products", pa.doShow());
		System.out.println(pa.doShow().get(0).toString());
		
		return "products";
	}

	@RequestMapping("/admin/product/delete/{id}")
	public String deleteProduct(@ModelAttribute("product") Product product, Model model) {
		ProductAccess pa = new ProductAccess();
		pa.doDelete(product);
		model.addAttribute("products", pa.doShow());
		return "products";
	}
	



}
