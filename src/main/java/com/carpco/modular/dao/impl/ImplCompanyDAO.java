/**
 * 
 */
package com.carpco.modular.dao.impl;

import java.util.Set;

import com.carpco.modular.dao.ICompanyDao;
import com.carpco.modular.dao.impl.mapper.CompanyMapper;
import com.carpco.modular.data.model.DefaultTableModel;
import com.carpco.modular.data.model.administration.Company;

/**
 * Company DAO implementation
 * 
 * @author Carlos Rodriguez
 *
 */
public class ImplCompanyDAO extends AbstractImplDAO implements ICompanyDao {

	@Override
	public Set<DefaultTableModel> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<DefaultTableModel> selectAllActive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<DefaultTableModel> selectAllInactive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultTableModel selectByIdentifier(int identifier) {
	        StringBuilder sql = new StringBuilder();
	        sql.append("SELECT identifier, code, name, dtCreation, dtLastUpdate, enabled, dbConnection ");
	        sql.append("FROM company ");
	        sql.append("WHERE identifier = ? AND enabled = 1 ");
		 
		Company company = (Company) jdbcTemplateObject.queryForObject(sql.toString(), new Object[]{identifier}, new CompanyMapper());
		return company;
	}

	@Override
	public void insert(DefaultTableModel newRecord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DefaultTableModel record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Company selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
