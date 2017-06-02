package ar.edu.unlam.tallerweb1.modelo;

import ar.edu.unlam.tallerweb1.modelo.extensions.UserConnectionId;

import javax.persistence.*;

/**
 * Created by Sebastian on 02/06/2017.
 */
@Entity
public class UserConnection {
    @EmbeddedId
    private UserConnectionId id;
    @Column(nullable = false, length = 11)
    private Integer rank;
    @Column(length = 255)
    private String displayName;
    @Column(length = 512)
    private String profileUrl;
    @Column(length = 512)
    private String imageUrl;
    @Column(length = 512, nullable = false)
    private String accessToken;
    @Column(length = 512)
    private String secret;
    @Column(length = 512)
    private String refreshToken;
    @Column(length = 20)
    private Long expireTime;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
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

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }
}


