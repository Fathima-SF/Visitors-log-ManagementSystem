package visitors_log.service;

import java.util.List;

import visitors_log.dao.BlockDetailsDAOImpl;
import visitors_log.entity.BlockDetails;

public class BlockDetailsServiceImpl implements BlockDetailsService {

	@Override
	public List<BlockDetails> findAll() {
		
		BlockDetailsDAOImpl  blockdetailsDAOImpl = new  BlockDetailsDAOImpl();
			List<BlockDetails> blockdetailsList = blockdetailsDAOImpl.findAll();
			return blockdetailsList;
			
	}

	@Override
	public void save(BlockDetails blockdetails) {

		BlockDetailsDAOImpl  blockdetailsDAOImpl = new  BlockDetailsDAOImpl();
			int row = blockdetailsDAOImpl.save(blockdetails);
			if (row == 1)
				System.out.println("******INSERTED SUCCESSFULLY******");
			else
				System.out.println("*******INSERTION FAILED********");

	}

	@Override
	public void update(BlockDetails blockdetails) {
		
		BlockDetailsDAOImpl  blockdetailsDAOImpl = new  BlockDetailsDAOImpl();
		int row = blockdetailsDAOImpl.update(blockdetails);
		if (row == 1)
			System.out.println("******UPDATED SUCCESSFULLY******");
		else
			System.out.println("*******UPDATE FAILED********");

	}

	@Override
	public void delete(BlockDetails blockdetails) {

		BlockDetailsDAOImpl  blockdetailsDAOImpl = new  BlockDetailsDAOImpl();
		int row = blockdetailsDAOImpl.delete(blockdetails);
		if (row != 0)
			System.out.println("******DELETED SUCCESSFULLY******");
		else
			System.out.println("*******DELETE FAILED********");

	}

	@Override
	public BlockDetails findById(int blockId) {
		
		BlockDetailsDAOImpl  blockdetailsDAOImpl = new  BlockDetailsDAOImpl();
		BlockDetails row = blockdetailsDAOImpl.findById(blockId);	
		return row;
	}

}
