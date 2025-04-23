
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 漫画
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/manhua")
public class ManhuaController {
    private static final Logger logger = LoggerFactory.getLogger(ManhuaController.class);

    @Autowired
    private ManhuaService manhuaService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("manhuaDeleteStart",1);params.put("manhuaDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = manhuaService.queryPage(params);

        //字典表数据转换
        List<ManhuaView> list =(List<ManhuaView>)page.getList();
        for(ManhuaView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ManhuaEntity manhua = manhuaService.selectById(id);
        if(manhua !=null){
            //entity转view
            ManhuaView view = new ManhuaView();
            BeanUtils.copyProperties( manhua , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(manhua.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ManhuaEntity manhua, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,manhua:{}",this.getClass().getName(),manhua.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            manhua.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ManhuaEntity> queryWrapper = new EntityWrapper<ManhuaEntity>()
            .eq("yonghu_id", manhua.getYonghuId())
            .eq("manhua_name", manhua.getManhuaName())
            .eq("manhua_uuid_number", manhua.getManhuaUuidNumber())
            .eq("manhua_types", manhua.getManhuaTypes())
            .eq("manhua_clicknum", manhua.getManhuaClicknum())
            .eq("shangxia_types", manhua.getShangxiaTypes())
            .eq("manhua_delete", manhua.getManhuaDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ManhuaEntity manhuaEntity = manhuaService.selectOne(queryWrapper);
        if(manhuaEntity==null){
            manhua.setManhuaClicknum(1);
            manhua.setShangxiaTypes(1);
            manhua.setManhuaDelete(1);
            manhua.setCreateTime(new Date());
            manhuaService.insert(manhua);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ManhuaEntity manhua, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,manhua:{}",this.getClass().getName(),manhua.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            manhua.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ManhuaEntity> queryWrapper = new EntityWrapper<ManhuaEntity>()
            .notIn("id",manhua.getId())
            .andNew()
            .eq("yonghu_id", manhua.getYonghuId())
            .eq("manhua_name", manhua.getManhuaName())
            .eq("manhua_uuid_number", manhua.getManhuaUuidNumber())
            .eq("manhua_types", manhua.getManhuaTypes())
            .eq("manhua_clicknum", manhua.getManhuaClicknum())
            .eq("shangxia_types", manhua.getShangxiaTypes())
            .eq("manhua_delete", manhua.getManhuaDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ManhuaEntity manhuaEntity = manhuaService.selectOne(queryWrapper);
        if("".equals(manhua.getManhuaPhoto()) || "null".equals(manhua.getManhuaPhoto())){
                manhua.setManhuaPhoto(null);
        }
        if(manhuaEntity==null){
            manhuaService.updateById(manhua);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<ManhuaEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ManhuaEntity manhuaEntity = new ManhuaEntity();
            manhuaEntity.setId(id);
            manhuaEntity.setManhuaDelete(2);
            list.add(manhuaEntity);
        }
        if(list != null && list.size() >0){
            manhuaService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ManhuaEntity> manhuaList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ManhuaEntity manhuaEntity = new ManhuaEntity();
//                            manhuaEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            manhuaEntity.setManhuaName(data.get(0));                    //漫画名称 要改的
//                            manhuaEntity.setManhuaUuidNumber(data.get(0));                    //漫画编号 要改的
//                            manhuaEntity.setManhuaPhoto("");//详情和图片
//                            manhuaEntity.setManhuaTypes(Integer.valueOf(data.get(0)));   //漫画类型 要改的
//                            manhuaEntity.setManhuaClicknum(Integer.valueOf(data.get(0)));   //漫画热度 要改的
//                            manhuaEntity.setManhuaContent("");//详情和图片
//                            manhuaEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            manhuaEntity.setManhuaDelete(1);//逻辑删除字段
//                            manhuaEntity.setCreateTime(date);//时间
                            manhuaList.add(manhuaEntity);


                            //把要查询是否重复的字段放入map中
                                //漫画编号
                                if(seachFields.containsKey("manhuaUuidNumber")){
                                    List<String> manhuaUuidNumber = seachFields.get("manhuaUuidNumber");
                                    manhuaUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> manhuaUuidNumber = new ArrayList<>();
                                    manhuaUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("manhuaUuidNumber",manhuaUuidNumber);
                                }
                        }

                        //查询是否重复
                         //漫画编号
                        List<ManhuaEntity> manhuaEntities_manhuaUuidNumber = manhuaService.selectList(new EntityWrapper<ManhuaEntity>().in("manhua_uuid_number", seachFields.get("manhuaUuidNumber")).eq("manhua_delete", 1));
                        if(manhuaEntities_manhuaUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ManhuaEntity s:manhuaEntities_manhuaUuidNumber){
                                repeatFields.add(s.getManhuaUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [漫画编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        manhuaService.insertBatch(manhuaList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = manhuaService.queryPage(params);

        //字典表数据转换
        List<ManhuaView> list =(List<ManhuaView>)page.getList();
        for(ManhuaView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ManhuaEntity manhua = manhuaService.selectById(id);
            if(manhua !=null){

                //点击数量加1
                manhua.setManhuaClicknum(manhua.getManhuaClicknum()+1);
                manhuaService.updateById(manhua);

                //entity转view
                ManhuaView view = new ManhuaView();
                BeanUtils.copyProperties( manhua , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(manhua.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ManhuaEntity manhua, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,manhua:{}",this.getClass().getName(),manhua.toString());
        Wrapper<ManhuaEntity> queryWrapper = new EntityWrapper<ManhuaEntity>()
            .eq("yonghu_id", manhua.getYonghuId())
            .eq("manhua_name", manhua.getManhuaName())
            .eq("manhua_uuid_number", manhua.getManhuaUuidNumber())
            .eq("manhua_types", manhua.getManhuaTypes())
            .eq("manhua_clicknum", manhua.getManhuaClicknum())
            .eq("shangxia_types", manhua.getShangxiaTypes())
            .eq("manhua_delete", manhua.getManhuaDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ManhuaEntity manhuaEntity = manhuaService.selectOne(queryWrapper);
        if(manhuaEntity==null){
            manhua.setManhuaDelete(1);
            manhua.setCreateTime(new Date());
        manhuaService.insert(manhua);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
