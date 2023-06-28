package com.SportyShoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SportyShoes.model.Categories;

@Repository
public interface CategoryRepo extends JpaRepository<Categories, Integer> {
	
}
