package com.ibm.cars.dao;

import java.util.List;

import com.ibm.cars.Entity.PreUploadAnnrt;
import com.ibm.cars.bean.PreUpldAuditRequestBean;

public interface AnnualRateDao {
	List<PreUploadAnnrt> getMcn(String mcn) throws Exception;
	
	void savePreUploadAnnrt(PreUploadAnnrt preupload) throws Exception;
	public void deleteMcn(String mcn)throws Exception;
}
