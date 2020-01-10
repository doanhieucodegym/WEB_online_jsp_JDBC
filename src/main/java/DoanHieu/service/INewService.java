package DoanHieu.service;

import java.util.List;

import DoanHieu.model.NewModel;

public interface INewService {
		List<NewModel> findByCategoryId(Long categoryId);
}
