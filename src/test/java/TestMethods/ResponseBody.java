
package TestMethods;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class ResponseBody {

    private String body;
    private long id;
    private String title;
    private long userId;

    public ResponseBody(String body, long id, String title, long userId) {
        this.body = body;
        this.id = id;
        this.title = title;
        this.userId = userId;
    }

public ResponseBody() {

    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

}
