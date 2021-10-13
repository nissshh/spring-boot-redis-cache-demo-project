/**
 * 
 */
package com.example.springbootrediscache.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.example.springbootrediscache.models.DealerMap;

/**
 * @author Nishant Sonar (qkg5rdk)
 *
 */
@Repository
public interface DealerMapRepository extends CrudRepository<DealerMap, String>, QueryByExampleExecutor<DealerMap> {

}
