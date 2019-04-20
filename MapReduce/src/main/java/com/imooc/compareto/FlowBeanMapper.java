package com.imooc.compareto;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FlowBeanMapper extends Mapper<LongWritable, Text, FlowBean, Text> {
	

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		 // 1 获取一行
		 String line = value.toString();
		 // 2 切割字段
		 String[] words = line.split("\t");
		 // 3 封装对象
		 Text v = new Text();
		 v.set(words[0]);//取出手机号码
		
		 // 取出上行流量和下行流量
		 long upFlow = Long.parseLong(words[1]);
		 long downFlow = Long.parseLong(words[2]);
		 long sumFlow=Long.parseLong(words[3]);
		
		 FlowBean k = new FlowBean(upFlow, downFlow);
		 // 4 写出
		 context.write(k, v);


	}

}
