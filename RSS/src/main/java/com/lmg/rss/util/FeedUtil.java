/**
 * @Title: FeedUtil.java
 * @Package com.lmg.springboot.util
 */
package com.lmg.rss.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmg.rss.feed.model.Feed;
import com.lmg.rss.feed.model.Item;
import com.rometools.rome.feed.WireFeed;
import com.rometools.rome.feed.atom.Entry;
import com.rometools.rome.feed.rss.Category;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndPerson;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

/***********************************
 * @ClassName: FeedUtil.java
 * @Description: TODO
 * @author: Luomingguo
 * @createdAt: 2017年11月8日下午1:12:15
 ***********************************/

public class FeedUtil {
    private static Logger logger = LoggerFactory.getLogger(FeedUtil.class);
    
    
    public static void main(String[] args) throws IllegalArgumentException, MalformedURLException, FeedException,
            IOException {
        String url = "http://www.36kr.com/feed";
        // WireFeed wireFeed =
        // parse("http://news.163.com/special/00011K6L/rss_newsattitude.xml");
        WireFeed wireFeed = parse(url);
        // WireFeed wireFeed = parse("http://www.ftchinese.com/rss/feed");
        System.out.println(parseReturnFeedAndItems(url));
        
    }
    
    
    public static WireFeed parse(String url) {
        try{
            SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
            return feed.createWireFeed();
        } catch (IllegalArgumentException | FeedException | IOException e){
            logger.error("解析URL错误", e);
        }
        return null;
    }
    
    
    public static Map<String, Object> parseReturnFeedAndItems(String url) {
        WireFeed wireFeed = null;
        try{
            SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
            wireFeed = feed.createWireFeed();
        } catch (IllegalArgumentException | FeedException | IOException e){
            logger.error("解析URL错误", e);
            return null;
        }
        
        return parseReturnFeedAndItems(wireFeed);
    }
    
    
    public static Map<String, Object> parseReturnFeedAndItems(WireFeed wireFeed) {
        Feed feed = new Feed();
        List<Item> itemList = new ArrayList<Item>();
        if (wireFeed instanceof Channel){
            Channel channel = (Channel) wireFeed;
            feed.setTitle(channel.getTitle());
            feed.setLink(channel.getLink());
            feed.setDescription(channel.getDescription());
            feed.setGenerator(channel.getGenerator());
            
            if (channel.getItems() != null && channel.getItems().size() > 0){
                for (com.rometools.rome.feed.rss.Item item : channel.getItems()){
                    Item myItem = new Item();
                    myItem.setTitle(item.getTitle());
                    myItem.setLink(item.getLink());
                    myItem.setDescriptionType(item.getDescription().getType());
                    myItem.setDescriptionValue(item.getDescription().getValue());
                    myItem.setFirstImg(getFirstImg(item.getDescription().getValue()));
                    myItem.setAuthor(item.getAuthor());
                    StringBuffer sb = new StringBuffer();
                    for (Category category : item.getCategories()){
                        if (sb.length() > 0){
                            sb.append(",");
                        }
                        sb.append(category.getValue());
                    }
                    myItem.setCategory(sb.toString());
                    myItem.setComments(item.getComments());
                    myItem.setPubDate(new Timestamp(item.getPubDate().getTime()));
                    
                    itemList.add(myItem);
                }
            }
            
        } else if (wireFeed instanceof com.rometools.rome.feed.atom.Feed){
            com.rometools.rome.feed.atom.Feed atom = (com.rometools.rome.feed.atom.Feed) wireFeed;
            feed.setTitle(atom.getTitle() + "-" + atom.getSubtitle());
            feed.setLink(atom.getAlternateLinks().get(0).getHref());
            feed.setDescription("");
            feed.setGenerator(atom.getGenerator().getValue());
            
            if (atom.getEntries() != null && atom.getEntries().size() > 0){
                for (Entry entry : atom.getEntries()){
                    Item myItem = new Item();
                    myItem.setTitle(entry.getTitle());
                    myItem.setLink(entry.getAlternateLinks().get(0).getHref());
                    myItem.setDescriptionType(entry.getSummary().getType());
                    myItem.setDescriptionValue(entry.getSummary().getValue());
                    
                    StringBuffer sb = new StringBuffer();
                    for (SyndPerson person : entry.getAuthors()){
                        if (sb.length() > 0){
                            sb.append(",");
                        }
                        sb.append(person.getName());
                    }
                    myItem.setAuthor(sb.toString());
                    
                    sb = new StringBuffer();
                    for (com.rometools.rome.feed.atom.Category category : entry.getCategories()){
                        if (sb.length() > 0){
                            sb.append(",");
                        }
                        sb.append(category.getLabel());
                    }
                    myItem.setCategory(sb.toString());
                    myItem.setComments("");
                    myItem.setPubDate(new Timestamp(entry.getPublished().getTime()));
                    
                    itemList.add(myItem);
                }
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("feed", feed);
        map.put("items", itemList);
        
        return map;
    }
    
    
    /**
     * @Title: getFirstImg
     * @Description: TODO
     * @param value
     * @return
     * @createdBy:Luomingguo
     * @createaAt:2017年11月28日上午10:17:58
     */
    private static String getFirstImg(String value) {
        String img = null;
        Pattern pattern = Pattern.compile("<img\\s+src\\s*=\\s*[\'\"](https?://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|])[\'\"]");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()){
            img = matcher.group(1);
        }
        return img;
    }
    
    
    /**
     * @Title: simpleFeed
     * @Description: TODO
     * @throws FeedException
     * @throws IOException
     * @throws MalformedURLException
     * @createdBy:Luomingguo
     * @createaAt:2017年11月8日下午1:16:47
     */
    public static void simpleFeed() throws FeedException, IOException, MalformedURLException {
        String url = "http://news.163.com/special/00011K6L/rss_newsattitude.xml";
        SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
        System.out.println(feed);
    }
    
    
    /**
     * @Title: feedByHttp
     * @Description: TODO
     * @throws FeedException
     * @throws IOException
     * @createdBy:Luomingguo
     * @createaAt:2017年11月8日下午1:13:43
     */
    public static void feedByHttp(String url) throws FeedException, IOException {
        try (CloseableHttpClient client = HttpClients.createMinimal()){
            HttpUriRequest request = new HttpGet(url);
            try (CloseableHttpResponse response = client.execute(request);
                    InputStream stream = response.getEntity().getContent()){
                SyndFeedInput input = new SyndFeedInput();
                SyndFeed feed = input.build(new XmlReader(stream));
                System.out.println(feed.getTitle());
            }
        }
    }
}
