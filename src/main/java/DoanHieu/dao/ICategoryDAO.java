package DoanHieu.dao;

import java.util.List;

import DoanHieu.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	
	List<CategoryModel> finAll();

}
