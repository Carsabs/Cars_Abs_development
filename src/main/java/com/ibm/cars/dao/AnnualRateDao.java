package com.ibm.cars.dao;

import java.util.List;

import com.ibm.cars.Entity.PreUploadAnnrt;

public interface AnnualRateDao {
	List<PreUploadAnnrt> getMcn(String mcn) throws Exception;
}
