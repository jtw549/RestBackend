package com.commerce.app.COMMERCE_Domain.repository;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Repository;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3Client;

@Repository
public class SuploadRepositoryImpl implements SuploadRepository{

	
	private static String bucketImageName     = "sthuf-images";
	private static String bucketVideoName     = "sthuf-videos";
	
	public String uploadMedia (String imageOrvideo,File file,String filename,long userid, long inventoryid) throws IOException {
        AmazonS3 s3client = new AmazonS3Client(new ProfileCredentialsProvider());
        try {
            System.out.println("Uploading a new object to S3 from a file\n");
            if("image".equals(imageOrvideo)) {
            s3client.putObject(new PutObjectRequest(
            		bucketImageName, userid+inventoryid+filename, file));
            }else {
            	  s3client.putObject(new PutObjectRequest(
            			  bucketVideoName, userid+inventoryid+filename, file));
            }

         } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
            		"means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
            		"means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
        return null;
    }
	
}
