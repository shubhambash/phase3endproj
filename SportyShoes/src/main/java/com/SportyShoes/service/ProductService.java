package com.SportyShoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SportyShoes.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo prodRepo;
	
	public void deleteAllProductsByCategoryId(int cat_id)
	{
		
	}
	
}
