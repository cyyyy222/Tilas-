package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.*;
import com.itheima.service.EmpLogService;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.constant.ConstantDescs.NULL;

@Service
@Slf4j
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;


    //重写page方法，在control中被调用
    @Override
    public PageResult<Emp> page(EmpQueryParam param){
        //设置分页参数 起始页码，每一页的大小
        PageHelper.startPage(param.getPage(),param.getPageSize());
        //查询，封装结果
        List<Emp> emplist=empMapper.list(param);
        //封装，强制转化成page类型
        Page<Emp> p=(Page<Emp>)emplist;
        return new PageResult<>(p.getTotal(),p.getResult());
        //第一个参数是total，第二个参数是数据列表

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(AddEmp empInfo) {

        try{
        //保存员工基本信息
        empInfo.setCreateTime(LocalDateTime.now());
        empInfo.setUpdateTime(LocalDateTime.now());
        empMapper.saveInfo(empInfo);

        //保存员工工作经历
        //需要遍历集合中的每一个元素，expr表的外键是emp_id,传入的信息中不包含emp——id,因此需要直接先给emp_id
        List<EmpExpr>exprList=empInfo.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr->{
                empExpr.setEmpId(empInfo.getId());
            });
            empExprMapper.saveExpr(exprList);
        }
        }finally {
            EmpLog empLog=new EmpLog(null,LocalDateTime.now(),empInfo.getName());
            empLogService.insertLog(empLog);
        }

    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer[] ids) {

        empMapper.deleteInfo(ids);


        empMapper.deleteExpr(ids);

    }

    @Override
    public AddEmp getEmp(Integer id){
        Emp empInfo=empMapper.getEmp(id);
        AddEmp info=new AddEmp();
        BeanUtils.copyProperties(empInfo, info); // 自动拷贝所有同名属性

        //  查询ExprList并赋值
        List<EmpExpr> exprList = empExprMapper.getEmpExpr(id);
        info.setExprList(exprList);
        return info;

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(AddEmp empInfo) {
        //修改基本信息
        empInfo.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmp(empInfo);

        //修改工作经历,先删除，在添加
        Integer[] empIds = new Integer[]{empInfo.getId()};
        empMapper.deleteExpr(empIds);//原来的形参是Integer数组类型的，因此现在也要封装成数组，直接new一个新的对象就好了
        //删除完毕之后新增
        //设置员工id号

        List<EmpExpr>exprList=empInfo.getExprList();//封装成集合
        //遍历每一段经历设置成empID,和前面的方法是一致的
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(empExpr->{
                empExpr.setEmpId(empInfo.getId());
            });
            empExprMapper.saveExpr(exprList);
        }

    }



    @Override
    public LogInfoData EmpLogIn(LogInfo info){
       LogInfoData data=empMapper.EmpLogIn(info);
       if(data==null){
           return null;
       }
       else {


           Map<String,Object> claims=new HashMap<>();//封装用户信息，传递，生成jwt令牌

           //将查询到的用户信息放入生成令牌
           claims.put("id",data.getId());
           claims.put("username",data.getUsername());

           String jwt=JwtUtils.generateJwt(claims);
           data.setToken(jwt);//传递给token
           log.info("登陆成功，员工信息为{}",data);
           return data;
       }
    }
}
