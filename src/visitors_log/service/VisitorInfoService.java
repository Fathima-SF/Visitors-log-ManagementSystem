package visitors_log.service;

import java.util.List;

import visitors_log.entity.VisitorInfo;

public interface VisitorInfoService {
	
	List <VisitorInfo> findAll();
	void save (VisitorInfo visitorinfo);
	void update (VisitorInfo visitorinfo);
	void delete (VisitorInfo visitorinfo);
	VisitorInfo findById (int visitorId);


}
