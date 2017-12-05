package group5;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.util.Vector;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
public class TrainGroup {
	 public static void Train(String GroupID)
	    {
		 HttpClient httpclient = new DefaultHttpClient();
	        try
	        {
	            URIBuilder builder = new URIBuilder("https://westcentralus.api.cognitive.microsoft.com/face/v1.0/persongroups/"+GroupID+"/train");


	            URI uri = builder.build();
	            HttpPost request = new HttpPost(uri);
	            request.setHeader("Ocp-Apim-Subscription-Key", "9d0ad68bc4e04162af64b84f0158481b");


	            // Request body
	            StringEntity reqEntity = new StringEntity("");
	            request.setEntity(reqEntity);

	            HttpResponse response = httpclient.execute(request);
	            HttpEntity entity = response.getEntity();

	            if (entity != null) 
	            {
	                System.out.println(EntityUtils.toString(entity));
	                System.out.println("train thanh cong!");
	            }
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
}
