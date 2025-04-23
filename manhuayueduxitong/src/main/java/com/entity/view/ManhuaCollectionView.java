package com.entity.view;

import com.entity.ManhuaCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 漫画收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("manhua_collection")
public class ManhuaCollectionView extends ManhuaCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String manhuaCollectionValue;



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
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer manhuaDelete;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;

	public ManhuaCollectionView() {

	}

	public ManhuaCollectionView(ManhuaCollectionEntity manhuaCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, manhuaCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getManhuaCollectionValue() {
				return manhuaCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setManhuaCollectionValue(String manhuaCollectionValue) {
				this.manhuaCollectionValue = manhuaCollectionValue;
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
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
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










				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}









}
