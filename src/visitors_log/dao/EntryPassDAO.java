package visitors_log.dao;

import java.util.List;

import visitors_log.entity.EntryPass;

public interface EntryPassDAO {

	List <EntryPass> findAll();
	int save (EntryPass entrypass);
	int update (EntryPass entrypass);
	int delete (EntryPass entrypass);
	EntryPass findById(int passId);

}
