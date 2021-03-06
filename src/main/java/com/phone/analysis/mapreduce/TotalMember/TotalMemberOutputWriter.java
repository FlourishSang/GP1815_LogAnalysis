package com.phone.analysis.mapreduce.TotalMember;

import com.phone.analysis.mapreduce.IoOutputWriter;
import com.phone.analysis.mapreduce.services.IDimension;
import com.phone.analysis.model.BasicDemension.TopLevelDimension;
import com.phone.analysis.model.key.StatsUserDimension;
import com.phone.analysis.model.value.OutputMapWritable;
import com.phone.analysis.model.value.StatsOutputValue;
import com.phone.common.GlobleConstants;
import com.phone.common.KpiType;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description 用户模块和浏览器模块下的新增用户的输出到表中的实现类
 * @author: 赵燕钦
 * @create: 2018-12-02 23:49:45
 **/
public class TotalMemberOutputWriter implements IoOutputWriter {
    @Override
    public void output(Configuration conf, TopLevelDimension key, StatsOutputValue statsOutputValue, PreparedStatement ps, IDimension iDimension) {
        try {
            //创建用于用户模块和浏览器模块map端和reduce端输出的key的对象
            StatsUserDimension k= (StatsUserDimension)key;
            OutputMapWritable value = (OutputMapWritable)statsOutputValue;
            //获取新增会员的值
            int newMember = ((IntWritable)(value.getValue().get(new IntWritable(1)))).get();
            int i = 0 ;
            //获取到时间维度和平台维度的id
            ps.setInt(++i,iDimension.getIDimensionImplByDimension(k.getStatsCommonDimension().getDt()));
            ps.setInt(++i,iDimension.getIDimensionImplByDimension(k.getStatsCommonDimension().getPl()));
            if(value.getKpi().equals(KpiType.BROWSER_NEW_MEMBER)){
                ps.setInt(++i,iDimension.getIDimensionImplByDimension(k.getBrowserDimension()));
            }
            //需要在runner类，在运行赋值的时候设置
            ps.setInt(++i,newMember);
            ps.setString(++i,conf.get(GlobleConstants.RUNNING_DATE));
            ps.setInt(++i,newMember);
            ps.addBatch();//添加到批处理中。
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
