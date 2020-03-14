package DoanHieu.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import DoanHieu.model.NewModel;
import DoanHieu.service.INewService;
import DoanHieu.service.impl.NewService;
import utils.HttpUtil;
@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet {
	@Inject
	private INewService newService;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 	//mapper cos tac dung chuyen  string thanh json 
	ObjectMapper mapper = new ObjectMapper();
	req.setCharacterEncoding("UTF-8");// xet kiểu tiếng việt khi client
	resp.setContentType("application/json");

//	
	 NewModel newModel= HttpUtil.of(req.getReader()).toModel(NewModel.class); //ho tro convetr json sang newModel
//	//truyen vao newModel .save newModel vừa convert
	 	newModel = newService.save(newModel);
	
	 	//chuyen model(string ) thanh kieu  json
	 	mapper.writeValue(resp.getOutputStream(), newModel);
	 	//Sử lý bài toán requset gửi lên data json , và sau đó  mapsping qua model , trả ra client từ server trả cho client 
	 	

}
@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// update cap nhat 
	ObjectMapper mapper = new ObjectMapper();
	req.setCharacterEncoding("UTF-8");// xet kiểu tiếng việt khi client
	resp.setContentType("application/json");
	 NewModel updateNew = HttpUtil.of(req.getReader()).toModel(NewModel.class); //ho tro convetr json sang modele 
	 updateNew =newService.update(updateNew);
	 	mapper.writeValue(resp.getOutputStream(), updateNew);
	 
	}


@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	ObjectMapper mapper = new ObjectMapper();
	req.setCharacterEncoding("UTF-8");// xet kiểu tiếng việt khi client
	resp.setContentType("application/json");
	 NewModel newModel  = HttpUtil.of(req.getReader()).toModel(NewModel.class);
	 newService.delete(newModel.getIds());
	 mapper.writeValue(resp.getOutputStream(), "{}");// day ra data = null ko cos gif  ta dde  {}
	}


}
