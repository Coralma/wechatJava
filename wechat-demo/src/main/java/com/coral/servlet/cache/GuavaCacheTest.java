package com.coral.servlet.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by CCC on 2015/10/10.
 */
public class GuavaCacheTest {

    private static LoadingCache<String, String> graphs = CacheBuilder.newBuilder()
            .maximumSize(1)
            .refreshAfterWrite(1, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    String rt = UUID.randomUUID().toString();
                    return rt;
                }
            });

/*
    public static Cache<String, String> graphs = CacheBuilder.newBuilder()
            .expireAfterAccess(1, TimeUnit.SECONDS).maximumSize(10)
            .build();
*/

    public static void main(String[] args) throws Exception{
        System.out.println("return: " + load("1"));
        Thread.sleep(300);
        System.out.println("return: " + load("1"));
        Thread.sleep(300);
        System.out.println("return: " + load("1"));
        Thread.sleep(300);
        System.out.println("return: " + load("1"));
        Thread.sleep(300);
        System.out.println("return: " + load("1"));
        Thread.sleep(300);
        System.out.println("return: " + load("1"));
        Thread.sleep(300);
        System.out.println("return: " + load("1"));
        Thread.sleep(300);
        System.out.println("return: " + load("1"));
        Thread.sleep(300);
        System.out.println("return: " + load("1"));
        Thread.sleep(300);
        System.out.println("return: " + load("1"));
    }

    public static String load(String v) throws ExecutionException {
        return graphs.get(v);
        /*graphs.get(v, new Callable<String>() {
            @Override
            public String call() throws Exception {
                String rt = UUID.randomUUID().toString();
                System.out.println("get from: " + s + ", and return: " + rt);
                return rt;
            }
        });*/
    }
}
