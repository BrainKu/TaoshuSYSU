package com.sysu.taosysu.content.cache;

public interface CacheManager<T> {
	public T get(String key);
	public void set(T content);
	public void isExist(T content);
}