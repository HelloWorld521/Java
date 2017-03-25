package com.briup.server;

import java.util.Collection;

import com.briup.common.WossModule;
import com.briup.model.BIDR;
/**
 * DBStore提供了入库模块的规范。
 * 该接口的实现类将BIDR集合持久化。
 * @author briup
 * @version 1.0 2010-9-14
 */
public interface DBStore  extends WossModule{
	/**
	 * 将BIDR集合进行持久化 。
	 * @param collection 需要储存的BIDR集合
	 */
    public void saveToDB(Collection<BIDR> collection)throws Exception;
}