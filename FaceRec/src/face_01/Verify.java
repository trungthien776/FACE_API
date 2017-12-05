package face_01;

import java.io.FileInputStream;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class Verify {
public static final String subscriptionKey = "e0d5af1753eb4c92b733b144a76b10b2";
	
	public static final String uriBase_detect = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect";
	
	public static final String uriBase_verify = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/verify";
	private static String jsonStringNew;
	private static String jsonStringNew2;

	private static HttpEntity entity2;

	private static String value;
	public static String Verify_request(String f1,String f2) {
		
		// request 1---------------------------------------------------------------------------------------
		HttpClient httpclient=new DefaultHttpClient();
		try {
			URIBuilder buid=new URIBuilder(uriBase_detect);
			 buid.setParameter("returnFaceId", "true");
	         buid.setParameter("returnFaceLandmarks", "false");
	         buid.setParameter("returnfaceRectangle", "false");
			URI uri1=buid.build();
			
			HttpPost postItem=new HttpPost(uri1);
			
			postItem.setHeader("Content-Type", "application/octet-stream");
			postItem.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);
			
			
			/// BODY DETECT
			FileInputStream fis=new FileInputStream(f1);
			InputStreamEntity reqEntity=new InputStreamEntity(fis,-1);
			
			postItem.setEntity(reqEntity);
			HttpResponse res=httpclient.execute(postItem);
			HttpEntity kq=res.getEntity();
			if(kq!=null){
				System.out.println("ket qua");
				 String jsonString = EntityUtils.toString(kq).trim();
				 System.out.println(jsonString.toString());
				 jsonStringNew=(String) jsonString.subSequence(12, 48);
			}
			//request2-----------------------------------------------------------------------------------------------
				//POSTITEM2
			HttpPost postItem2=new HttpPost(uri1);
			postItem2.setHeader("Content-Type", "application/octet-stream");
			postItem2.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);
				//BODY ITEM2
			FileInputStream fis2=new FileInputStream(f2);
			InputStreamEntity reqEntity2=new InputStreamEntity(fis2,-1);
			
			postItem2.setEntity(reqEntity2);
			HttpResponse res2=httpclient.execute(postItem2);
			HttpEntity kq2=res2.getEntity();
			if(kq2!=null){
				System.out.println("ket qua");
				 String jsonString = EntityUtils.toString(kq2).trim();
				 System.out.println(jsonString.toString());
				 jsonStringNew2=(String) jsonString.subSequence(12, 48);
			}
			
			
			
		} catch (Exception e) {
		}
		//Verify 2 request------------------------------------------------------------------------------------------
		try {
			URIBuilder builderVerify = new URIBuilder(uriBase_verify);
			builderVerify.setParameter("returnFaceId", "true");
			builderVerify.setParameter("returnFaceLandmarks", "false");
			URI uriVerify = builderVerify.build();
            HttpPost requesVerify = new HttpPost(uriVerify);
            requesVerify.setHeader("Content-Type", "application/json");
            requesVerify.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);
            // tao json Object luu "faceId1":"id"
            JSONObject json=new JSONObject();
            json.put("faceId1",jsonStringNew);
            json.put("faceId2",jsonStringNew2);
            StringEntity reqEntityVf=new StringEntity(json.toString());
            requesVerify.setEntity(reqEntityVf);
            
            HttpResponse response = httpclient.execute(requesVerify);
            entity2 = response.getEntity();
            if (entity2 != null)
            {
                // Format and display the JSON response.
                System.out.println("REST Response:\n");
                
                value= EntityUtils.toString(entity2);
             
            }
		} catch (Exception e) {
		}
		return value;
	}
}
