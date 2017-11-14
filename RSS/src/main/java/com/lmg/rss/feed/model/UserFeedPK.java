package com.lmg.rss.feed.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

/***********************************
 * @ClassName: UserFeedPK.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月10日上午8:43:16
 ***********************************/

@Embeddable
// 这个注解代表UserFeedPK这个类是用在实体里面，告诉JPA的实现产品:在实体类里面只是使用这个类定义的属性。
// 简单的理解为：UserFeedPK里的属性可以看成是UserFeed类里的属性，好比UserFeedPK的属性就是在UserFeed里定义的
public class UserFeedPK implements Serializable {
    
    /**
     * @Fields serialVersionUID:TODO
     */
    private static final long serialVersionUID = 1L;
    private Integer           userId;
    private Integer           feedId;
    
    
    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     */
    public UserFeedPK() {
    }
    
    
    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     */
    public UserFeedPK(Integer userId, Integer feedId) {
        this.userId = userId;
        this.feedId = feedId;
    }
    
    
    public Integer getUserId() {
        return userId;
    }
    
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    
    public Integer getFeedId() {
        return feedId;
    }
    
    
    public void setFeedId(Integer feedId) {
        this.feedId = feedId;
    }
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((feedId == null) ? 0 : feedId.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        UserFeedPK other = (UserFeedPK) obj;
        if (feedId == null){
            if (other.feedId != null){
                return false;
            }
        } else if (!feedId.equals(other.feedId)){
            return false;
        }
        
        if (userId == null){
            if (other.userId != null){
                return false;
            }
        } else if (!userId.equals(other.userId)){
            return false;
        }
        return true;
    }
    
}
