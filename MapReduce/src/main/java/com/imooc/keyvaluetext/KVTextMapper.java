package com.imooc.keyvaluetext;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class KVTextMapper extends Mapper<Text, Text, Text, IntWritable> {

	protected void map(Text key, Text value, Context context) throws java.io.IOException, InterruptedException {

		IntWritable v = new IntWritable(1);

		context.write(key, v);

	};

}
