package com.imooc.flowsum;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FlowBeanMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
	

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		 // 1 获取一行
		 String line = value.toString();
		 // 2 切割字段
		 String[] words = line.split("\t");
		 // 3 封装对象
		 Text k = new Text();
		 k.set(words[1]);//取出手机号码
		
		 // 取出上行流量和下行流量
		 long upFlow = Long.parseLong(words[words.length - 3]);
		 long downFlow = Long.parseLong(words[words.length - 2]);
		
		 FlowBean v = new FlowBean(upFlow, downFlow);
		 System.out.println("map输出的参数："+v);
		 // 4 写出
		 context.write(k, v);


	}

}
