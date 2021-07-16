package com.company.northwind.business.concretes;

import com.company.northwind.business.abstracts.ProductService;
import com.company.northwind.core.utilities.results.DataResult;
import com.company.northwind.core.utilities.results.Result;
import com.company.northwind.core.utilities.results.SuccessDataResult;
import com.company.northwind.core.utilities.results.SuccessResult;
import com.company.northwind.dataaccess.abstracts.ProductDao;
import com.company.northwind.entities.concretes.Product;
import com.company.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductManager implements ProductService {
    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        super();
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.findAll(),"Data listed.");
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort=Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<List<Product>>
                (this.productDao.findAll(sort),"Success!");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo-1, pageSize);
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
    }

    @Override
    public Result add(Product product) {
       this.productDao.save(product);
       return new SuccessResult("Product added.");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>
                ( this.productDao.getByProductName(productName),"Data listed.");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<Product>
                ( this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listed.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.getByProductNameOrCategory_CategoryId
                        (productName,categoryId),"Data listed.");
    }


    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.getByProductNameContains(productName),"Data listed.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.getByProductNameStartsWith(productName),"Data listed.");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                ( this.productDao.getByNameAndCategory(productName,categoryId),"Data listed.");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>
                ( this.productDao.getProductWithCategoryDetails(),"Data listed.");
    }

}
