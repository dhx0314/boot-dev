package cn.dhx.redispool.Redis;

public class RedisDao {

    private String type;

    private String url;

    private String password;

    private RedisCluster redisCluster;

    private RedisPool redisPool;

    public RedisDao(String type, String url, String password) {
        this.type = type;
        this.url = url;
        this.password = password;
    }

    public RedisDao(String type, String url) {
        this.type = type;
        this.url = url;
    }

    public void init() {
        if ("0".equals(type)) {


        } else if ("1".equals(type)) {

        }else {
            // type error
        }
    }

    public RedisDao() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
