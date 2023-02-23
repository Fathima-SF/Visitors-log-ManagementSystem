package visitors_log.dao;

import java.util.List;

import visitors_log.entity.BlockDetails;

public interface BlockDetailsDAO {
	
	List <BlockDetails> findAll();
	int save (BlockDetails blockdetails);
	int update (BlockDetails blockdetails);
	int delete (BlockDetails blockdetails);
	BlockDetails findById (int blockId);

	

}
