package DoanHieu.service.impl;

import java.util.List;

import javax.inject.Inject;

import DoanHieu.dao.ICategoryDAO;
import DoanHieu.dao.impl.CategoryDAO;
import DoanHieu.model.CategoryModel;
import DoanHieu.service.ICategoryService;

public class CategoryService implements ICategoryService{

//	private ICategoryDAO categoryDao;
//	public CategoryService() {
//		categoryDao = new CategoryDAO();
//	}
	//cach goi cũ
	@Inject
	private ICategoryDAO categoryDao;
	
	@Override
	public List<CategoryModel> finAll() {
		// TODO Auto-generated method stub
		return categoryDao.finAll();
	}

}
