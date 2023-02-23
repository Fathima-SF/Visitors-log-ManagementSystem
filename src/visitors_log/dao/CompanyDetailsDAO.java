package visitors_log.dao;

import java.util.List;

import visitors_log.entity.CompanyDetails;

public interface CompanyDetailsDAO {

	List <CompanyDetails> findAll();
	int save (CompanyDetails companydetails);
	int update (CompanyDetails companydetails);
	int delete (CompanyDetails companydetails);
	CompanyDetails findById(int companyId);

	
}
