package com.test.sample.Sample;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.relation.Role;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.sample.entity.Category;
import com.test.sample.entity.Stock;
import com.test.sample.entity.StockCategory;
import com.test.sample.repository.CategoryDao;
import com.test.sample.repository.StockDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleApplicationTests {

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private StockDao stockDao;

//	@Test
	public void sample() {
		Stock stock = new Stock("001", "food");

		Category category1 = new Category("CONSUMER", "CONSUMER COMPANY");
		categoryDao.save(category1);

		StockCategory stockCategory = new StockCategory();
		stockCategory.setStock(stock);
		stockCategory.setCategory(category1);
		stockCategory.setCreatedDate(new Date()); //extra column
		stockCategory.setCreatedBy("system"); //extra column

		stock.getStockCategories().add(stockCategory);
		
		stockDao.save(stock);
		
		addCategory();
		
	}
	
	public void addCategory(){
		Category category4 = new Category("PRODUCER", "producer COMPANY");
		//new category, need save to get the id first
		categoryDao.save(category4);
		Category category2 = new Category("supplier", "supplier COMPANY");
		//new category, need save to get the id first
		categoryDao.save(category2);
		Category category3 = new Category("warehouse", "warehouse COMPANY");
		//new category, need save to get the id first
		categoryDao.save(category3);
	}
	
//	@Test
	public void addStock(){
		 Stock stock = new Stock("002","drink");
		 
		 Stock stock1 = new Stock("003", "snack");

		 Category category1 = categoryDao.findOne(1);
		 Category category2 = categoryDao.findOne(2);
		 
		 StockCategory stockCategory = new StockCategory();
		 stockCategory.setStock(stock);
		 stockCategory.setCategory(category1);
		 stockCategory.setCreatedDate(new Date()); //extra column
		 stockCategory.setCreatedBy("system"); //extra column
		 
		 stock.getStockCategories().add(stockCategory);
		 stockDao.save(stock);
		 
		 StockCategory stockCategory1 = new StockCategory();
		 stockCategory1.setStock(stock1);
		 stockCategory1.setCategory(category1);
		 stockCategory1.setCreatedDate(new Date()); //extra column
		 stockCategory1.setCreatedBy("system"); //extra column
		 
		 StockCategory stockCategory2 = new StockCategory();
		 stockCategory2.setStock(stock1);
		 stockCategory2.setCategory(category2);
		 stockCategory2.setCreatedDate(new Date()); //extra column
		 stockCategory2.setCreatedBy("system"); //extra column
		 
		 Set<StockCategory> stockCategories = new HashSet<>();
		 stockCategories.add(stockCategory1);
		 stockCategories.add(stockCategory2);
		 stock1.setStockCategories(stockCategories);
//		 stock1.getStockCategories().add(stockCategory1);
//		 stock1.getStockCategories().add(stockCategory2);
		 stockDao.save(stock1);

	}
	
	@Test //gagal
	public void deleteStockCategory(){
		Stock stock3 = stockDao.findOne(3);
		Category category1 = categoryDao.findOne(1);
		
		StockCategory stockCategory1 = new StockCategory();
		stockCategory1.setStock(stock3);
		stockCategory1.setCategory(category1);
		stockCategory1.setCreatedDate(new Date()); //extra column
		stockCategory1.setCreatedBy("system"); //extra column
		
		stock3.removeStock(stockCategory1);
		stockDao.save(stock3);
	}
	
	///saat menjalankan test update jadi error
//	@Test //gagal
	public void updatesample(){
		Category category2 = categoryDao.findOne(2);
		Category category3 = categoryDao.findOne(3);
		Category category1 = categoryDao.findOne(1);
		Assert.assertNotNull(category2);
		Assert.assertNotNull(category3);
		
		Stock stock = stockDao.findOne(2);
		Assert.assertNotNull(stock);
		
		StockCategory stockCategory1 = new StockCategory();
		stockCategory1.setStock(stock);
		stockCategory1.setCategory(category1);
		stockCategory1.setCreatedDate(new Date()); //extra column
		stockCategory1.setCreatedBy("system"); //extra column
		
		StockCategory stockCategory2 = new StockCategory();
		stockCategory2.setStock(stock);
		stockCategory2.setCategory(category2);
		stockCategory2.setCreatedDate(new Date()); //extra column
		stockCategory2.setCreatedBy("system"); //extra column
		
		StockCategory stockCategory3 = new StockCategory();
		stockCategory3.setStock(stock);
		stockCategory3.setCategory(category3);
		stockCategory3.setCreatedDate(new Date()); //extra column
		stockCategory3.setCreatedBy("system"); //extra column
		
		Set<StockCategory> stockCategories = new HashSet<StockCategory>();
//		stockCategories.add(stockCategory1);
		stockCategories.add(stockCategory2);
		stockCategories.add(stockCategory3);
		
		stock.setStockCategories(stockCategories);
		
		stockDao.save(stock);
	}

}
