package com.entity.model;

import com.entity.ManhuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 漫画
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ManhuaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 漫画名称
     */
    private String manhuaName;


    /**
     * 漫画编号
     */
    private String manhuaUuidNumber;


    /**
     * 漫画照片
     */
    private String manhuaPhoto;


    /**
     * 漫画类型
     */
    private Integer manhuaTypes;


    /**
     * 漫画热度
     */
    private Integer manhuaClicknum;


    /**
     * 漫画介绍
     */
    private String manhuaContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer manhuaDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：漫画名称
	 */
    public String getManhuaName() {
        return manhuaName;
    }


    /**
	 * 设置：漫画名称
	 */
    public void setManhuaName(String manhuaName) {
        this.manhuaName = manhuaName;
    }
    /**
	 * 获取：漫画编号
	 */
    public String getManhuaUuidNumber() {
        return manhuaUuidNumber;
    }


    /**
	 * 设置：漫画编号
	 */
    public void setManhuaUuidNumber(String manhuaUuidNumber) {
        this.manhuaUuidNumber = manhuaUuidNumber;
    }
    /**
	 * 获取：漫画照片
	 */
    public String getManhuaPhoto() {
        return manhuaPhoto;
    }


    /**
	 * 设置：漫画照片
	 */
    public void setManhuaPhoto(String manhuaPhoto) {
        this.manhuaPhoto = manhuaPhoto;
    }
    /**
	 * 获取：漫画类型
	 */
    public Integer getManhuaTypes() {
        return manhuaTypes;
    }


    /**
	 * 设置：漫画类型
	 */
    public void setManhuaTypes(Integer manhuaTypes) {
        this.manhuaTypes = manhuaTypes;
    }
    /**
	 * 获取：漫画热度
	 */
    public Integer getManhuaClicknum() {
        return manhuaClicknum;
    }


    /**
	 * 设置：漫画热度
	 */
    public void setManhuaClicknum(Integer manhuaClicknum) {
        this.manhuaClicknum = manhuaClicknum;
    }
    /**
	 * 获取：漫画介绍
	 */
    public String getManhuaContent() {
        return manhuaContent;
    }


    /**
	 * 设置：漫画介绍
	 */
    public void setManhuaContent(String manhuaContent) {
        this.manhuaContent = manhuaContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getManhuaDelete() {
        return manhuaDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setManhuaDelete(Integer manhuaDelete) {
        this.manhuaDelete = manhuaDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
