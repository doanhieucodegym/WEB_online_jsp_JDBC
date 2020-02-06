package DoanHieu.dao;

import java.util.List;

import DoanHieu.mapper.RowMapper;

public interface GenericDAO<T> {
	//nos se co nhieu  tham so nhung chua can dung  ngay, ta co the dung de truyen  nhieu  tham so  moi vao ,co  luong tham so  khong co dinh 
		<T>List<T> query(String sql, RowMapper<T> rowMapper ,Object ... paramenters);
		//cap nhat và xoa 
		void update(String sql ,Object ... parameters );
		//them moi
		Long insert (String sql, Object... parameters);
		
}
