package visitors_log.dao;

import java.util.List;

import visitors_log.entity.VisitingDetails;

public interface VisitingDetailsDAO {

	List <VisitingDetails> findAll();
	int save (VisitingDetails visitingdetails);
	int update (VisitingDetails visitingdetails);
	int delete (VisitingDetails visitingdetails);
	VisitingDetails findById(int registerId);
//	VisitingDetails generatePDF (String date);
	List <VisitingDetails> generatePDF(String date);
}
