package hashtable;

import java.util.*;

/**
 * Created by ping.wu on 2016/12/12.
 */
public class Design_Twitter_355 {
    private Map<Integer, LinkedList<Integer>> map;

    public Design_Twitter_355() {
        map = new HashMap<Integer, LinkedList<Integer>>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        LinkedList<Integer> content = map.get(userId);
        if (content != null && content.size() > 0) {
            if (content.contains(tweetId)) {
                content.remove(content.indexOf(tweetId));
                content.addFirst(tweetId);
            } else {
                content.addFirst(tweetId);
            }
        } else {
            content = new LinkedList<Integer>();
            content.add(tweetId);
        }
        map.put(userId, content);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        return map.get(userId);
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        LinkedList<Integer> content = map.get(followeeId);
        if (content != null && content.size() > 0) {
            for (Integer i : content) {
                postTweet(followeeId, i);
            }
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        LinkedList<Integer> content = map.get(followeeId);
        if (content != null && content.size() > 0) {
            for (int i : content) {
                map.get(follow
            }
        }
    }

    public static void main(String[] args) {
        Design_Twitter_355 dt = new Design_Twitter_355();
        dt.postTweet(1, 1);
        dt.getNewsFeed(1);
        dt.follow(2, 1);
        dt.getNewsFeed(2);
        dt.unfollow(2, 1);
        dt.getNewsFeed(2);
    }
}
