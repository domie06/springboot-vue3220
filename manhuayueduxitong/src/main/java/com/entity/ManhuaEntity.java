package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 漫画
 *
 * @author 
 * @email
 */
@TableName("manhua")
public class ManhuaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ManhuaEntity() {

	}

	public ManhuaEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Manhua{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", manhuaName=" + manhuaName +
            ", manhuaUuidNumber=" + manhuaUuidNumber +
            ", manhuaPhoto=" + manhuaPhoto +
            ", manhuaTypes=" + manhuaTypes +
            ", manhuaClicknum=" + manhuaClicknum +
            ", manhuaContent=" + manhuaContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", manhuaDelete=" + manhuaDelete +
            ", createTime=" + createTime +
        "}";
    }
}
