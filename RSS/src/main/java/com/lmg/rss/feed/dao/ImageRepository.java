/**
 * @Title: RssRepository.java
 * @Package com.lmg.springboot.feed.dao
 */
package com.lmg.rss.feed.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lmg.rss.feed.model.Image;

/***********************************
 * @ClassName: RssRepository.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月8日下午4:43:54
 ***********************************/

public interface ImageRepository extends CrudRepository<Image, Integer> {
    List<Image> findByFeedId(Integer feedId);
}
