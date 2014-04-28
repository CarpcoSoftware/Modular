package com.carpco.modular.data.model.administration;

import com.carpco.modular.data.model.DefaultTableModel;

/**
 * Access is a model from database table.
 * 
 * It allows to know what access has the user.
 * 
 * @author Carlos Rodriguez
 *
 */
public class Access extends DefaultTableModel {

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Access [identifier=" + identifier + ", code=" + code + ", name=" + name + ", dtCreation=" + dtCreation + ", dtLastUpdate=" + dtLastUpdate
                + ", enabled=" + enabled + "]";
    }

}
