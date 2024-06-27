package com.project.smartfit.util;

import java.util.Arrays;
import java.util.List;

public enum Role {

    ROLE_CUSTOMER(Arrays.asList(
            RolePermision.READ_INFORMATION_PROFILE,
            RolePermision.UPDATE_INFORMATION_PROFILE
    ));

    private List<RolePermision> permisions;

    Role(List<RolePermision> permisions) {
        this.permisions = permisions;
    }

    public List<RolePermision> getPermisions() {
        return permisions;
    }

    public void setPermisions(List<RolePermision> permisions) {
        this.permisions = permisions;
    }
}
