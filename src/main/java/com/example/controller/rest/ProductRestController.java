package com.example.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.customexceptionhandling.CustomBaseException;
import com.example.model.Product;
import com.example.service.ProductService;

@RestController
public class ProductRestController {
	
	@Autowired
	ProductService productService;
	
	
	
	@RequestMapping (value="/Product", method=RequestMethod.POST)
	@ResponseStatus (value=HttpStatus.OK)
	@ResponseBody
	public String createProduct(@RequestBody Product product) throws CustomBaseException
	{
		return productService.createProduct(product);
	}

}
