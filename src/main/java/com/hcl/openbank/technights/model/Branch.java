package com.hcl.openbank.technights.model;

import lombok.Data;

@Data
public class Branch {
    private String id;
    private String name;
    private Location location;
}
