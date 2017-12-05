package group5;
import java.net.URI;

import javax.swing.JOptionPane;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class CreatePersonGroup {
	
	public static void CreatePresonGroup(String NameGroup,String usedata)
    {
		HttpClient httpclient = new DefaultHttpClient();
		
        try
        {
        	
            URIBuilder builder = new URIBuilder("https://westcentralus.api.cognitive.microsoft.com/face/v1.0/persongroups/"+NameGroup);


            URI uri = builder.build();
            HttpPut request = new HttpPut(uri);
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "9d0ad68bc4e04162af64b84f0158481b");


            // Request body
            JSONObject json=new JSONObject();
            json.put("name",NameGroup);
            json.put("userData",usedata);
            StringEntity reqEntity = new StringEntity(json.toString());
            request.setEntity(reqEntity);
            
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) 
            {
                System.out.println(EntityUtils.toString(entity));
                JOptionPane.showMessageDialog(null, "Create Person group successful!");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
	
    }
}
