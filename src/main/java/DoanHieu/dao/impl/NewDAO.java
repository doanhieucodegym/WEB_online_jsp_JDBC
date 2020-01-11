package DoanHieu.dao.impl;

import java.util.List;

import DoanHieu.dao.INewDAO;
import DoanHieu.mapper.NewMapper;
import DoanHieu.model.NewModel;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO{

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql ="select * from news where categoryid =?"; 
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		
			String sql ="insert into news(title, content ,categoryid) value(?, ?, ?)";
			return insert(sql, newModel.getTitle(), newModel.getContent(), newModel.getCategoryId());
		
		
		
	}

}
