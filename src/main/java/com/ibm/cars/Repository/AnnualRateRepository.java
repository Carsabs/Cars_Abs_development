/**
 * 
 */
package com.ibm.cars.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.cars.Entity.PreUploadAnnrt;
import com.ibm.cars.bean.PreUpldAuditRequestBean;

/**
 * @author 002SUJ744
 *
 */
@Repository
public interface AnnualRateRepository extends JpaRepository<PreUploadAnnrt,String> {

}
