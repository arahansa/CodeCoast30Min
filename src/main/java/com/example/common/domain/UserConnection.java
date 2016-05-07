package com.example.common.domain;

import java.io.Serializable;
import java.util.StringTokenizer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@IdClass(ComposedIdKey.class)
@Table(name="USERCONNECTION")
public class UserConnection {
    /*
     * userId` varchar(255) NOT NULL,
	 * `providerId` varchar(255) NOT NULL,
	 * `providerUserId` varchar(255) NOT NULL, 
	 * `rank` int(11) NOT NULL,
	 * `displayName` varchar(255) DEFAULT NULL, 
	 * `profileUrl` varchar(512) DEFAULT NULL, 
	 * `imageUrl` varchar(512) DEFAULT NULL, 
	 * `accessToken' varchar(255) NOT NULL, 
	 * `secret` varchar(255) DEFAULT NULL, 
	 * `refreshToken` varchar(255) DEFAULT NULL, 
	 * `expireTime` bigint(20) DEFAULT NULL, 
	 * PRIMARY KEY (`userId`,`providerId`,`providerUserId`), 
	 * UNIQUE KEY `UserConnectionRank` (`userId`,`providerId`,`rank`)
	 */

	@Id
	@Column(unique=true, name="userid")
	private String userId;
	@Id
	@Column(unique=true, name="providerid")
	private String providerId;
	@Id
	@Column(name="provideruserid")
	private String providerUserId;
	@Column(unique=true)
	private int rank;

	@Column(length=512, name="displayname")
	private String displayName; // 512

	@Column(length=512, name="profileurl")
	private String profileUrl; // 512

	@Column(length=512, name="imageurl")
	private String imageUrl; // 512

	@Column(length=512, name="accesstoken")
	private String accessToken; // 512
	private String secret;
	@Column(name="refreshtoken")
	private String refreshToken;
	@Column(name="expiretime",columnDefinition = "BIGINT UNSIGNED")
	private int expireTime;
	
	public UserConnection() {
	
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public String getProviderUserId() {
		return providerUserId;
	}
	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public int getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}

	
	
	
}

class ComposedIdKey implements Serializable {

	private static final long serialVersionUID = 1L;
	public String userId;
	public String providerId;
	public String providerUserId;


	public ComposedIdKey() {
	}

	public ComposedIdKey(String value) {
		StringTokenizer token = new StringTokenizer(value, "::");
		this.userId = token.nextToken();
		this.providerId = token.nextToken();
		this.providerUserId = token.nextToken();
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof ComposedIdKey)) {
			return false;
		}
		ComposedIdKey c = (ComposedIdKey) obj;
		return userId.equals(c.userId) && providerId.equals(c.providerId) && providerUserId.equals(c.providerUserId);
	}

	public int hashCode() {
		return this.userId.hashCode() ^ this.providerId.hashCode() ^ this.providerUserId.hashCode();
	}

	public String toString() {
		return "" + this.userId + "::" + this.providerId + "::" + this.providerUserId;
	}
}