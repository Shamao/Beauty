package princessmakeup.buykee.com.beauty.bean.base;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lsd on 17/8/26.
 */

public class MultiPage<T> {
    @SerializedName("page")
    String mPage;

    @SerializedName("pages")
    String mPages;

    @SerializedName(value = "list", alternate = {"data"})
    List<T> mList;

    public String getPage() {
        return mPage;
    }

    public void setPage(String page) {
        mPage = page;
    }

    public String getPages() {
        return mPages;
    }

    public void setPages(String pages) {
        mPages = pages;
    }

    public List<T> getList() {
        return mList;
    }

    public void setList(List<T> list) {
        mList = list;
    }
}
