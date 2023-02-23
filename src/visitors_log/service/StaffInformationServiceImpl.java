package visitors_log.service;

import java.util.List;

import visitors_log.dao.CompanyDetailsDAOImpl;
import visitors_log.dao.StaffInformationDAOImpl;
import visitors_log.entity.CompanyDetails;
import visitors_log.entity.StaffInformation;

public class StaffInformationServiceImpl implements StaffInformationService {

	@Override
	public List<StaffInformation> findAll() {
		
		StaffInformationDAOImpl staffdetailsDAOImpl = new StaffInformationDAOImpl();
		List<StaffInformation> staffdetailsList = staffdetailsDAOImpl.findAll();
		return staffdetailsList;

	}

	@Override
	public void save(StaffInformation staffdetails) {
		
		StaffInformationDAOImpl staffdetailsDAOImpl = new StaffInformationDAOImpl();
		int row = staffdetailsDAOImpl.save(staffdetails);
		if (row == 1)
			System.out.println("INSERTED SUCCESSFULLY!!!!!!!!!!!!");
		else
			System.out.println("INSERTION FAILED!!!!!!!!!!!!");

	}

	@Override
	public void update(StaffInformation staffdetails) {
		
		StaffInformationDAOImpl staffdetailsDAOImpl = new StaffInformationDAOImpl();
		int row = staffdetailsDAOImpl.update(staffdetails);
		if (row == 1)
			System.out.println("--------UPDATE SUCCESSFULLY-------");
		else
			System.out.println("--------UPDATE FAILED-----------");

	}

	@Override
	public void delete(StaffInformation staffdetails) {
		
		StaffInformationDAOImpl staffdetailsDAOImpl = new StaffInformationDAOImpl();
		int row = staffdetailsDAOImpl.delete(staffdetails);
		if (row != 0)
			System.out.println("--------DELETE SUCCESSFULLY-------");
		else
			System.out.println("--------DELETE FAILED-----------");

		
	}

	@Override
	public StaffInformation findById(int staffId) {

		StaffInformationDAOImpl staffdetailsDAOImpl = new StaffInformationDAOImpl();
		StaffInformation row = staffdetailsDAOImpl.findById(staffId);
			return row;	

	}

}
