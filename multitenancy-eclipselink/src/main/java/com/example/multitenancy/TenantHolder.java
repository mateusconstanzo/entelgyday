package com.example.multitenancy;

public class TenantHolder {

    private static ThreadLocal<String> tenantHolder = new ThreadLocal<>();

    public static void setCurrentTenant(String tenant) {
        tenantHolder.set(tenant);
    }

    public static String getTenant() {

        if (tenantHolder.get() == null)  {
            return TenantEnum.DEFAULT.getValue();
        }

        return tenantHolder.get();
    }

    public static void clear() {
        tenantHolder.remove();
    }

}
