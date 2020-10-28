package com.example.test1.Protocol;

import lombok.Data;

@Data
public class AttachmentProtocol {
    private String storedPath;
    private String originalName;
    public AttachmentProtocol (String storedPath, String originalName) {
        this.storedPath = storedPath;
        this.originalName = originalName;
    }
}