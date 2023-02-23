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
import visitors_log.entity.VisitingDetails;
import visitors_log.entity.VisitorInfo;

public class VisitingDetailsDAOImpl implements VisitingDetailsDAO {

	@Override
	public List<VisitingDetails> findAll() {
		
		List<VisitingDetails> visitingdetailsList = new ArrayList();
		Connection connection = null; 
		PreparedStatement prepStmt = null;
			
	    String selectSQL = "Select * from visiting_details";
	    
	    try {
	    	  DataSource ds = DBConnectionPool.getDataSource();
		      connection = ds.getConnection();
		      prepStmt = connection.prepareStatement(selectSQL);
	    	  ResultSet resultSet = prepStmt.executeQuery();
	    	  while(resultSet.next())
	    	  {
					int registerId = resultSet.getInt(1);
					int passid = resultSet.getInt(2);
					int visitorid = resultSet.getInt(3);
					String date = resultSet.getString(4);
					String visiting_purpose = resultSet.getString(5);
					
					EntryPass entrypass = new EntryPass();
					entrypass.setPassid(passid);
					VisitorInfo visitorinfo = new VisitorInfo();
					visitorinfo.setVisitorId(visitorid);
					
					VisitingDetails visitingdetails = new VisitingDetails(registerId,entrypass,visitorinfo,date,visiting_purpose);
					visitingdetailsList.add(visitingdetails);
					
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
			
	    return visitingdetailsList;
		
	}

	@Override
	public int save(VisitingDetails visitingdetails) {
		
		 Connection connection = null; 
			PreparedStatement preparedStatement = null;
			
			final String INSERT_SQL = "insert into visiting_details(register_id,pass_id,visitor_id,date,visiting_purpose) "+" values(?,?,?,?,?)";

		      try 
		      {
		    	  DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();
				
				preparedStatement =  connection.prepareStatement(INSERT_SQL);
				preparedStatement.setInt(1, visitingdetails.getRegisterId());
				preparedStatement.setInt(2, visitingdetails.getEntrypass().getPassid());
				preparedStatement.setInt(3, visitingdetails.getVisitorinfo().getVisitorId());
				preparedStatement.setString(4, visitingdetails.getDate());
				preparedStatement.setString(5, visitingdetails.getVisitingPurpose());

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
	public int update(VisitingDetails visitingdetails) {
		
		 Connection connection = null; 
			PreparedStatement preparedStatement = null;
			
			final String UPDATE_SQL = "update visiting_details set pass_id =?,visitor_id =?,date =?,visiting_purpose =? where register_id = ?";

		      try 
		      {
		    	  DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();
				
				preparedStatement =  connection.prepareStatement(UPDATE_SQL);
				preparedStatement.setInt(1, visitingdetails.getEntrypass().getPassid());
				preparedStatement.setInt(2, visitingdetails.getVisitorinfo().getVisitorId());
				preparedStatement.setString(3, visitingdetails.getDate());
				preparedStatement.setString(4, visitingdetails.getVisitingPurpose());
				preparedStatement.setInt(5,visitingdetails.getRegisterId());
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
	public int delete(VisitingDetails visitingdetails) {
		
		 Connection connection = null; 
			PreparedStatement preparedStatement = null;
			
			final String DELETE_SQL = "delete visiting_details where register_id = ?";

		      try 
		      {
		    	  DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();
				
				preparedStatement =  connection.prepareStatement(DELETE_SQL);
				preparedStatement.setInt(1, visitingdetails.getRegisterId());
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
	public VisitingDetails findById(int registerId) {
		
		VisitingDetails visitingdetails = null;
		 Connection connection = null; 
			PreparedStatement prepStmt = null;
			
			String SelectSQL = "select * from visiting_details where register_id = " + registerId;
					
			  try {
		    	  DataSource ds = DBConnectionPool.getDataSource();
			      connection = ds.getConnection();
			      prepStmt = connection.prepareStatement(SelectSQL);
		    	  ResultSet resultSet = prepStmt.executeQuery();
		    	  while(resultSet.next())
		    	  {
						int registerid = resultSet.getInt(1);
						int passid = resultSet.getInt(2);
						int visitorid = resultSet.getInt(3);
						String date = resultSet.getString(4);
						String visiting_purpose = resultSet.getString(5);
						
						EntryPass entrypass = new EntryPass();
						entrypass.setPassid(passid);
						VisitorInfo visitorinfo = new VisitorInfo();
						visitorinfo.setVisitorId(visitorid);
						
					    visitingdetails = new VisitingDetails(registerId,entrypass,visitorinfo,date,visiting_purpose);
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
				
		    return visitingdetails;
			
		}

	public 	List <VisitingDetails> generatePDF(String date) {
		
		List <VisitingDetails> visitingdetailsList = new ArrayList();
		VisitingDetails visitingdetails = new VisitingDetails();
		 Connection connection = null; 
			PreparedStatement prepStmt = null;
			
			String joinSQL = "select visiting_details.date,visitor_info.visitor_id,visitor_info.visitor_name,visitor_info.visitor_phoneNo,visitor_info.visitor_address,visitor_info.gender,visitor_info.vehicle_no from visiting_details join visitor_info on visiting_details.visitor_id = visitor_info.visitor_id where visiting_details.date = ?"; 
			
			  try {
		    	  DataSource ds = DBConnectionPool.getDataSource();
			      connection = ds.getConnection();
			      prepStmt = connection.prepareStatement(joinSQL);
			      prepStmt.setString(1, date);
		    	  ResultSet resultSet = prepStmt.executeQuery();
		    	  while(resultSet.next())
		    	  {
		    		String daTe = resultSet.getString(1);
				    int visitorid = resultSet.getInt(2);
				    String visitorName = resultSet.getString(3);
					String visitorPhoneNo = resultSet.getString(4);
					String visitorAddress = resultSet.getString(5);
					String gender = resultSet.getString(6);
					String vehicleNo = resultSet.getString(7);
						
				    VisitorInfo visitorinfo = new VisitorInfo();
					visitorinfo.setVisitorId(visitorid);
					visitorinfo.setVisitorName(visitorName);
					visitorinfo.setVisitorPhoneNo(visitorPhoneNo);
					visitorinfo.setVisitorAddress(visitorAddress);
					visitorinfo.setGender(gender);
					visitorinfo.setVehicleNo(vehicleNo);
						
					 visitingdetails = new VisitingDetails();
					 visitingdetails.setDate(daTe);
					 visitingdetails.setVisitorinfo(visitorinfo);
					 visitingdetailsList.add(visitingdetails);
					 
					 					
		    	  }
		    	 
			  }
			   	 catch (SQLException e) {
						//System.out.println("Date does't exist ");
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
			
		return visitingdetailsList;
	}

}
