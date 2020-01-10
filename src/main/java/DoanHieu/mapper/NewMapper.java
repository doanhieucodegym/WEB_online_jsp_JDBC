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
		
		return news;
		}catch(SQLException e) {}
	
		return null ;
	}

}
