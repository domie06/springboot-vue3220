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
 * 章节
 *
 * @author 
 * @email
 */
@TableName("zhangjie")
public class ZhangjieEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhangjieEntity() {

	}

	public ZhangjieEntity(T t) {
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
     * 漫画
     */
    @TableField(value = "manhua_id")

    private Integer manhuaId;


    /**
     * 章节名称
     */
    @TableField(value = "zhangjie_name")

    private String zhangjieName;


    /**
     * 章节内容
     */
    @TableField(value = "zhangjie_content")

    private String zhangjieContent;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


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
	 * 设置：漫画
	 */
    public Integer getManhuaId() {
        return manhuaId;
    }
    /**
	 * 获取：漫画
	 */

    public void setManhuaId(Integer manhuaId) {
        this.manhuaId = manhuaId;
    }
    /**
	 * 设置：章节名称
	 */
    public String getZhangjieName() {
        return zhangjieName;
    }
    /**
	 * 获取：章节名称
	 */

    public void setZhangjieName(String zhangjieName) {
        this.zhangjieName = zhangjieName;
    }
    /**
	 * 设置：章节内容
	 */
    public String getZhangjieContent() {
        return zhangjieContent;
    }
    /**
	 * 获取：章节内容
	 */

    public void setZhangjieContent(String zhangjieContent) {
        this.zhangjieContent = zhangjieContent;
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
        return "Zhangjie{" +
            "id=" + id +
            ", manhuaId=" + manhuaId +
            ", zhangjieName=" + zhangjieName +
            ", zhangjieContent=" + zhangjieContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", createTime=" + createTime +
        "}";
    }
}
