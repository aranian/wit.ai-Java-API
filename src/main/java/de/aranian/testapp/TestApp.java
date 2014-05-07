/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.aranian.testapp;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 *
 * @author sl
 */
public class TestApp
{
  private static final String AUTH_TOKEN = "authToken";
  
  
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws Exception
  {
    File file = new File("config");
    Properties props = new Properties();
    if (file.createNewFile())
    {
      // First run
      props.setProperty(AUTH_TOKEN, "AUTH_TOKEN_HERE");
      final FileOutputStream out = new FileOutputStream(file);
      props.store(out, "Comment");
      out.close();
    }
    
    final FileInputStream in = new FileInputStream(file);
    props.load(in);
    final String authToken = props.getProperty(AUTH_TOKEN);
    System.out.println(authToken);
    in.close();
    
    if (args.length != 0)
    {
      final String message = args[0];

      if (message != null)
        sendGet(authToken, message);
    }
  }



  private static void sendGet(final String authToken, final String query)
  {
    try
    {
      String url = "https://api.wit.ai/message?q=";

      final String escapedQuery = query.replaceAll("\\s", "%20");

      URL obj = new URL(url + escapedQuery);
      HttpURLConnection con = (HttpURLConnection) obj.openConnection();

      //add request header
      con.setRequestProperty("Authorization", "Bearer " + authToken);
      con.setConnectTimeout(10000);

      int responseCode = con.getResponseCode();
      System.out.println("\nSending 'GET' request to URL : " + url + escapedQuery);
      System.out.println("Response Code : " + responseCode);

      try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())))
      {
        String inputLine;
        final StringBuilder builder = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
          builder.append(inputLine).append("\n");
        }

        System.out.println(builder.toString());

        Gson gson = new Gson();
        WitJsonResponse response = gson.fromJson(builder.toString(), WitJsonResponse.class);
        System.out.println("Suggested? " + response.getOutcome().getEntities().get("music_artist").isSuggested());
      }
    }
    catch (final MalformedURLException ex)
    {
      Logger.getLogger(TestApp.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (final IOException ex)
    {
      Logger.getLogger(TestApp.class.getName()).log(Level.SEVERE, null, ex);
    }
	}
}
