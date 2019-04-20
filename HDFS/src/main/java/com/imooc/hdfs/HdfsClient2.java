package com.imooc.hdfs;

import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HdfsClient2 {

	public static void main(String[] args) throws Exception {
		// 1 获取文件系统
				Configuration configuration = new Configuration();
				configuration.set("dfs.client.use.datanode.hostname", "true");
				configuration.set("fs.defaultFS", "hdfs://iZm5ea99qngm2v98asii1aZ:8020");
				FileSystem fs = FileSystem.get(new URI("hdfs://47.105.132.96:9000"), configuration, "root");
				// 2 上传文件 参数：原数据路径，目标路径
				fs.copyFromLocalFile(new Path("e:/temp/hello.txt"), new Path("/hello.txt"));

				// 3 关闭资源
				fs.close();
				System.out.println("over");
	}

}
