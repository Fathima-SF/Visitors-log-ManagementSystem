package visitors_log.service;

import java.util.List;

import visitors_log.dao.EntyPassDAOImpl;
import visitors_log.entity.EntryPass;

public class EntryPassServiceImpl implements EntryPassService {

	@Override
	public List<EntryPass> findAll() {
		
		 EntyPassDAOImpl  entypassDAOImpl = new  EntyPassDAOImpl();
		List<EntryPass> EntryPassList = entypassDAOImpl.findAll();
		return EntryPassList;
		
		
	}

	@Override
	public void save(EntryPass entrypass) {

		 EntyPassDAOImpl  entypassDAOImpl = new  EntyPassDAOImpl();
		int row = entypassDAOImpl.save(entrypass);
		if (row == 1)
			System.out.println("******INSERTED SUCCESSFULLY******");
		else
			System.out.println("*******INSERTION FAILED********");

	}

	@Override
	public void update(EntryPass entrypass) {
		
		 EntyPassDAOImpl  entypassDAOImpl = new  EntyPassDAOImpl();
			int row = entypassDAOImpl.update(entrypass);
			if (row == 1)
				System.out.println("******UPDATED SUCCESSFULLY******");
			else
				System.out.println("*******UPDATE FAILED********");

	}

	@Override
	public void delete(EntryPass entrypass) {
		
		 EntyPassDAOImpl  entypassDAOImpl = new  EntyPassDAOImpl();
			int row = entypassDAOImpl.delete(entrypass);
			if (row != 0)
				System.out.println("******DELETED SUCCESSFULLY******");
			else
				System.out.println("*******DELETE FAILED********");

	}

	@Override
	public EntryPass findById(int passId) {
		
		 EntyPassDAOImpl  entypassDAOImpl = new  EntyPassDAOImpl();
		 EntryPass entrypass = entypassDAOImpl.findById(passId);
		return entrypass;
	}

}
