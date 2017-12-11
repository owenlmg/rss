/**
 * @Title: ImageDAOImpl.java
 * @Package com.lmg.rss.feed.dao.impl
 */
package com.lmg.rss.feed.dao.impl;

import org.springframework.stereotype.Repository;

import com.lmg.rss.common.dao.impl.BaseDAOImpl;
import com.lmg.rss.feed.dao.ImageDAO;
import com.lmg.rss.feed.model.Image;

/***********************************
 * @ClassName: ImageDAOImpl.java
 * @Description: ImageDAO实现
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:22:01
 ***********************************/

@Repository("imageDAO")
public class ImageDAOImpl extends BaseDAOImpl<Image> implements ImageDAO {
    
}
