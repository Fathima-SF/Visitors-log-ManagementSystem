package visitors_log.service;

import java.util.List;

import visitors_log.entity.CompanyDetails;

public interface CompanyDetailsService {

	List< CompanyDetails> findAll();
	void save( CompanyDetails  companydetails);
	void update (CompanyDetails  companydetails);
	void delete (CompanyDetails  companydetails);
	CompanyDetails findById(int companyId);


}
