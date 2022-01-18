/**
 * 
 */
package com.ibm.cars.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 002SUJ744
 *
 */
@Entity
@Table(name="pre_upload_annrt")
public class PreUploadAnnrt {

	/**
	 * 
	 */
	public PreUploadAnnrt() {
		// TODO Auto-generated constructor stub
	}

	    @Id
		private String mcn;
	    private String action_code ;
	    private Date date;
	    @Column(name="user_name")
	    private String userName ;
		public String getMcn() {
			return mcn;
		}
		public void setMcn(String mcn) {
			this.mcn = mcn;
		}
		public String getAction_code() {
			return action_code;
		}
		public void setAction_code(String action_code) {
			this.action_code = action_code;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
	    
	    
}
