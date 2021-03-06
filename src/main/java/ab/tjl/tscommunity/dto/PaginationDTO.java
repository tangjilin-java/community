package ab.tjl.tscommunity.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:tangjilin
 * @Description:分页传输
 * @Date:Created in 9:51 2019/8/26
 * @Modified By:
 */
@Data
public class PaginationDTO<T> {
    private List<T> data;
    private boolean showPrevious;//上一页
    private boolean showFirstPage;//第一页
    private boolean showNext;//下一页
    private boolean showEndPage;//最后一页
    private Integer page;//当前页
    private List<Integer> pages = new ArrayList<>();//页数
    private Integer totalPage;

    public void setPagination(Integer totalPage, Integer page) {

        this.totalPage = totalPage;
        this.page = page;//重要  给page赋值

        //循环页码
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        //是否展示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }

        //是否展示下一页
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }

        //是否展示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        //是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}
