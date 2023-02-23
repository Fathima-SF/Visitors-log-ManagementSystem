package visitors_log.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import visitors_log.dbconnectionpool.DBConnectionPool;
import visitors_log.entity.BlockDetails;
import visitors_log.entity.CompanyDetails;
import visitors_log.entity.StaffInformation;
import visitors_log.entity.VisitorInfo;

public class BlockDetailsDAOImpl implements BlockDetailsDAO {

	@Override
	public List<BlockDetails> findAll() {
		
		List<BlockDetails> blockdetailsList = new ArrayList();
		Connection connection = null; 
		PreparedStatement prepStmt = null;
			
	    String selectSQL = "Select * from block_details";
	    
	    try {
	    	  DataSource ds = DBConnectionPool.getDataSource();
		      connection = ds.getConnection();
		      prepStmt = connection.prepareStatement(selectSQL);
	    	  ResultSet resultSet = prepStmt.executeQuery();
	    	  while(resultSet.next())
	    	  {
					int blockid = resultSet.getInt(1);
					String blockname = resultSet.getString(2);
					int companyId = resultSet.getInt(3);
						
					CompanyDetails companydetails = new CompanyDetails();
					companydetails.setCompanyId(companyId);
									
					BlockDetails blockdetails = new BlockDetails(blockid,blockname,companydetails);
					blockdetailsList.add(blockdetails);
					
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
			
	    return blockdetailsList;
	}

	@Override
	public int save(BlockDetails blockdetails) {
		
		  Connection connection = null; 
			PreparedStatement preparedStatement = null;
			
			final String INSERT_SQL = "insert into block_details(block_id,block_name,company_id) "+" values(?,?,?)";

		      try 
		      {
		    	  DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();
				
				preparedStatement =  connection.prepareStatement(INSERT_SQL);
				preparedStatement.setInt(1, blockdetails.getBlockid());
				preparedStatement.setString(2, blockdetails.getBlockname());
				preparedStatement.setInt(3, blockdetails.getCompanydetails().getCompanyId());


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
	public int update(BlockDetails blockdetails) {
		
		
		  Connection connection = null; 
			PreparedStatement preparedStatement = null;
			
			final String UPDATE_SQL = "update block_details set block_name =?,company_id =? where block_id =?";

		      try 
		      {
		    	  DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();
				preparedStatement =  connection.prepareStatement(UPDATE_SQL);
				preparedStatement.setString(1, blockdetails.getBlockname());
				preparedStatement.setInt(2, blockdetails.getCompanydetails().getCompanyId());
				preparedStatement.setInt(3, blockdetails.getBlockid());

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
	public int delete(BlockDetails blockdetails) {
		
		  Connection connection = null; 
			PreparedStatement preparedStatement = null;
			
			final String DELETE_SQL = "delete from block_details where block_id =?";

		      try 
		      {
		    	  DataSource ds = DBConnectionPool.getDataSource();
				connection = ds.getConnection();
				preparedStatement =  connection.prepareStatement(DELETE_SQL);
				preparedStatement.setInt(1, blockdetails.getBlockid());

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
	public BlockDetails findById(int blockId) {
		
		BlockDetails blockdetails = null;
		Connection connection = null; 
		PreparedStatement prepStmt = null;
		
		String SelectSQL = "select * from block_details where block_id = " + blockId;
		
		   try {
		    	  DataSource ds = DBConnectionPool.getDataSource();
			      connection = ds.getConnection();
			      prepStmt = connection.prepareStatement(SelectSQL);
		    	  ResultSet resultSet = prepStmt.executeQuery();
		    	  while(resultSet.next())
		    	  {
						int blockid = resultSet.getInt(1);
						String blockname = resultSet.getString(2);
						int companyId = resultSet.getInt(3);
							
						CompanyDetails companydetails = new CompanyDetails();
						companydetails.setCompanyId(companyId);
										
					 blockdetails = new BlockDetails(blockId,blockname,companydetails);
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
				
		return blockdetails;
	}

}
