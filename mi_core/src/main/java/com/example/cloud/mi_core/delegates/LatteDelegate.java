package com.example.cloud.mi_core.delegates;

/**
 * Created by cloud on 2017/12/31.
 */

public abstract class LatteDelegate extends PermissionCheckerDelegate {

    @SuppressWarnings("unchecked")
    public <T extends LatteDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }

}
