package com.billkang.springstudy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author binkang
 * @date May 1, 2017
 */
public class SimpleThreadLocal<T> {
	private Map<Thread, T> map = Collections.synchronizedMap(new HashMap<Thread, T>()); 
	
	public void set(T value) {
		map.put(Thread.currentThread(), value);
	}
	
	public T get() {
		Thread currentThread = Thread.currentThread();
		T o = map.get(currentThread);
		if(o==null && !map.containsKey(currentThread)) {
			o = initialVlaue();
			map.put(currentThread, o);
		}
		return o;
	}

	public T initialVlaue(){
		return null;
	}
	
	public void remove(){
		map.remove(Thread.currentThread());
	}
}