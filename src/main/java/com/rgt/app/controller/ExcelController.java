package com.rgt.app.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.rgt.app.excel.ExcelFileGenerator;
import com.rgt.app.models.Product;
import com.rgt.app.repository.ProductReposiory;
@Controller
public class ExcelController {
	
	@Autowired
	ProductReposiory productReposiory;

	@GetMapping("/downloadExcelFile/product.xlsx")
	public ResponseEntity<InputStreamResource> excelProductReport()throws IOException {
		List<Product> list=(List<Product>)productReposiory.findAll();
		ByteArrayInputStream inputStream=ExcelFileGenerator.ProductToExcel(list);
		
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.add("content-Disposition", "attachment; filname=Product.xlsx");
		return ResponseEntity 
				.ok()
				.headers(httpHeaders)
				.body(new InputStreamResource(inputStream));		
	}
}
