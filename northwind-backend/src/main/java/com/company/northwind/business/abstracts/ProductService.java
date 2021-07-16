package com.company.northwind.business.abstracts;

import com.company.northwind.core.utilities.results.DataResult;
import com.company.northwind.core.utilities.results.Result;
import com.company.northwind.entities.concretes.Product;
import com.company.northwind.entities.dtos.ProductWithCategoryDto;

import java.util.List;

public interface ProductService {
   DataResult<List<Product>> getAll();

   DataResult<List<Product>> getAllSorted();

   DataResult<List<Product>> getAll(int pageNo,int pageSize);

   Result add(Product product);

   DataResult<Product>  getByProductName(String productName);

   DataResult<Product> getByProductNameAndCategory(String productName,int categoryId);

   DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);

   DataResult<List<Product>> getByProductNameContains(String productName);

   DataResult<List<Product>> getByProductNameStartsWith(String productName);

   DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);

   DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();



}
