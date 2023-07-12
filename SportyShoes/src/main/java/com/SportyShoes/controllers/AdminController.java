package com.SportyShoes.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SportyShoes.model.Categories;
import com.SportyShoes.model.ProductDTO;
import com.SportyShoes.model.Products;
import com.SportyShoes.model.User;
import com.SportyShoes.model.UserDTO;
import com.SportyShoes.model.UserTransactions;
import com.SportyShoes.repository.CategoryRepo;
import com.SportyShoes.repository.ProductRepo;
import com.SportyShoes.repository.TransactionRepo;
import com.SportyShoes.repository.UserRepo;
import com.SportyShoes.service.CategoryService;


@RestController
public class AdminController {
	
	@Autowired
	TransactionRepo tranRepo;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	CategoryRepo adminCatRepo;
	
	@Autowired
	ProductRepo adminProdRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/adminGetAllCat")
	public  String getAllCat(Model model) {
		
	List<Categories> allCat = categoryService.getAllCategories();	
	return "categories";
	}
	
	@PostMapping("/adminAddCat")
	public ResponseEntity<Categories> createTutorial(@RequestBody Categories category) {
		try {
			Categories _category = adminCatRepo.save(new Categories(category.getCat_id(), category.getCat_name()));
			return new ResponseEntity<>(_category, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/adminDelCat/{id}")
	public ResponseEntity<HttpStatus> delcat(@PathVariable("id") int id) {
		try {
			
			adminCatRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// update admin password
	
	@PostMapping("/admin/updatepass")
	public ResponseEntity<String> updateAdminPass(@RequestBody String newPass)
	{
		try {
			
			
			User user = userRepo.findByEmail("admin@admin.com").get(0);
			
			user.setPassword(newPass);
			
			userRepo.deleteById(user.getUser_id());
			
			userRepo.save(user);
			
			return new ResponseEntity<>("Password Updated for Admin!",HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>("Unable to update password",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	// product routes start from here
	
	@GetMapping("/adminGetAllProd")
	public  String getAllProd() {

		return adminProdRepo.findAll().toString();
		
	}
	
//	make sure to make make a get request before post mapping to get all the available categories in the database
	
	@PostMapping("/adminAddProd")
	public ResponseEntity<Products> addProd(@RequestBody ProductDTO productDTO) {
		try {
			Products _product = new Products();
			_product.setProd_id(productDTO.getProd_id());
			_product.setProd_name(productDTO.getProd_name());
			_product.setPrice(productDTO.getPrice());
			_product.setCategory(adminCatRepo.findById(productDTO.getCat_id()).get());
			
			adminProdRepo.save(_product);
//			Products _product = adminProdRepo.save(new Products(product.getProd_id(),product.getProd_name(),product.getPrice(),product.getCategory()));
			return new ResponseEntity<>(_product, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/adminDelProd/{id}")
	public ResponseEntity<HttpStatus> delProd(@PathVariable("id") int id) {
		try {
			adminProdRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	//Browse the list of users who have signed up and be able to search users
	
	@GetMapping("/getUserById")
	public ResponseEntity<User> getUserById(@RequestParam(name = "id") int id)
	{
		try {
			
			User user = userRepo.findById(id).get();
			
			return new ResponseEntity<>(user, HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	// See purchase reports filtered by date and category
	
	@GetMapping("/getTransactionsByCat")
	public ResponseEntity<List<UserTransactions>> getTransactionsByCat(@RequestParam(name="cat") String category)
	{
		try {
			List<UserTransactions> ut = tranRepo.findAllByCategory(category);
			
			return new ResponseEntity<>(ut, HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getTransactionsByDate")
	public ResponseEntity<List<UserTransactions>> getTransactionsByDate(@RequestParam(name="date") String appointmentTime)
	{
		try {
			List<UserTransactions> ut = tranRepo.findAllByAppointmentTime(appointmentTime);
			
			return new ResponseEntity<>(ut, HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
}
