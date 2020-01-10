package DoanHieu.dao.impl;

import java.util.List;

import DoanHieu.dao.ICategoryDAO;
import DoanHieu.mapper.CategoryMapper;
import DoanHieu.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> finAll() {
		String sql ="select * from category";
		return query(sql, new CategoryMapper());
		
	}
	

}
