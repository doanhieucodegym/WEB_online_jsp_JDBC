package DoanHieu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import DoanHieu.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel mapRow(ResultSet resultSet) {
		
		try {
			NewModel news =new NewModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortDescription(resultSet.getString("shortdescription"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			news.setCreatedDate(resultSet.getTimestamp("createdDate"));
			news.setCreatedBy(resultSet.getString("createdBy"));
			if(resultSet.getTimestamp("modifieddate") !=null) {
				news.setModifiedDate(resultSet.getTimestamp("modifieddate"));
				
			}
			if(resultSet.getString("modifiedby") !=null) {
				news.setModifiedBy(resultSet.getString("modifiedby"));
				
			}
		
		return news;
		}catch(SQLException e) {}
	
		return null ;
	}

}
 