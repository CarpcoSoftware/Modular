/**
 * 
 */
package com.carpco.modular.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import com.carpco.modular.dao.ICompanyDao;
import com.carpco.modular.data.model.AbstractTableModel;
import com.carpco.modular.data.model.administration.Company;

/**
 * Company DAO implementation
 * 
 * @author Carlos Rodriguez
 *
 */
public class ImplCompanyDAO extends AbstractImplDAO implements ICompanyDao {

	@Override
	public Set<AbstractTableModel> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<AbstractTableModel> selectAllActive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<AbstractTableModel> selectAllInactive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractTableModel selectByIdentifier(int identifier) {
		String sql = "SELECT * FROM company WHERE identifier = ? AND enabled = 1 ";
		 
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setInt(1, identifier);
			Company company = null;
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					company = new Company(
						rs.getString("code"), 
						rs.getString("name"),
						rs.getString("dbConnection")
					);
				}
			}
			return company;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insert(AbstractTableModel newRecord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AbstractTableModel record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Company selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
