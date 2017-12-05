package group5;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
public class JavaSampleGetPersonName {
	 private static String jsonString;
	private static String name;

	public static String getPersonName (String id,String grpID) 
	    {
		 HttpClient httpclient = new DefaultHttpClient();

		 try
	        {
	            URIBuilder builder = new URIBuilder("https://westcentralus.api.cognitive.microsoft.com/face/v1.0/persongroups/"+grpID+"/persons/"+id+"");


	            URI uri = builder.build();
	            HttpGet request = new HttpGet(uri);
	            request.setHeader("Ocp-Apim-Subscription-Key", "9d0ad68bc4e04162af64b84f0158481b");

	            // Request body
	            StringEntity reqEntity = new StringEntity("");
	            request.setURI(uri);

	            HttpResponse response = httpclient.execute(request);
	            HttpEntity entity = response.getEntity();

	            if (entity != null) 
	            {
//	                System.out.println(EntityUtils.toString(entity));
	                jsonString=EntityUtils.toString(entity).trim();
	                System.out.println(jsonString);
	            }
	            
	            
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	        }
		return jsonString;
	    }
}
