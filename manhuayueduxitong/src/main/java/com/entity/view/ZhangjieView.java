package com.entity.view;

import com.entity.ZhangjieEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 章节
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zhangjie")
public class ZhangjieView extends ZhangjieEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



		//级联表 manhua
			/**
			* 漫画 的 用户
			*/
			private Integer manhuaYonghuId;
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
				* 漫画类型的值
				*/
				private String manhuaValue;
			/**
			* 漫画热度
			*/
			private Integer manhuaClicknum;
			/**
			* 漫画介绍
			*/
			private String manhuaContent;

			/**
			* 逻辑删除
			*/
			private Integer manhuaDelete;

	public ZhangjieView() {

	}

	public ZhangjieView(ZhangjieEntity zhangjieEntity) {
		try {
			BeanUtils.copyProperties(this, zhangjieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}








				//级联表的get和set manhua

					/**
					* 获取：漫画 的 用户
					*/
					public Integer getManhuaYonghuId() {
						return manhuaYonghuId;
					}
					/**
					* 设置：漫画 的 用户
					*/
					public void setManhuaYonghuId(Integer manhuaYonghuId) {
						this.manhuaYonghuId = manhuaYonghuId;
					}


					/**
					* 获取： 漫画名称
					*/
					public String getManhuaName() {
						return manhuaName;
					}
					/**
					* 设置： 漫画名称
					*/
					public void setManhuaName(String manhuaName) {
						this.manhuaName = manhuaName;
					}

					/**
					* 获取： 漫画编号
					*/
					public String getManhuaUuidNumber() {
						return manhuaUuidNumber;
					}
					/**
					* 设置： 漫画编号
					*/
					public void setManhuaUuidNumber(String manhuaUuidNumber) {
						this.manhuaUuidNumber = manhuaUuidNumber;
					}

					/**
					* 获取： 漫画照片
					*/
					public String getManhuaPhoto() {
						return manhuaPhoto;
					}
					/**
					* 设置： 漫画照片
					*/
					public void setManhuaPhoto(String manhuaPhoto) {
						this.manhuaPhoto = manhuaPhoto;
					}

					/**
					* 获取： 漫画类型
					*/
					public Integer getManhuaTypes() {
						return manhuaTypes;
					}
					/**
					* 设置： 漫画类型
					*/
					public void setManhuaTypes(Integer manhuaTypes) {
						this.manhuaTypes = manhuaTypes;
					}


						/**
						* 获取： 漫画类型的值
						*/
						public String getManhuaValue() {
							return manhuaValue;
						}
						/**
						* 设置： 漫画类型的值
						*/
						public void setManhuaValue(String manhuaValue) {
							this.manhuaValue = manhuaValue;
						}

					/**
					* 获取： 漫画热度
					*/
					public Integer getManhuaClicknum() {
						return manhuaClicknum;
					}
					/**
					* 设置： 漫画热度
					*/
					public void setManhuaClicknum(Integer manhuaClicknum) {
						this.manhuaClicknum = manhuaClicknum;
					}

					/**
					* 获取： 漫画介绍
					*/
					public String getManhuaContent() {
						return manhuaContent;
					}
					/**
					* 设置： 漫画介绍
					*/
					public void setManhuaContent(String manhuaContent) {
						this.manhuaContent = manhuaContent;
					}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getManhuaDelete() {
						return manhuaDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setManhuaDelete(Integer manhuaDelete) {
						this.manhuaDelete = manhuaDelete;
					}












}
