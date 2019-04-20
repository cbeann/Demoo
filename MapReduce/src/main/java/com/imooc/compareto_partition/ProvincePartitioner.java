package com.imooc.compareto_partition;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

//泛型为map的输出类型，即reduce的输入类型
public class ProvincePartitioner extends Partitioner<FlowBean, Text> {

	@Override
	public int getPartition(FlowBean key, Text value, int numPartitions) {
		// 1 获取电话号码的前三位
		String preNum = value.toString().substring(0, 3);

		int partition = 4;

		// 2 判断是哪个省
		if ("136".equals(preNum)) {
			partition = 0;
		} else if ("137".equals(preNum)) {
			partition = 1;
		} else if ("138".equals(preNum)) {
			partition = 2;
		} else if ("139".equals(preNum)) {
			partition = 3;
		}

		return partition;

	}

}
