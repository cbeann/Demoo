package com.imooc.GroupingComparator;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class OrderBean implements WritableComparable<OrderBean> {

	private int order_id;
	private double price;

	@Override
	public void readFields(DataInput in) throws IOException {
		this.order_id = in.readInt();
		this.price = in.readDouble();

	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(order_id);
		out.writeDouble(price);

	}

	// 二次排序
	@Override
	public int compareTo(OrderBean o) {

		int result;
        //先按id升序，在按价格降序
		if (order_id > o.getOrder_id()) {
			result = 1;
		} else if (order_id < o.getOrder_id()) {
			result = -1;
		} else {
			// 价格倒序排序
			result = price > o.getPrice() ? -1 : 1;
		}

		return result;
	}

	public OrderBean() {
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return order_id + "\t" + price;
	}

}
