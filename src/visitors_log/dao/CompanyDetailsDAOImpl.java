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

public class CompanyDetailsDAOImpl implements CompanyDetailsDAO {
	
	
	@Override
	public List<CompanyDetails> findAll() {

		List<CompanyDetails> companydetailsList = new ArrayList();
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String selectSQL = "Select * from company_details";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(selectSQL);
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				int companyId = resultSet.getInt(1);
				String companyName = resultSet.getString(2);
				String address = resultSet.getString(3);
				String emailId = resultSet.getString(4);

				CompanyDetails companydetails = new CompanyDetails(companyId,companyName, address, emailId);
				companydetailsList.add(companydetails);

			}

		} catch (SQLException e) {
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

	 return companydetailsList;
		

	}

	@Override
	public int save(CompanyDetails companydetails) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		final String INSERT_SQL = "insert into company_details(company_name,address,email_id) "+" values(?,?,?)";

		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(INSERT_SQL);
			preparedStatement.setString(1, companydetails.getCompanyName());
			preparedStatement.setString(2, companydetails.getAddress());
			preparedStatement.setString(3, companydetails.getEmailId());
			int row = preparedStatement.executeUpdate();
			return row;

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
		
		return 0;
	}

	@Override
	public int update(CompanyDetails companydetails) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String UPDATE_SQL = "update company_details set company_name = ?,address = ?,email_id = ? where company_id = ?";
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SQL);
			preparedStatement.setString(1, companydetails.getCompanyName());
			preparedStatement.setString(2, companydetails.getAddress());
			preparedStatement.setString(3, companydetails.getEmailId());
			preparedStatement.setInt(4, companydetails.getCompanyId());
		    int row = preparedStatement.executeUpdate();
		    return row;
			

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
		return 0;
	}

	@Override
	public int delete(CompanyDetails companydetails) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String DELETE_SQL = "delete from company_details where company_id = ?";
		
		try {
			DataSource ds = DBConnectionPool.getDataSource();
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SQL);
			preparedStatement.setInt(1, companydetails.getCompanyId());
		    int row = preparedStatement.executeUpdate();
		    return row;
			

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
		
		return 0;
	}

	@Override
	public CompanyDetails findById(int companyId) {
		
		
		CompanyDetails companydetails = null;
			Connection connection = null;
			PreparedStatement prepStmt = null;

			String selectSQL = "Select * from company_details where company_id=" + companyId;

			try {
				DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();
				prepStmt = connection.prepareStatement(selectSQL);
				ResultSet resultSet = prepStmt.executeQuery();
				while (resultSet.next()) {
					int company_id = resultSet.getInt(1);
					String companyName = resultSet.getString(2);
					String address = resultSet.getString(3);
					String emailId = resultSet.getString(4);

					companydetails = new CompanyDetails(companyId,companyName, address, emailId);
					
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

			return companydetails;
		}
		
	}

