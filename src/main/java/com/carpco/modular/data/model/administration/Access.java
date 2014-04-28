package com.carpco.modular.data.model.administration;

import com.carpco.modular.data.model.AbstractTableModel;

/**
 * Access is a model from database table.
 * 
 * It allows to know what access has the user.
 * 
 * @author Carlos Rodriguez
 *
 */
public class Access extends AbstractTableModel {
	
	/**
	 * Role access constructor 
	 * 
	 * @param code Role access code
	 * @param name Role access name
	 */
	public Access(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

}
