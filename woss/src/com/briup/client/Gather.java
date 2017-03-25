package com.briup.client;

import java.util.Collection;

import com.briup.common.WossModule;
import com.briup.model.BIDR;
/**
 * Gather接口规定了采集模块所应有的方法。
 * 当Gather执行gather()方法时，开始对AAA服务器的计费信息进行采集。
 * 将采集的数据封装成为一个BIDR的集合返回。
 * @author briup
 * @version 1.0 2010-9-14
 */
public interface Gather extends WossModule{
	/**
	 * 采集AAA服务器的计费信息，将数据封装为BIDR集合返回。
	 * @return 采集封装BIDR数据的集合
	 */
	public Collection<BIDR> gather()throws Exception;
}
