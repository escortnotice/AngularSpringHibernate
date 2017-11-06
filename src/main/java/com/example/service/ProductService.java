package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customexceptionhandling.CustomDaoException;
import com.example.dao.ProductDao;
import com.example.model.Product;

@Service
public class ProductService {

	@Autowired 
	ProductDao productDao;
	
	@Transactional
	public String createProduct (Product product) throws CustomDaoException
	{
		return productDao.createProduct(product);
	}
}
