package com.company.component.datasource.multi_datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * User: yaoliuqing
 * Time: 14-9-26 下午4:46
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

    //保证线程安全
    private static final ThreadLocal<String> dataSourceKey = new ThreadLocal<String>();

    private static final Map<String, String> packageDataSource = new HashMap<String, String>();

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }

    public static void usePackageDataSource(String pkgName) {
        dataSourceKey.set(packageDataSource.get(pkgName));
    }

    //实现AbstractRoutingDataSource的determineTargetDataSource
    protected Object determineCurrentLookupKey() {
        String dsName = dataSourceKey.get();
        //阅后即焚
        dataSourceKey.remove();
        return dsName;
    }

    public Map<String, String> getPackageDataSource() {
        return MultipleDataSource.packageDataSource;
    }

    public void setPackageDataSource(Map<String, String> packageDataSource) {
        MultipleDataSource.packageDataSource.putAll(packageDataSource);
    }

}
