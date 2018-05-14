package com.cn.wctx.model.base;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基础分页VO
 *
 * @author 徐明明
 */
public class BasePageVo {
    private static final long serialVersionUID = 1L;

    private Integer limit;// 每页条数
    private Integer startId;// 计算分页的开始Id
    private Integer startRow;// 起始条数
    private String startTime;// 首次查询时间
    private Boolean startTimeDefault;// 首次查询时间是否为默认值

    private String userId;

    public BasePageVo() {
        super();
        this.limit = 11;
        this.startTimeDefault = false;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getStartId() {
        return startId;
    }

    public void setStartId(Integer startId) {
        this.startId = startId;
    }

    public Integer getStartRow() {
        return null != startRow ? startRow : 0;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public String getStartTime() {
        if (StringUtils.isEmpty(startTime)) {
            startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            startTimeDefault = true;
        }
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Boolean getStartTimeDefault() {
        return startTimeDefault;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
