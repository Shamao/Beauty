package beauty.louise.com;

/**
 * @author lsd
 * @date 2018/12/11.
 */
public class MItem1 extends MBaseItem{
    private int type;
    private String value;

    public MItem1(int type, String value) {
        this.type = type;
        this.value = value;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
