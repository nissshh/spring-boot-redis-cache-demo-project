/**
 * 
 */
package com.example.springbootrediscache.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.springbootrediscache.models.DealerMap;
import com.example.springbootrediscache.models.Search;

/**
 * @author Nishant Sonar (qkg5rdk)
 *
 */

//@Repository
public class DealerMapRepositoryImpl {

//	@Autowired
    private HashOperations hashOperations;

//	@Autowired
	private RedisTemplate<String, DealerMap> redisTemplate;

//	@Override
//	public List<DealerMap> findBySearch(Search dealerMap) {
//	}
}