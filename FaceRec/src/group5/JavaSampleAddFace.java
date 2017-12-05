package group5;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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


public class JavaSampleAddFace 
{
	private static String filename;
	private static JFileChooser chooser;
    public static void AddFace(String PersonGroup,String PersonID)
    {
        HttpClient httpclient = new DefaultHttpClient();
      //  String FaceID=null;
        try
        {
            URIBuilder builder = new URIBuilder("https://westcentralus.api.cognitive.microsoft.com/face/v1.0/persongroups/"+PersonGroup+"/persons/"+PersonID+"/persistedFaces");
            
            builder.setParameter("userData", "face1");
            //builder.setParameter("targetFace", "{string}");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/octet-stream");
            request.setHeader("Ocp-Apim-Subscription-Key", "9d0ad68bc4e04162af64b84f0158481b");

            chooser=new JFileChooser();
			FileNameExtensionFilter filer=new FileNameExtensionFilter("hinh anh", "jpg","tif","gif","png","bpm","jpeg");
			chooser.setFileFilter(filer);
			int retutnVal = chooser.showOpenDialog(null);
			if(retutnVal == JFileChooser.APPROVE_OPTION){
				filename=chooser.getSelectedFile().getAbsolutePath();
			}
            
            //664244c58efa40d8b8ac-ed0bf9c5c2f2
            // Request body
            FileInputStream fis=new FileInputStream(filename);
			InputStreamEntity reqEntity=new InputStreamEntity(fis,-1);

			request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) 
            {
                //FaceID=EntityUtils.toString(entity).trim().substring(20, 56);
                
            	System.out.println(EntityUtils.toString(entity));
                JOptionPane.showMessageDialog(null, "Add face success!");

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
