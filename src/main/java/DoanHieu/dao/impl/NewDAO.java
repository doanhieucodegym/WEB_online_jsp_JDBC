package DoanHieu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		ResultSet resultSet =null;
		Connection connection = null;
		PreparedStatement statement = null;
		Long id = null;
		try {
			String sql ="insert into news(title, content ,categoryid) value(?, ?, ?)";
			 connection =getConnection();
			 connection.setAutoCommit(false); 
			statement =connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			statement.setString(1,newModel.getTitle());
			statement.setString(2,newModel.getContent()); 
			statement.setLong(3,newModel.getCategoryId());
			statement.executeUpdate();
			//lay  id ve vi id  tu dong  tang nen  dung  ham do  
			resultSet = statement.getGeneratedKeys();
			if(resultSet.next()) {
				id= resultSet.getLong(1);
			}
			connection.commit();
		return id;
			
		}catch(SQLException e) {
			if(connection !=null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return null;
		}finally {
			try {	if(connection !=null) {
				connection.close();
			}
			if(statement !=null) {
				statement.close();
			}
			if(resultSet !=null) {
				resultSet.close();
			}}catch(SQLException e) {}
		
		}
		
	}

}
