package DoanHieu.service.impl;

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
			Long newId =newDao.save(newModel);
			System.out.println(newId);
		return null;
	}


}
