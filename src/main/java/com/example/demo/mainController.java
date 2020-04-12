package com.example.demo;

import com.example.demo.Models.Item;
import com.example.demo.Models.ItemRepo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Array;
import java.util.*;

@Controller
public class mainController {
    @Autowired
    ItemRepo itemRepo;

    @RequestMapping(value="/push")
    public ModelAndView push(@RequestParam("name") String name,
                             @RequestParam("capital") String capital, @RequestParam("region") String region, @RequestParam("subregion") String subregion, @RequestParam("population") String population){
        ModelAndView mv = new ModelAndView("redirect:/");
        Item itemToPush;

        itemToPush = new Item();
        itemToPush.setId(UUID.randomUUID().toString());

        itemToPush.setName(name);
        itemToPush.setCapital(capital);
        itemToPush.setRegion(region);
        itemToPush.setSubregion(subregion);
        itemToPush.setPopulation(population);
        itemRepo.save(itemToPush);
        return mv;
    }

    @RequestMapping(value="/delete/{id}")
    public ModelAndView delete(@PathVariable("id") String id){
        ModelAndView mv = new ModelAndView("redirect:/");
        itemRepo.deleteById(id);
        return mv;
    }

    @RequestMapping("/")
    public ModelAndView doHome() throws Exception {
        ModelAndView mv = new ModelAndView("index");

        String name = "";
        String capital = "";
        String region = "";
        String subregion = "";
        String population = "";

        String apikey = "d2e53f7ab3msh7e54b874552627ep1861a1jsna3c0aa8a8a6a";

        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("57");
        list.add("93");
        list.add("358");
        list.add("355");
        list.add("213");
        list.add("1684");
        list.add("376");
        list.add("244");

            Random random = new Random();
            int index = random.nextInt(9);
            String param = list.get(index);

            URL url = new URL("https://restcountries-v1.p.rapidapi.com/callingcode/" +param);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("x-rapidapi-host", "restcountries-v1.p.rapidapi.com");
            connection.setRequestProperty("x-rapidapi-key", apikey);
            connection.connect();
            BufferedReader r = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                json.append(line);
            }

            JSONArray array = new JSONArray(json.toString());
            for (int i = 0; i<array.length(); i++){
                JSONObject obj = array.getJSONObject(i);
                name = obj.getString("name");
                capital = obj.getString("capital");
                region = obj.getString("region");
                subregion = obj.getString("subregion");
                population = String.valueOf(obj.getInt("population"));

                mv.addObject("name", name);
                mv.addObject("capital", capital);
                mv.addObject("region", region);
                mv.addObject("subregion", subregion);
                mv.addObject("population", population);
            }
        mv.addObject("itemList", itemRepo.findAll());

        return mv;
    }

}
