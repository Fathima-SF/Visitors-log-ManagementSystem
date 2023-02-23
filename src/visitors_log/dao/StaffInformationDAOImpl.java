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
import visitors_log.entity.StaffInformation;

public class StaffInformationDAOImpl implements StaffInformationDAO {

	@Override
	public List<StaffInformation> findAll() {
		
		List<StaffInformation> staffdetailsList = new ArrayList();
		Connection connection = null; 
		PreparedStatement prepStmt = null;
			
	    String selectSQL = "Select * from staff_information";
	    
	    try {
	    	  DataSource ds = DBConnectionPool.getDataSource();
		      connection = ds.getConnection();
		      prepStmt = connection.prepareStatement(selectSQL);
	    	  ResultSet resultSet = prepStmt.executeQuery();
	    	  while(resultSet.next())
	    	  {
	    		    int staffId = resultSet.getInt(1);
					String staffName = resultSet.getString(2);
					String staffPosition = resultSet.getString(3);
					String staffPhoneNo = resultSet.getString(4);
					
					StaffInformation staffdetails = new StaffInformation(staffId,staffName,staffPosition,staffPhoneNo);
					staffdetailsList.add(staffdetails);
					
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
			
	    return staffdetailsList;

	}

	@Override
	public int save(StaffInformation staffdetails) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into staff_information(staff_name,staff_position,staff_phoneNo) values(?,?,?)";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setString(1, staffdetails.getStaffName());
			preparedStatement.setString(2, staffdetails.getStaffPosition());
			preparedStatement.setString(3, staffdetails.getstaffPhoneNo());
			int row = preparedStatement.executeUpdate();
			return row;
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;
	
	}

	@Override
	public int update(StaffInformation staffdetails) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String UPDATE_SQL = "update staff_information set staff_name = ?,staff_position = ?,staff_phoneNo = ? where staff_id = ?";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setString(1, staffdetails.getStaffName());
			preparedStatement.setString(2, staffdetails.getStaffPosition());
			preparedStatement.setString(3, staffdetails.getstaffPhoneNo());
			preparedStatement.setInt(4, staffdetails.getStaffId());

			int row = preparedStatement.executeUpdate();
			return row;
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int delete(StaffInformation staffdetails) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String DELETE_SQL = "delete from staff_information where staff_id = ?";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, staffdetails.getStaffId());

			int row = preparedStatement.executeUpdate();
			return row;
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public StaffInformation findById(int staffId) {
		
		StaffInformation staffinformation = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from staff_information where staff_id=" + staffId;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				  int staff_Id = resultSet.getInt(1);
					String staffName = resultSet.getString(2);
					String staffPosition = resultSet.getString(3);
					String staffPhoneNo = resultSet.getString(4);
					
					staffinformation = new StaffInformation(staffId,staffName,staffPosition,staffPhoneNo);
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

		return staffinformation;
	}
	
	}

