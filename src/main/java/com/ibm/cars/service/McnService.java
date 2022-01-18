package com.ibm.cars.service;

import java.util.List;

import com.ibm.cars.Entity.CanAddMcnEntity;
import com.ibm.cars.Entity.PreUploadAnnrt;
import com.ibm.cars.bean.PreUpldAuditRequestBean;

/**
 * @author 002SUJ744
 *
 */
public interface McnService {

	public CanAddMcnEntity canAddMCN(CanAddMcnEntity canaddMcn);

	public List<PreUploadAnnrt> preUpldAudit(PreUpldAuditRequestBean mcn) throws Exception;



	

}
