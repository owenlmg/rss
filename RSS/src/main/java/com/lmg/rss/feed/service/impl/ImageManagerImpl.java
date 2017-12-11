/**
 * @Title: ImageManagerImpl.java
 * @Package com.lmg.rss.feed.service.impl
 */

package com.lmg.rss.feed.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lmg.rss.common.service.impl.BaseManagerImpl;
import com.lmg.rss.feed.dao.ImageDAO;
import com.lmg.rss.feed.model.Image;
import com.lmg.rss.feed.service.ImageManager;

/***********************************
 * @ClassName: ImageManagerImpl.java
 * @Description: ImageService实现
 * @author: luomingguo
 * @createdAt: 2017-12-1 16:22:01
 ***********************************/

@Service("imageManager")
public class ImageManagerImpl extends BaseManagerImpl<Image> implements ImageManager {
    
    @Resource(name = "imageDAO")
    public void setImageDAO(ImageDAO imageDAO) {
        super.baseDAO = imageDAO;
    }
    
    
    public ImageDAO getImageDAO() {
        return (ImageDAO) super.baseDAO;
    }
}
