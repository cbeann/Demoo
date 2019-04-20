package com.imooc.keyvaluetext;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class KVTextReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	protected void reduce(Text key, java.lang.Iterable<IntWritable> values, Context context)
			throws java.io.IOException, InterruptedException {

		int sum = 0;

		for (IntWritable value : values) {

			sum++;

		}
		
		context.write(key, new IntWritable(sum));

	};

}
