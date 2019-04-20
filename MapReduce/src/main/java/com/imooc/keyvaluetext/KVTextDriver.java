package com.imooc.keyvaluetext;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.KeyValueLineRecordReader;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class KVTextDriver {
	public static void main(String[] args) throws Exception {
		// 输入路径（处理E:\temp\input下的***文件）
		String inputPath = "E:\\temp\\input";
		// 输出路径（output文件夹不能存在，否则报错）
		String outputPath = "E:\\temp\\output";

		Configuration conf = new Configuration();
		// 设置切割符(KeyValueInputFormat重点配置)(KeyValueInputFormat重点配置)(KeyValueInputFormat重点配置)
		conf.set(KeyValueLineRecordReader.KEY_VALUE_SEPERATOR, " ");

		// 1 获取Job对象
		Job job = Job.getInstance(conf);

		// 2 设置jar存储位置
		job.setJarByClass(KVTextDriver.class);

		// 3 关联Map和Reduce类
		job.setMapperClass(KVTextMapper.class);
		job.setReducerClass(KVTextReducer.class);

		// 4 设置Mapper阶段输出数据的key和value类型
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		// 5 设置最终(reducer)数据输出的key和value类型
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		// 设置输入格式(KeyValueInputFormat重点配置)(KeyValueInputFormat重点配置)(KeyValueInputFormat重点配置)
		job.setInputFormatClass(KeyValueTextInputFormat.class);

		// 6 设置输入路径和输出路径
		FileInputFormat.setInputPaths(job, new Path(inputPath));

		FileOutputFormat.setOutputPath(job, new Path(outputPath));

		// 7 提交job
		// job.submit();
		job.waitForCompletion(true);

		System.out.println("-------OVER-----------");
	}

}
