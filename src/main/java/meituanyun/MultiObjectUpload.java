//package meituanyun;
//
///**
// * @Package Name : ${PACKAG_NAME}
// * @Author : 1766318593@qq.com
// * @Creation Date : 2018年06月01日下午8:12
// * @Function : todo
// */
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.*;
////import com.meituan.mss.s3test.AmazonS3ClientProvider;
//import junit.framework.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//        import java.io.RandomAccessFile;
//        import java.util.ArrayList;
//        import java.util.Date;
//        import java.util.List;
//
///**
// * Created by junechen on 15-6-29.
// */
//public class MultiObjectUpload {
//    private String bucketName = "msstestbucket";
//    private AmazonS3 s3client;
//    private String objectKey = "msstestobject";
//    private InputStream inputStream;
//    private ObjectMetadata metadata;
//    private String bigFileName = "/tmp/testbigfile";
//
//    @Before
//    public void setUp() throws IOException {
//        initS3ClientWithCredentials();
//        generateDistinctBucketName();
//        generateObjectName();
//
//    }
//
//
//    public void testDown() {
//        if (s3client.doesBucketExist(bucketName)) {
//            s3client.deleteBucket(bucketName);
//        }
//    }
//
//    private  void generateObjectName() {
//        objectKey =  objectKey.concat("v").concat(Long.toString(new Date().getTime()));
//    }
//
//
//
//
//    private void initS3ClientWithCredentials() throws IOException {
//        //s3client = AmazonS3ClientProvider.CreateAmazonS3ConnFromResource();
//    }
//
//    private void generateDistinctBucketName() {
//        Date now = new Date();
//        bucketName = bucketName.concat("v").concat(new Long(now.getTime()).toString());
//    }
//
//    private void generateBigFile(String filename) {
//        try {
//            RandomAccessFile f = new RandomAccessFile(bigFileName, "rw");
//            f.setLength(1024 * 1024 * 30);
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//
//    }
//
//    public void uploadmutipartObject(String existingBucketName, String keyName, AmazonS3 s3Client, String filePath ) {
//
//// Create a list of UploadPartResponse objects. You get one of these for
//// each part upload.
//        List<PartETag> partETags = new ArrayList<PartETag>();
//
//// Step 1: Initialize.
//        InitiateMultipartUploadRequest initRequest = new InitiateMultipartUploadRequest(
//                existingBucketName, keyName);
//        InitiateMultipartUploadResult initResponse =
//                s3Client.initiateMultipartUpload(initRequest);
//
//        File file = new File(filePath);
//        long contentLength = file.length();
//        long partSize = 5 * 1024 * 1024; // Set part size to 5 MB.
//
//        try {
//            // Step 2: Upload parts.
//            long filePosition = 0;
//
//            for (int i = 1; filePosition < contentLength; i++) {
//                // Last part can be less than 5 MB. Adjust part size.
//                partSize = Math.min(partSize, (contentLength - filePosition));
//
//                // Create request to upload a part.
//                UploadPartRequest uploadRequest = new UploadPartRequest()
//                        .withBucketName(existingBucketName).withKey(keyName)
//                        .withUploadId(initResponse.getUploadId()).withPartNumber(i)
//                        .withFileOffset(filePosition)
//                        .withFile(file)
//                        .withPartSize(partSize);
//
//                // Upload part and add response to our list.
//                partETags.add(s3Client.uploadPart(uploadRequest).getPartETag());
//
//                filePosition += partSize;
//            }
//
//            //test listparts，列出指定的keyName下已经上传了哪几个分片文件
//            // listpartsObject(existingBucketName, keyName, s3Client, initResponse.getUploadId());
//
//
//            //test abort, abort用于上传部分分片后想删除这次上传的所有分片，一般用于上传到一般出现异常后的处理逻辑
//            //s3Client.abortMultipartUpload(new AbortMultipartUploadRequest(
//            //        existingBucketName, keyName, initResponse.getUploadId()));
//
//            // Step 3: Complete.
//
//            CompleteMultipartUploadRequest compRequest = new
//                    CompleteMultipartUploadRequest(existingBucketName,
//                    keyName,
//                    initResponse.getUploadId(),
//                    partETags);
//
//            s3Client.completeMultipartUpload(compRequest);
//
//            List<S3ObjectSummary> objSum = s3client.listObjects(existingBucketName).getObjectSummaries();
//            Assert.assertEquals(1,objSum.size());
//            Assert.assertEquals(objSum.get(0).getKey(), keyName);
//
//        } catch (Exception e) {
//            s3Client.abortMultipartUpload(new AbortMultipartUploadRequest(
//                    existingBucketName, keyName, initResponse.getUploadId()));
//        }
//    }
//
//    @Test
//    public void testPutObject() {
//        generateBigFile(bigFileName);
//        System.out.println("test putobject");
//        Bucket bucket = s3client.createBucket(bucketName);
//        System.out.println("bucketName " + bucketName + " ,objectKey " + objectKey);
//        uploadmutipartObject(bucketName, objectKey, s3client, bigFileName);
//        //s3client.deleteObject(bucketName, objectKey);
//    }
//}