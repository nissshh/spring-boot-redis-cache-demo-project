/**
 * 
 */
package com.example.springbootrediscache.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * @author Nishant Sonar (qkg5rdk)
 *
 */
@RedisHash("dealer-map")
public class DealerMap {
	String id;
	
	@Indexed
	String userId;
	
	@Indexed
	String dealerId;
	
	public DealerMap() {
		// TODO Auto-generated constructor stub
	}

	public DealerMap(String userId, String dealerId) {
		super();
		this.id = userId + "-" + dealerId;
		this.userId = userId;
		this.dealerId = dealerId;
	}

	@Id
	public String getId() {
		return userId + "-" + dealerId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	@Override
	public String toString() {
		return "DealerMap [userId=" + userId + ", dealerId=" + dealerId + "]";
	}

}
