package nyc.c4q.leighdouglas.practicaltest;

/**
 * Created by leighdouglas on 12/11/16.
 */

public class Repost {
    String profileBackground;
    User user;

    public String getProfileBackground() {
        return profileBackground;
    }

    public boolean checkForUser(){
        return (user != null);
    }

    public User getUser() {
        return user;
    }
}
