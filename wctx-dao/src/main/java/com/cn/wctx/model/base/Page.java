package com.cn.wctx.model.base;

import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页对象
 *
 * @author 徐明明
 */
public class Page<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<T> list;
    private Boolean hasNextPage;

    @JSONField(serialize = false)
    private Integer dataSize;// 数据条数
    private Integer pageSize;// 每页条数
    private Integer totalSize;// 总数
    private String firstTime;// 首次查询时间
    private Integer updateCount;// 更新条数

    public Page() {
        this.dataSize = 10;//默认10个
        this.pageSize = 10;//默认10个
    }

    public Page(List<T> list) {
        this();
        this.list = list;
    }

    public Page(List<T> list, Integer dataSize) {
        this(list);
        if (null != dataSize) {
            this.dataSize = dataSize;
        }
    }

    public Page(List<T> list, Integer dataSize, Integer pageSize) {
        this(list, dataSize);
        if (null != pageSize) {
            this.pageSize = pageSize;
        }
    }

    public Page(List<T> list, String firstTime) {
        this(list);
        this.firstTime = firstTime;
    }

    public Page(List<T> list, String firstTime, Integer dataSize) {
        this(list, dataSize);
        this.firstTime = firstTime;
    }

    public Page(List<T> list, String firstTime, Integer dataSize, Integer pageSize) {
        this(list, dataSize, pageSize);
        this.firstTime = firstTime;
    }

    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    /**
     * 是否有下一页
     *
     * @return
     */
    public Boolean getHasNextPage() {
        if (null != this.hasNextPage) {
            return this.hasNextPage;
        }
        if (CollectionUtils.isEmpty(this.list)) {
            return false;
        }

        return this.list.size() > this.dataSize;
    }

    public List<T> getList() {
        if (!getHasNextPage()) {
            return this.list;
        }

        List<T> copy = new ArrayList<T>();
        copy.addAll(this.list);
        copy.remove(this.list.size() - 1);

        return copy;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getDataSize() {
        return dataSize;
    }

    public void setDataSize(Integer dataSize) {
        this.dataSize = dataSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public Integer getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }
}
