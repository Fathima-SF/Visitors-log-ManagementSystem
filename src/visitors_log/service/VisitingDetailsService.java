package visitors_log.service;

import java.util.List;

import visitors_log.entity.VisitingDetails;

public interface VisitingDetailsService {
	
	List< VisitingDetails> findAll();
	void save( VisitingDetails  visitingdetails);
	void update (VisitingDetails  visitingdetails);
	void delete (VisitingDetails  visitingdetails);
	VisitingDetails findById(int registerId);
//	VisitingDetails generatePDF (String date);
	List <VisitingDetails> generatePDF(String date);

}
