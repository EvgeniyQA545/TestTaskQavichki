
package TestMethods;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class RequestBody {

    private String body;
    private String title;
    private long userId;

    public RequestBody(String body, long id, String title, long userId) {
        this.body = body;
        this.title = title;
        this.userId = userId;
    }

    public RequestBody() {

    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
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
