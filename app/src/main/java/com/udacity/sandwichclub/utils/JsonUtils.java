package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject myobj= new JSONObject(json);
            String image=myobj.getString("image");
            String Mainname=myobj.getJSONObject("name").getString("mainName");
            JSONArray AlsoKnownAs=myobj.getJSONObject("name").getJSONArray("alsoKnownAs");
            String arr=AlsoKnownAs.toString();

            ArrayList<String>ala=new ArrayList<String>(AlsoKnownAs.length());
            for (int i=0;i<AlsoKnownAs.length();i++){
                ala.add(AlsoKnownAs.optString(i));

            }
            String placeOfOrigin=myobj.getString("placeOfOrigin");
            String Description=myobj.getString("description");
            JSONArray ingredient_json_aray=myobj.getJSONArray("ingredients");
            List<String> ingredients=new ArrayList<String>(ingredient_json_aray.length());
            for (int i=0;i<ingredient_json_aray.length();i++){
                ingredients.add(ingredient_json_aray.optString(i));
            }
            Sandwich mysandwich=new Sandwich(Mainname,ala,placeOfOrigin,Description,image,ingredients);
            return mysandwich;


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }
}
