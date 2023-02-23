package visitors_log.service;

import java.util.List;

import visitors_log.dao.VisitorInfoDAOImpl;
import visitors_log.entity.VisitorInfo;

public class VisitorInfoServiceImpl implements VisitorInfoService {

	@Override
	public List<VisitorInfo> findAll() {
		
		VisitorInfoDAOImpl visitorinfoDAOImpl = new VisitorInfoDAOImpl();
		List <VisitorInfo> visitorinfoList = visitorinfoDAOImpl.findAll();
		return visitorinfoList;
	}

	@Override
	public void save(VisitorInfo visitorinfo) {

		VisitorInfoDAOImpl visitorinfoDAOImpl = new VisitorInfoDAOImpl();
		int row = visitorinfoDAOImpl.save( visitorinfo );
		if (row == 1)
			System.out.println("*******INSERTED SUCCESSFULLY*********");
		else
			System.out.println("*******INSERTION FAILED*********");

	}

	@Override
	public void update(VisitorInfo visitorinfo) {
		
		VisitorInfoDAOImpl visitorinfoDAOImpl = new VisitorInfoDAOImpl();
		int row = visitorinfoDAOImpl.update( visitorinfo );
		if (row == 1)
			System.out.println("*******UPDATED SUCCESSFULLY*********");
		else
			System.out.println("*******UPDATED FAILED*********");
		
	}

	@Override
	public void delete(VisitorInfo visitorinfo) {

		VisitorInfoDAOImpl visitorinfoDAOImpl = new VisitorInfoDAOImpl();
		int row = visitorinfoDAOImpl.delete( visitorinfo );
		if (row != 0)
			System.out.println("*******DELETED SUCCESSFULLY*********");
		else
			System.out.println("*******DELETED FAILED*********");
	}

	@Override
	public VisitorInfo findById(int visitorId) {
		
		VisitorInfoDAOImpl visitorinfoDAOImpl = new VisitorInfoDAOImpl();
		VisitorInfo row = visitorinfoDAOImpl.findById(visitorId);
		return row;
	}

}
