package org.samsunjg.testui;

import lombok.Data;

@Data
public class UserResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private User[] data;
}
