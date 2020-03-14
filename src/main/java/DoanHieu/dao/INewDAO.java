	 package DoanHieu.dao;

import java.util.List;

import DoanHieu.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel> {
	//su ly logic ,lay  danh sach  bai viettheo id cua the loai
	List<NewModel> findByCategoryId(Long categoryId);
	//lây 1 
	NewModel findOne(Long id);
	Long save(NewModel newModel);
	void update(NewModel updateNew);
	void delete(long id );
	

}
