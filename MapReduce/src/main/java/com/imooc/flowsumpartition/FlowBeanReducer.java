package com.imooc.flowsumpartition;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FlowBeanReducer extends Reducer<Text, FlowBean, Text, FlowBean> {

	@Override
	protected void reduce(Text key, Iterable<FlowBean> values, Context context)
			throws IOException, InterruptedException {

		long sum_up = 0;
		long sum_dowm = 0;

		for (FlowBean flowBean : values) {
			System.out.println("reduce输入的参数："+flowBean);
			sum_up += flowBean.getUpFlow();
			sum_dowm += flowBean.getDownFlow();

		}

		FlowBean temp = new FlowBean(sum_up, sum_dowm);
		System.out.println("reduce输出的参数："+temp);
		context.write(key, temp);
	}

}
