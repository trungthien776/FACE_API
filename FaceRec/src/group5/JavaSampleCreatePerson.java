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
public class JavaSampleCreatePerson {
	private static String jsonString;
	public static String CreatePerson(String NameGroup,String NamePerson,String usedata)
    {
		HttpClient httpclient = new DefaultHttpClient();
		 String PersonID = null;
        try
        {
            URIBuilder builder = new URIBuilder("https://westcentralus.api.cognitive.microsoft.com/face/v1.0/persongroups/"+NameGroup+"/persons");


            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "9d0ad68bc4e04162af64b84f0158481b");


            // Request body
            JSONObject json=new JSONObject();
            json.put("name",NamePerson);
            json.put("userData",usedata);
            
            StringEntity reqEntity = new StringEntity(json.toString());
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
           
            if (entity != null) 
            {
            	jsonString=EntityUtils.toString(entity).trim();
                System.out.println(EntityUtils.toString(entity));
                
//                PersonID= jsonString.substring(13, 49);
              //  return PersonID;
                System.out.println(PersonID);
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
		return jsonString.substring(13, 49);
		
    }
	
}
