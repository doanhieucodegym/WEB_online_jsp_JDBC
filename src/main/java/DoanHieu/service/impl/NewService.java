package DoanHieu.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import DoanHieu.dao.INewDAO;
import DoanHieu.model.NewModel;
import DoanHieu.service.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDao;

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		//truyền ngày viết bài 
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		// truyền ai  là  người sửa vì chưa có use 
		newModel.setCreatedBy("");
			Long newId =newDao.save(newModel);
	    return newDao.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew  = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		//truyền ngày  sửa 
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		// truyền  người sửa 
		updateNew.setModifiedBy("");
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id:ids) {
			//1delete commnent(khoa ngoai new_id)
			//2:delete  news
			newDao.delete(id);
		}
		
	}



}
