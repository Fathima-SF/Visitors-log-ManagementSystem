package visitors_log.service;

import java.util.List;

import visitors_log.dao.CompanyDetailsDAOImpl;
import visitors_log.entity.CompanyDetails;

public class CompanyDetailsServiceImpl implements CompanyDetailsService {

	@Override
	public List<CompanyDetails> findAll() {
		
		CompanyDetailsDAOImpl companydetailsDAOImpl = new CompanyDetailsDAOImpl();
		List<CompanyDetails> companydetailsList = companydetailsDAOImpl.findAll();
		
		return companydetailsList;

	}

	@Override
	public void save(CompanyDetails companydetails) {

		CompanyDetailsDAOImpl companydetailsDAOImpl = new CompanyDetailsDAOImpl();
		int row = companydetailsDAOImpl.save( companydetails);
		if (row == 1)
			System.out.println("*******INSERTED SUCCESSFULLY*********");
		else
			System.out.println("*******INSERTION FAILED*********");

	}

	@Override
	public void update(CompanyDetails companydetails) {
		
		CompanyDetailsDAOImpl companydetailsDAOImpl = new CompanyDetailsDAOImpl();
		int row = companydetailsDAOImpl.update( companydetails);
		if (row == 1)
			System.out.println("------UPDATED---------");
		else
			System.out.println("-------UPDATE FAILED--------");
		
	
		
	}

	@Override
	public void delete(CompanyDetails companydetails) {
	
		CompanyDetailsDAOImpl companydetailsDAOImpl = new CompanyDetailsDAOImpl();
		int row = companydetailsDAOImpl.delete( companydetails);
		if (row != 0)
			System.out.println("------DELETED---------");
		else
			System.out.println("-------DELETED FAILED--------");
		
	}

	@Override
	public CompanyDetails findById(int companyId) {
		
		CompanyDetailsDAOImpl companydetailsDAOImpl = new CompanyDetailsDAOImpl();
		CompanyDetails row = companydetailsDAOImpl.findById(companyId);
			return row;
			
		}
		
	}

