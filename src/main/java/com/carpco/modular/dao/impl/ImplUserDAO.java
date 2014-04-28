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
import com.carpco.modular.dao.IUserDao;
import com.carpco.modular.data.model.AbstractTableModel;
import com.carpco.modular.data.model.administration.Company;
import com.carpco.modular.data.model.administration.User;

/**
 * User DAO implementation
 * 
 * @author Carlos Rodriguez
 *
 */
public class ImplUserDAO extends AbstractImplDAO implements IUserDao {

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
	public void insert(AbstractTableModel newRecord) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(AbstractTableModel record) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public User selectByLoginPassword(String login, String password) {
		String sql = "SELECT * FROM user WHERE login = ? AND password = ? AND enabled = 1 ";
		 
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setString(1, login);
			ps.setString(2, password);
			User user = null;
			
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					user = new User(
						rs.getInt("identifier"),
						rs.getString("code"), 
						rs.getString("name"),
						rs.getString("login"),
						rs.getString("password")
					);
					ICompanyDao companyDAO = (ICompanyDao) CONTEXT.getBean("companyDAO");
					user.setCompany((Company) companyDAO.selectByIdentifier(rs.getInt("idCompany")));
				}
			}
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User selectByIdentifier(int identifier) {
		// TODO Auto-generated method stub
		return null;
	}
}
