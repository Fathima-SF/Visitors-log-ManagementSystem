package visitors_log.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import visitors_log.dbconnectionpool.DBConnectionPool;
import visitors_log.entity.CompanyDetails;
import visitors_log.entity.EntryPass;
import visitors_log.entity.StaffInformation;
import visitors_log.entity.VisitorInfo;

public class EntyPassDAOImpl implements EntryPassDAO {

	@Override
	public List<EntryPass> findAll() {
		
		List<EntryPass> entrypassList = new ArrayList();
		Connection connection = null; 
		PreparedStatement prepStmt = null;
			
	    String selectSQL = "Select * from entry_pass";
	    
	    try {
	    	  DataSource ds = DBConnectionPool.getDataSource();
		      connection = ds.getConnection();
		      prepStmt = connection.prepareStatement(selectSQL);
	    	  ResultSet resultSet = prepStmt.executeQuery();
	    	  while(resultSet.next())
	    	  {
					int passid = resultSet.getInt(1);
					int visitorId = resultSet.getInt(2);
					int companyId = resultSet.getInt(3);
					int staffId = resultSet.getInt(4);
					String timeIn = resultSet.getString(5);
					String timeOut = resultSet.getString(6);
					
					VisitorInfo visitorinfo = new VisitorInfo();
					visitorinfo.setVisitorId(visitorId);
					CompanyDetails companydetails = new CompanyDetails();
					companydetails.setCompanyId(companyId);
					StaffInformation staffinformation = new StaffInformation();
					staffinformation.setStaffId(staffId);
					
					EntryPass entrypass = new EntryPass(passid,visitorinfo,companydetails,staffinformation,timeIn,timeOut);
					entrypassList.add(entrypass);
					
				}
    	}
	   	 catch (SQLException e) {
				e.printStackTrace();
		}
	    finally
		{
			try {
				if(connection!=null)
				connection.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
	    return entrypassList;
		
	}

	@Override
	public int save(EntryPass entrypass) {
		
	    Connection connection = null; 
		PreparedStatement preparedStatement = null;
		
		final String insertSQL = "insert into entry_pass(pass_id,visitor_id,company_id,staff_id,time_IN,time_OUT) "+" values(?,?,?,?,?,?)";

	    
	      try 
	      {
	    	  DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			
			preparedStatement =  connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, entrypass.getPassid());
			preparedStatement.setInt(2, entrypass.getVisitorinfo().getVisitorId());
			preparedStatement.setInt(3, entrypass.getCompanydetails().getCompanyId());
			preparedStatement.setInt(4, entrypass.getStaffinformation().getStaffId());
			preparedStatement.setString(5, entrypass.getTimeIn());
			preparedStatement.setString(6, entrypass.getTimeOut());


			int row = preparedStatement.executeUpdate();
			return row;
	   }
	      catch (SQLException e) 
		    {
				
				e.printStackTrace();
			}
	      finally {
				try {
					if (connection != null)
						connection.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
	
		return 0;
	}

	@Override
	public int update(EntryPass entrypass) {
		
		 Connection connection = null; 
			PreparedStatement preparedStatement = null;
			
			final String UPDATE_SQL = "update entry_pass set visitor_id =?,company_id =?,staff_id =?,time_IN =?,time_OUT =? where pass_id = ?";

		    
		      try 
		      {
		    	  DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();
				
				preparedStatement =  connection.prepareStatement(UPDATE_SQL);	
				preparedStatement.setInt(1, entrypass.getVisitorinfo().getVisitorId());
				preparedStatement.setInt(2, entrypass.getCompanydetails().getCompanyId());
				preparedStatement.setInt(3, entrypass.getStaffinformation().getStaffId());
				preparedStatement.setString(4, entrypass.getTimeIn());
				preparedStatement.setString(5, entrypass.getTimeOut());
				preparedStatement.setInt(6, entrypass.getPassid());

				int row = preparedStatement.executeUpdate();
				return row;
		   }
		      catch (SQLException e) 
			    {
					
					e.printStackTrace();
				}
		      finally {
					try {
						if (connection != null)
							connection.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
		
		return 0;
	}

	@Override
	public int delete(EntryPass entrypass) {
		
		 Connection connection = null; 
			PreparedStatement preparedStatement = null;
			
			final String DELETE_SQL = "delete from entry_pass where pass_id =?";

		    
		      try 
		      {
		    	  DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();
				
				preparedStatement =  connection.prepareStatement(DELETE_SQL);
				preparedStatement.setInt(1, entrypass.getPassid());
				int row = preparedStatement.executeUpdate();
				return row;
		   }
		      catch (SQLException e) 
			    {
					
					e.printStackTrace();
				}
		      finally {
					try {
						if (connection != null)
							connection.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
		return 0;
	}

	@Override
	public EntryPass findById(int passId) {
		
		EntryPass entrypass = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from entry_pass where pass_id= " + passId ;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int passid = resultSet.getInt(1);
				int visitorId = resultSet.getInt(2);
				int companyId = resultSet.getInt(3);
				int staffId = resultSet.getInt(4);
				String timeIn = resultSet.getString(5);
				String timeOut = resultSet.getString(6);
				
				VisitorInfo visitorinfo = new VisitorInfo();
				visitorinfo.setVisitorId(visitorId);
				CompanyDetails companydetails = new CompanyDetails();
				companydetails.setCompanyId(companyId);
				StaffInformation staffinformation = new StaffInformation();
				staffinformation.setStaffId(staffId);
				
			 entrypass = new EntryPass(passId,visitorinfo,companydetails,staffinformation,timeIn,timeOut);
							}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return entrypass;
	}
	}

