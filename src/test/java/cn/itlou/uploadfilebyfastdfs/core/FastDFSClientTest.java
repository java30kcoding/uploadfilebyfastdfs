package cn.itlou.uploadfilebyfastdfs.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class FastDFSClientTest {

    @Test
    public void uploadFile() {

        FastDFSClient fastDFSClient = new FastDFSClient();
        fastDFSClient.uploadFile();

    }

    @Test
    public void downloadFile() {

        FastDFSClient fastDFSClient = new FastDFSClient();
        fastDFSClient.downloadFile();

    }

}