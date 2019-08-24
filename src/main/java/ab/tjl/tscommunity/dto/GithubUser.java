package ab.tjl.tscommunity.dto;

/**
 * @author:tangjilin
 * @Description:把参数封装成一个对象
 * @Date:Created in 16:49 2019/8/24
 * @Modified By:
 */
public class GithubUser {
    private String name;
    private Long id;
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
