package nyc.c4q.leighdouglas.practicaltest;

/**
 * Created by leighdouglas on 12/11/16.
 */

public class Records {
    int liked;
    Repost repost;
    String profileBackground;

    public Repost getRepost() {
        return repost;
    }

    public boolean checkRespost() {
        return repost != null;
    }

    public int getLiked() {
        return liked;
    }

    public String getProfileBackground() {
        return profileBackground;
    }

    public boolean checkForProfileBackground(){
        return (profileBackground != null);
    }
}
