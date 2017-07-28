package com.jay.immoral.client.utils;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.http.auth.MalformedChallengeException;
import org.lwjgl.opengl.Display;

import com.jay.immoral.client.Client;

/**
 * @author Jay
 */

public class HTMLReader {

	private static String clientBuild;

	public static List<String> whitelist = getWhitelist();

	public static List<String> getWhitelist() {
        List<String> ret = new ArrayList<>();
        try {
            URL url = new URL("http://www.teamtopkek.win/lambent/whitelist.html");
            URLConnection connection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while((line = in.readLine()) != null) {
                ret.add(line);
            };
            in.close();
        } catch (Exception e) {
            Logger.error("Failed to getWhitelist, WHAT THE FUCK", e);
        }
        return ret;
    }

	public static String checkVersion() {
		try {
			URL url = new URL("http://www.teamtopkek.win/lambent/version.html");
			URLConnection connection = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			StringBuilder a = new StringBuilder();
			String version;
			while ((version = in.readLine()) != null) {
				a.append(version);
				clientBuild = version;
				in.close();
		
				return a.toString();
			}
		} catch (IOException e) {
			Logger.error("Failed to read HTML Page.", e);
		}
		return clientBuild;
	}

}
