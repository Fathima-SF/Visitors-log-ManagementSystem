package visitors_log.service;

import java.util.List;

import visitors_log.dao.VisitingDetailsDAOImpl;
import visitors_log.entity.VisitingDetails;

public class VisitingDetailsServiceImpl implements VisitingDetailsService {

	@Override
	public List<VisitingDetails> findAll() {
		
		VisitingDetailsDAOImpl  visitingdetailsDAOImpl = new  VisitingDetailsDAOImpl();
			List<VisitingDetails> visitingdetailsList = visitingdetailsDAOImpl.findAll();
			return visitingdetailsList;
			
	}

	@Override
	public void save(VisitingDetails visitingdetails) {
		
		VisitingDetailsDAOImpl  visitingdetailsDAOImpl = new  VisitingDetailsDAOImpl();
		int row = visitingdetailsDAOImpl.save(visitingdetails);
		if (row == 1)
			System.out.println("******INSERTED SUCCESSFULLY******");
		else
			System.out.println("*******INSERTION FAILED********");
	}

	@Override
	public void update(VisitingDetails visitingdetails) {
		
		VisitingDetailsDAOImpl  visitingdetailsDAOImpl = new  VisitingDetailsDAOImpl();
		int row = visitingdetailsDAOImpl.update(visitingdetails);
		if (row == 1)
			System.out.println("******UPDATED SUCCESSFULLY******");
		else
			System.out.println("*******UPDATE FAILED********");
	}

	@Override
	public void delete(VisitingDetails visitingdetails) {
		
		VisitingDetailsDAOImpl  visitingdetailsDAOImpl = new  VisitingDetailsDAOImpl();
		int row = visitingdetailsDAOImpl.update(visitingdetails);
		if (row != 0)
			System.out.println("******DELETED SUCCESSFULLY******");
		else
			System.out.println("*******DELETE FAILED********");

	}

	@Override
	public VisitingDetails findById(int registerId) {
		
		VisitingDetailsDAOImpl  visitingdetailsDAOImpl = new  VisitingDetailsDAOImpl();
		VisitingDetails row = visitingdetailsDAOImpl.findById(registerId);
		return row;
	}

	@Override
	public List <VisitingDetails> generatePDF(String date) {
		
		VisitingDetailsDAOImpl  visitingdetailsDAOImpl = new  VisitingDetailsDAOImpl();
		List <VisitingDetails> visitingdetailsList = visitingdetailsDAOImpl.generatePDF(date);
		return visitingdetailsList;
	}
}
