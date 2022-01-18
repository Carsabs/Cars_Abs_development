package com.ibm.cars.service;

import java.util.List;

import com.ibm.cars.Entity.CanAddMcnEntity;
import com.ibm.cars.Entity.PreUploadAnnrt;

/**
 * @author 002SUJ744
 *
 */
public interface McnService {

	public CanAddMcnEntity canAddMCN(CanAddMcnEntity canaddMcn);

	public List<PreUploadAnnrt> preUpldAudit(String mcn) throws Exception;



	

}
