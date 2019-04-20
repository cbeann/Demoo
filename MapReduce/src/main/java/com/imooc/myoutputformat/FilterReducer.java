package com.imooc.myoutputformat;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FilterReducer extends Reducer<Text, NullWritable, Text, NullWritable> {

	@Override
	protected void reduce(Text key, Iterable<NullWritable> values, Context context)
			throws IOException, InterruptedException {

		// 1 获取一行
		String line = key.toString();

		// 2 拼接
		line = line + "\r\n";

		// 3 设置key
		Text k=new Text();
		k.set(line);

		for (NullWritable nullWritable : values) {

			context.write(k, NullWritable.get());
		}

	}

}
