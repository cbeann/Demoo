package com.imooc.myoutputformat;

import java.io.IOException;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

public class FRecordWriter extends RecordWriter<Text, NullWritable> {
	FSDataOutputStream fosatguigu;
	FSDataOutputStream fosother;

	// 初始化方法
	public FRecordWriter(TaskAttemptContext job){

		try {
			// 1、获取文件系统
			FileSystem fs = FileSystem.get(job.getConfiguration());
			fosatguigu = fs.create(new Path("e:/atguigu.log"));
			// 2、创建两个文件输出流
			fosother = fs.create(new Path("e:/other.log"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 业务逻辑类
	@Override
	public void write(Text key, NullWritable value) throws IOException, InterruptedException {
		try {
			// 判断是否包含“atguigu”输出到不同文件
			if (key.toString().contains("atguigu")) {
				fosatguigu.write(key.toString().getBytes());
			} else {
				fosother.write(key.toString().getBytes());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// close方法
	@Override
	public void close(TaskAttemptContext context) throws IOException, InterruptedException {
		// 关闭流
		IOUtils.closeStream(fosatguigu);
		IOUtils.closeStream(fosother);

	}

}
