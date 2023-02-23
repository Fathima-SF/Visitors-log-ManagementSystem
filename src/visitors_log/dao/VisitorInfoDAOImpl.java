package visitors_log.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import visitors_log.dbconnectionpool.DBConnectionPool;
import visitors_log.entity.StaffInformation;
import visitors_log.entity.VisitorInfo;

public class VisitorInfoDAOImpl implements VisitorInfoDAO {

	@Override
	public List<VisitorInfo> findAll() {
		
		List<VisitorInfo> visitorinfoList = new ArrayList();
		Connection connection = null; 
		PreparedStatement prepStmt = null;
			
	    String selectSQL = "Select * from visitor_info";
	    
	    try {
	    	  DataSource ds = DBConnectionPool.getDataSource();
		      connection = ds.getConnection();
		      prepStmt = connection.prepareStatement(selectSQL);
	    	  ResultSet resultSet = prepStmt.executeQuery();
	    	  while(resultSet.next())
	    	  {
	    		    int visitorId = resultSet.getInt(1);
					String visitorName = resultSet.getString(2);
					String visitorAddress = resultSet.getString(3);
					String visitorPhoneNo = resultSet.getString(4);
					String gender = resultSet.getString(5);
					String vehicleNo = resultSet.getString(6);
				
					VisitorInfo visitorinfo = new VisitorInfo(visitorId,visitorName,visitorAddress,visitorPhoneNo,gender,vehicleNo);
					visitorinfoList.add(visitorinfo);
					
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
			
	    return visitorinfoList;
	}

	@Override
	public int save(VisitorInfo visitorinfo) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into visitor_info(visitor_name,visitor_address,visitor_phoneNo,gender,vehicle_no) values(?,?,?,?,?)";
		
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setString(1, visitorinfo.getVisitorName());
			preparedStatement.setString(2, visitorinfo.getVisitorAddress());
			preparedStatement.setString(3, visitorinfo.getVisitorPhoneNo());
			preparedStatement.setString(4, visitorinfo.getGender());
			preparedStatement.setString(5, visitorinfo.getVehicleNo());

			int row = preparedStatement.executeUpdate();
			return row;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
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
	public int update(VisitorInfo visitorinfo) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String UPDATE_SQL = "update visitor_info set visitor_name =?,visitor_address =?,visitor_phoneNo =?,gender =?,vehicle_no =? where visitor_id =?";
		
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setString(1, visitorinfo.getVisitorName());
			preparedStatement.setString(2, visitorinfo.getVisitorAddress());
			preparedStatement.setString(3, visitorinfo.getVisitorPhoneNo());
			preparedStatement.setString(4, visitorinfo.getGender());
			preparedStatement.setString(5, visitorinfo.getVehicleNo());
			preparedStatement.setInt(6, visitorinfo.getVisitorId());
			int row = preparedStatement.executeUpdate();
			return row;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
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
	public int delete(VisitorInfo visitorinfo) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String DELETE_SQL = "delete from visitor_info where visitor_id =?";
		
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, visitorinfo.getVisitorId());
			int row = preparedStatement.executeUpdate();
			return row;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
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
	public VisitorInfo findById(int visitorId) {
		
		VisitorInfo visitorinfo = null;
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from visitor_info where visitor_id=" + visitorId;

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				  int visitor_Id = resultSet.getInt(1);
					String visitorName = resultSet.getString(2);
					String visitorAddress = resultSet.getString(3);
					String visitorPhoneNo = resultSet.getString(4);
					String gender = resultSet.getString(5);
					String vehicleNo = resultSet.getString(6);
	
		 visitorinfo = new VisitorInfo(visitorId,visitorName,visitorAddress,visitorPhoneNo,gender,vehicleNo);							}
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

		return visitorinfo;
	}
	}
