package cn.itlou.uploadfilebyfastdfs.core;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class FastDFSClient {

    static Logger logger = LoggerFactory.getLogger("FaFastDFSClient.class");

    public static String localFileName = "D:\\亚太决策引擎字段：三方数据字段_v1.03_20190520.xlsx";

    @Autowired
    TrackerClient trackerClient;

    @Autowired
    TrackerServer trackerServer;

    @Autowired
    StorageClient storageClient;

    @Autowired
    StorageServer storageServer;

    public void init() throws Exception {
        try{
            //加载配置文件
            ClientGlobal.initByProperties("fastdfs-client.properties");
            //创建tracker客户端
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            //定义Storage客户端
            storageClient = new StorageClient(trackerServer, storageServer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void uploadFile(){

        try {
            init();
            NameValuePair nameValuePair[] = new NameValuePair[]{
                    new NameValuePair("fileName", "testExcel.xlsx")
            };
            //执行上传
            String[] fileIds = storageClient.upload_file(localFileName, "xlsx", nameValuePair);

            logger.info("上传组名" + fileIds[0]);
            logger.info("上传路径" + fileIds[1]);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void downloadFile(){

        try {
            byte[] b = storageClient.download_file("group1", "M00/00/00/wKgAA10DV9KAajrOAACnN0_pBpY36.xlsx");
            String downFile = new String(b, "UTF-8");
            System.out.println(downFile);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
