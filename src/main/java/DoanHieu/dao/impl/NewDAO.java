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
		

			StringBuilder sql = new StringBuilder("insert into news (title, content,");
			sql.append("thumbnail,shortdescription,categoryid,createddate,createdby)");
			sql.append("value(? ,? ,?, ?, ?, ? ,?)");
			return insert(sql.toString(),
					newModel.getTitle(),
					newModel.getContent(),
					newModel.getThumbnail(),
					newModel.getShortDescription(),
					newModel.getCategoryId(),
					newModel.getCreatedDate(),
					newModel.getCreatedBy());
			
	}

	@Override
	public NewModel findOne(Long id) {
		//tra ve siggor lay 1 gia tri  	 	
		String sql ="Select * from news Where id = ?";
		List<NewModel> news = query(sql,new NewMapper(),id);
		
		return news.isEmpty() ? null : news.get(0);
	}
	@Override
	public void update(NewModel updateNew) {	
	
		StringBuilder sql = new StringBuilder("UPDATE  news set title=?, thumbnail=?,");
		sql.append("shortdescription =? ,content =? , categoryid = ? ,");
		sql.append("createddate = ? ,createdby =?,modifieddate =? , modifiedby =? where id = ?");
	
		update(sql.toString(),updateNew.getTitle(),
				updateNew.getThumbnail(),
				updateNew.getShortDescription(),
				updateNew.getContent(),
				updateNew.getCategoryId(),
				updateNew.getCreatedDate(),
				updateNew.getCreatedBy(),
				updateNew.getModifiedDate(),
				updateNew.getModifiedBy(),
				updateNew.getId());	
	}

	@Override
	public void delete(long id) {
		String sql =" delete from news where id = ? ";
		update(sql,id);
		
	}


}
