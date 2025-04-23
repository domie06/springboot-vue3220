package com.entity.vo;

import com.entity.ManhuaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 漫画
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("manhua")
public class ManhuaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 漫画名称
     */

    @TableField(value = "manhua_name")
    private String manhuaName;


    /**
     * 漫画编号
     */

    @TableField(value = "manhua_uuid_number")
    private String manhuaUuidNumber;


    /**
     * 漫画照片
     */

    @TableField(value = "manhua_photo")
    private String manhuaPhoto;


    /**
     * 漫画类型
     */

    @TableField(value = "manhua_types")
    private Integer manhuaTypes;


    /**
     * 漫画热度
     */

    @TableField(value = "manhua_clicknum")
    private Integer manhuaClicknum;


    /**
     * 漫画介绍
     */

    @TableField(value = "manhua_content")
    private String manhuaContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "manhua_delete")
    private Integer manhuaDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：漫画名称
	 */
    public String getManhuaName() {
        return manhuaName;
    }


    /**
	 * 获取：漫画名称
	 */

    public void setManhuaName(String manhuaName) {
        this.manhuaName = manhuaName;
    }
    /**
	 * 设置：漫画编号
	 */
    public String getManhuaUuidNumber() {
        return manhuaUuidNumber;
    }


    /**
	 * 获取：漫画编号
	 */

    public void setManhuaUuidNumber(String manhuaUuidNumber) {
        this.manhuaUuidNumber = manhuaUuidNumber;
    }
    /**
	 * 设置：漫画照片
	 */
    public String getManhuaPhoto() {
        return manhuaPhoto;
    }


    /**
	 * 获取：漫画照片
	 */

    public void setManhuaPhoto(String manhuaPhoto) {
        this.manhuaPhoto = manhuaPhoto;
    }
    /**
	 * 设置：漫画类型
	 */
    public Integer getManhuaTypes() {
        return manhuaTypes;
    }


    /**
	 * 获取：漫画类型
	 */

    public void setManhuaTypes(Integer manhuaTypes) {
        this.manhuaTypes = manhuaTypes;
    }
    /**
	 * 设置：漫画热度
	 */
    public Integer getManhuaClicknum() {
        return manhuaClicknum;
    }


    /**
	 * 获取：漫画热度
	 */

    public void setManhuaClicknum(Integer manhuaClicknum) {
        this.manhuaClicknum = manhuaClicknum;
    }
    /**
	 * 设置：漫画介绍
	 */
    public String getManhuaContent() {
        return manhuaContent;
    }


    /**
	 * 获取：漫画介绍
	 */

    public void setManhuaContent(String manhuaContent) {
        this.manhuaContent = manhuaContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getManhuaDelete() {
        return manhuaDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setManhuaDelete(Integer manhuaDelete) {
        this.manhuaDelete = manhuaDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
