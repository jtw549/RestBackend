package com.sthuf.app.STHUF_Domain.repository;

import java.io.IOException;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;

@Repository
public class SdeleteRepositoryImpl implements SdeleteRepository{

		private static String bucketImageName     = "sthuf-images";
		private static String bucketVideoName     = "sthuf-videos";
	    
	public String deleteMedia (String imageOrvideo,String keyName) throws IOException{
		 AmazonS3 s3Client = new AmazonS3Client(new ProfileCredentialsProvider());
	        try {
	        	
	        	if("image".equals(imageOrvideo)) {
	                s3Client.deleteObject(new DeleteObjectRequest(bucketImageName, keyName));
	        	}else {
	        		s3Client.deleteObject(new DeleteObjectRequest(bucketVideoName, keyName));
	        	}
	            
	        } catch (AmazonServiceException ase) {
	            System.out.println("Caught an AmazonServiceException.");
	            System.out.println("Error Message:    " + ase.getMessage());
	            System.out.println("HTTP Status Code: " + ase.getStatusCode());
	            System.out.println("AWS Error Code:   " + ase.getErrorCode());
	            System.out.println("Error Type:       " + ase.getErrorType());
	            System.out.println("Request ID:       " + ase.getRequestId());
	        } catch (AmazonClientException ace) {
	            System.out.println("Caught an AmazonClientException.");
	            System.out.println("Error Message: " + ace.getMessage());
	        }
		
		return null;
	}
}
