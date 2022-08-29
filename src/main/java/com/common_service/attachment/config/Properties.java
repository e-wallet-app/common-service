package com.common_service.attachment.config;

public class Properties
{
    public static final int MAX_UPLOAD_SIZE = (1 * 1024 * 1024) * 50; // 1MB * 50 = 50 MB

    public static final String WRITE_PATH = System.getProperty("user.home") + "/Documents/ewallet/";

    public static final String Attachment_FOLDER= "attachment/";
    public static final String NID_CARD_FOLDER= "nid_card/";
}
