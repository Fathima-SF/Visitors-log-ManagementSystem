package visitors_log.service;

import java.util.List;

import visitors_log.entity.StaffInformation;

public interface StaffInformationService {
	
	List<StaffInformation> findAll();
	void save(StaffInformation staffdetails);
	void update(StaffInformation staffdetails);
	void delete(StaffInformation staffdetails);
	StaffInformation findById(int staffId);

}
