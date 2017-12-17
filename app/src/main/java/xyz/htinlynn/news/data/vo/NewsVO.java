package xyz.htinlynn.news.data.vo;

import java.util.List;

/**
 * Created by htinlynn on 12/17/17.
 */

public class NewsVO {
    private String newsId;
    private String brief;
    private String details;
    private List<String> Images;
    private String postedDate;

    private PublicationVO publication;
    private List<FavoriteVO> favorites;
    private List<CommentVO> comments;
    private List<SendToVO> sendTos;

    public String getNewsId() {
        return newsId;
    }

    public String getBrief() {
        return brief;
    }

    public String getDetails() {
        return details;
    }

    public List<String> getImages() {
        return Images;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public PublicationVO getPublication() {
        return publication;
    }

    public List<FavoriteVO> getFavorites() {
        return favorites;
    }

    public List<CommentVO> getComments() {
        return comments;
    }

    public List<SendToVO> getSendTos() {
        return sendTos;
    }
}
