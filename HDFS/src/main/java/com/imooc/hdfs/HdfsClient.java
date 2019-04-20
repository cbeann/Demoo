package com.imooc.hdfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

public class HdfsClient {

	public static void main(String[] args) throws Exception {
		// 1 获取文件系统
		Configuration configuration = new Configuration();
		// 配置在集群上运行(
		// URL中的IP地址对应你图一中的IP
		// 代码中的"root"位置对应图二中箭头的指向
		FileSystem fs = FileSystem.get(new URI("hdfs://47.105.132.96:9000"), configuration, "root");

		// 2 创建目录
		fs.mkdirs(new Path("/20190309/CBeann"));

		// 3 关闭资源
		fs.close();
		System.out.println("--------over---------");
	}
	
	
	
	//IO流文件下载
	@Test
	public void getFileFromHDFS() throws IOException, InterruptedException, URISyntaxException{

		// 1 获取文件系统
		Configuration configuration = new Configuration();
		configuration.set("dfs.client.use.datanode.hostname", "true");
		configuration.set("fs.defaultFS", "hdfs://iZm5ea99qngm2v98asii1aZ:8020");
		FileSystem fs = FileSystem.get(new URI("hdfs://47.105.132.96:9000"), configuration, "root");
		// 2 获取输入流
		FSDataInputStream fis = fs.open(new Path("/hello.txt"));
			
		// 3 获取输出流
		FileOutputStream fos = new FileOutputStream(new File("e:/temp/helloworld.txt"));
			
		// 4 流的对拷
		IOUtils.copyBytes(fis, fos, configuration);
			
		// 5 关闭资源
		IOUtils.closeStream(fos);
		IOUtils.closeStream(fis);
		fs.close();
		
		System.out.println("over");
	}
	
	
	
	
	
	
	
	
	

	//IO流文件上传
	@Test
	public void putFileToHDFS() throws Exception {

		// 1 获取文件系统
		Configuration configuration = new Configuration();
		configuration.set("dfs.client.use.datanode.hostname", "true");
		configuration.set("fs.defaultFS", "hdfs://iZm5ea99qngm2v98asii1aZ:8020");
		FileSystem fs = FileSystem.get(new URI("hdfs://47.105.132.96:9000"), configuration, "root");

		// 2 创建输入流
		FileInputStream fis = new FileInputStream(new File("e:/temp/hello.txt"));

		// 3 获取输出流
		FSDataOutputStream fos = fs.create(new Path("/hello.txt"));

		// 4 流对拷
		IOUtils.copyBytes(fis, fos, configuration);

		// 5 关闭资源
		IOUtils.closeStream(fos);
		IOUtils.closeStream(fis);
	    fs.close();
	    
	    System.out.println("over");
	
	}
	
	
	
	

	// HDFS文件和文件夹判断
	@Test
	public void testListStatus() throws IOException, InterruptedException, URISyntaxException {

		// 1 获取文件配置信息
		Configuration configuration = new Configuration();
		configuration.set("dfs.client.use.datanode.hostname", "true");
		configuration.set("fs.defaultFS", "hdfs://iZm5ea99qngm2v98asii1aZ:8020");
		FileSystem fs = FileSystem.get(new URI("hdfs://47.105.132.96:9000"), configuration, "root");

		// 2 判断是文件还是文件夹
		FileStatus[] listStatus = fs.listStatus(new Path("/"));

		for (FileStatus fileStatus : listStatus) {

			// 如果是文件
			if (fileStatus.isFile()) {
				System.out.println("f:" + fileStatus.getPath().getName());
			} else {
				System.out.println("d:" + fileStatus.getPath().getName());
			}
		}

		// 3 关闭资源
		fs.close();
		System.out.println("----over----");
	}

	// 查看文件名称、权限、长度、块信息
	@Test
	public void listFiles() throws Exception {

		// 1获取文件系统
		Configuration configuration = new Configuration();
		configuration.set("dfs.client.use.datanode.hostname", "true");
		configuration.set("fs.defaultFS", "hdfs://iZm5ea99qngm2v98asii1aZ:8020");
		FileSystem fs = FileSystem.get(new URI("hdfs://47.105.132.96:9000"), configuration, "root");

		// 2 获取文件详情
		RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);

		while (listFiles.hasNext()) {
			LocatedFileStatus status = listFiles.next();

			// 输出详情
			// 文件名称
			System.out.println("文件名：" + status.getPath().getName());
			// 长度
			System.out.println("长度：" + status.getLen());
			// 权限
			System.out.println("权限：" + status.getPermission());
			// 分组
			System.out.println("分组：" + status.getGroup());

			// 获取存储的块信息
			BlockLocation[] blockLocations = status.getBlockLocations();
			System.out.println("获取存储的块信息:");
			for (BlockLocation blockLocation : blockLocations) {

				// 获取块存储的主机节点
				String[] hosts = blockLocation.getHosts();

				for (String host : hosts) {
					System.out.println(host);
				}
			}

			System.out.println("-----------分割线----------");
		}

		// 3 关闭资源
		fs.close();

		System.out.println("-----over-----");
	}

	// 修改文件名
	@Test
	public void rename() throws Exception {

		// 1 获取文件系统
		Configuration configuration = new Configuration();
		configuration.set("dfs.client.use.datanode.hostname", "true");
		configuration.set("fs.defaultFS", "hdfs://iZm5ea99qngm2v98asii1aZ:8020");
		FileSystem fs = FileSystem.get(new URI("hdfs://47.105.132.96:9000"), configuration, "root");

		// 2 修改文件名称
		fs.rename(new Path("/hello.txt"), new Path("/helloworld.txt"));

		// 3 关闭资源
		fs.close();
		System.out.println("-----------over--------------");
	}

	// 文件上传
	@Test
	public void copyFromLocalFile() throws Exception {
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

	// 文件下载
	@Test
	public void copyToLocalFile() throws Exception {
		// 1 获取文件系统
		Configuration configuration = new Configuration();
		configuration.set("dfs.client.use.datanode.hostname", "true");
		configuration.set("fs.defaultFS", "hdfs://iZm5ea99qngm2v98asii1aZ:8020");
		FileSystem fs = FileSystem.get(new URI("hdfs://47.105.132.96:9000"), configuration, "root");

		// 2 执行下载操作
		// boolean delSrc 指是否将原文件删除
		// Path src 指要下载的文件路径
		// Path dst 指将文件下载到的路径
		// boolean useRawLocalFileSystem 是否开启文件校验
		fs.copyToLocalFile(false, new Path("/hello.txt"), new Path("e:/temp/helloword.txt"), true);

		// 3 关闭资源
		fs.close();

		System.out.println("-----------over--------------");
	}

	// 文件删除
	@Test
	public void delete() throws Exception {
		// 1 获取文件系统
		Configuration configuration = new Configuration();
		configuration.set("dfs.client.use.datanode.hostname", "true");
		configuration.set("fs.defaultFS", "hdfs://iZm5ea99qngm2v98asii1aZ:8020");
		FileSystem fs = FileSystem.get(new URI("hdfs://47.105.132.96:9000"), configuration, "root");

		// 2 执行删除
		// Path 指要删除的文件路径
		// boolean 是否递归删除
		fs.delete(new Path("/hello.txt"), true);

		// 3 关闭资源
		fs.close();

		System.out.println("-----------over--------------");
	}

}
