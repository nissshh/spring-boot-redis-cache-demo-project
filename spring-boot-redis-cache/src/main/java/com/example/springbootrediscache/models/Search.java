/**
 * 
 */
package com.example.springbootrediscache.models;

import java.util.List;

/**
 * @author Nishant Sonar (qkg5rdk)
 *
 */
public class Search {

	String userId;
	String dealerId;
	List<String> userIds;
	List<String> dealerIds;

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

	public List<String> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}

	public List<String> getDealerIds() {
		return dealerIds;
	}

	public void setDealerIds(List<String> dealerIds) {
		this.dealerIds = dealerIds;
	}

}
