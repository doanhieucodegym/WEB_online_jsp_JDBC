package DoanHieu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DoanHieu.dao.GenericDAO;
import DoanHieu.mapper.RowMapper;


public class AbstractDAO<T> implements GenericDAO<T> {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/ontapdatabase";
			String user="root";
			String password = "hieuthuy12";
			return DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		
		}
		return null;

}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... paramenters) {
		List<T> results =new ArrayList<>();
		Connection connection  = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection =getConnection();
			statement =connection.prepareStatement(sql);
			// su  ly ham  set parameter()
			setParameter(statement,paramenters);
			resultSet =statement.executeQuery();
			while(resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}		
			return results;
		}
		catch(SQLException e)
		{
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

	private void setParameter(PreparedStatement statement, Object... paramenters) {
		try {
			for(int i=0;i<paramenters.length;i++) {
				Object paramenter = paramenters[i];
				int index =i+1;
				if(paramenter instanceof Long) {
					statement.setLong(index,(Long) paramenter);
				} else if(paramenter instanceof String ) {
					statement.setString(index,(String) paramenter);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
