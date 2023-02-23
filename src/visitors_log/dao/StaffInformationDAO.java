package visitors_log.dao;

import java.util.List;

import visitors_log.entity.StaffInformation;

public interface StaffInformationDAO {

	List <StaffInformation> findAll();
	int save (StaffInformation staffdetails);
	int update (StaffInformation staffdetails);
	int delete (StaffInformation staffdetails);
	StaffInformation findById(int staffId);

}
