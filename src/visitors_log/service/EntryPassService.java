package visitors_log.service;

import java.util.List;

import visitors_log.entity.EntryPass;

public interface EntryPassService {

	List < EntryPass > findAll();
	void save( EntryPass  entrypass);
	void update( EntryPass  entrypass);
	void delete( EntryPass  entrypass);
	EntryPass findById(int passId);

}
