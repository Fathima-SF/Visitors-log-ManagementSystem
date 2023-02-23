package visitors_log.service;

import java.util.List;

import visitors_log.entity.BlockDetails;

public interface BlockDetailsService {

	List< BlockDetails> findAll();
	void save( BlockDetails  blockdetails);
	void update (BlockDetails  blockdetails);
	void delete (BlockDetails  blockdetails);
	BlockDetails findById (int blockId);
}
