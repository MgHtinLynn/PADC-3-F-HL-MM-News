package xyz.htinlynn.news.data.vo;

import java.util.List;

/**
 * Created by htinlynn on 12/17/17.
 */

public class FavoriteVO {
    private String favoritesId;
    private String FavoritesDate;
    private List<ActedUserVO> actedUser;

    public String getFavoritesId() {
        return favoritesId;
    }

    public String getFavoritesDate() {
        return FavoritesDate;
    }

    public List<ActedUserVO> getActedUser() {
        return actedUser;
    }
}
