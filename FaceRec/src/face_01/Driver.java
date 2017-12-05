package face_01;

import java.io.FileInputStream;
import java.net.URI;
import java.util.Vector;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;


public class Driver
{
	public static final String subscriptionKey = "9d0ad68bc4e04162af64b84f0158481b";
	public static Image im;
	public static final String uriBase = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect";



	public  static Vector<Image> Process(String d){

		{ 

			Vector<Image> list = new Vector<>();
			HttpClient httpclient = new DefaultHttpClient();

			try
			{
				URIBuilder builder = new URIBuilder(uriBase);


				builder.setParameter("returnFaceId", "true");
				builder.setParameter("returnFaceAttributes", "age,gender,glasses,emotion");
				URI uri = builder.build();
				HttpPost request = new HttpPost(uri);


				request.setHeader("Content-Type", "application/octet-stream");
				request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

				FileInputStream fis=new FileInputStream(d);
				InputStreamEntity reqEntity=new InputStreamEntity(fis,-1);

				request.setEntity(reqEntity);

				HttpResponse response = httpclient.execute(request);
				HttpEntity entity = response.getEntity();
				if (entity != null)
				{

					String jsonString = EntityUtils.toString(entity).trim();
					JSONArray arr = new JSONArray(jsonString);
					for(int i = 0 ; i < arr.length() ; i ++) {

						JSONObject obj = (JSONObject)arr.get(i);
						im = new Image();

						im.setFaceId(obj.getString("faceId"));
						JSONObject objs = obj.getJSONObject("faceRectangle");
						im.setTop((objs.getInt("top")));
						im.setLeft((objs.getInt("left")));
						im.setWidth((objs.getInt("width")));
						im.setHeight((objs.getInt("height")));
						
						JSONObject obj2=obj.getJSONObject("faceAttributes");
						im.setAge(obj2.getInt("age"));
						im.setGender(obj2.getString("gender"));
						im.setGlasses(obj2.getString("glasses"));
		           	JSONObject obj3 = obj2.getJSONObject("emotion");
		           	im.setContempt(obj3.getDouble("contempt"));
		           	im.setSurprise(obj3.getDouble("surprise"));
		           	im.setHappiness(obj3.getDouble("happiness"));
		           	im.setNeutral(obj3.getDouble("neutral"));
		           	im.setSadness(obj3.getDouble("sadness"));
		           	im.setDisgust(obj3.getDouble("disgust"));
		           	im.setAnger(obj3.getDouble("anger"));
		           	im.setFaer(obj3.getDouble("fear"));
						list.add(im);

					}
					
					if (jsonString.charAt(0) == '[') {
						JSONArray jsonArray = new JSONArray(jsonString);
						System.out.println(jsonArray.toString(2));
					}
					else if (jsonString.charAt(0) == '{') {
						JSONObject jsonObject = new JSONObject(jsonString);
						System.out.println(jsonObject.toString(2));
					} else {
						System.out.println(jsonString);


					}

				}
			}

			catch (Exception e)
			{
				// System.out.println(e.getMessage());


			}
			return list;

		}
	}

}