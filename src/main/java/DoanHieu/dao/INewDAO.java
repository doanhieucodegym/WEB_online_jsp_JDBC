	 package DoanHieu.dao;

import java.util.List;

import DoanHieu.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel> {
	//su ly logic ,lay  danh sach  bai viettheo id cua the loai
	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel newModel);
	void update(NewModel newModel);

	

}
