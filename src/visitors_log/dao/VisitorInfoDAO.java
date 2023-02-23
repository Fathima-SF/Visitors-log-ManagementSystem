package visitors_log.dao;

import java.util.List;

import visitors_log.entity.VisitorInfo;

public interface VisitorInfoDAO {
	
	List <VisitorInfo> findAll();
	int save (VisitorInfo visitorinfo);
	int update (VisitorInfo visitorinfo);
	int delete (VisitorInfo visitorinfo);
	VisitorInfo findById (int visitorId);

}
