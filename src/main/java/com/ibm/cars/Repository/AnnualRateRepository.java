/**
 * 
 */
package com.ibm.cars.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.cars.Entity.PreUploadAnnrt;

/**
 * @author 002SUJ744
 *
 */
@Repository
public interface AnnualRateRepository extends JpaRepository<PreUploadAnnrt,String> {

	/**
	 * 
	 */

}
