package com.tomoya.apilog.picHentai;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: SpringBootDemo
 * @description: 用来爬取图片
 * @author: Tomoya
 * @create: 2020-01-14 22:39
 **/

@RestController("/getPics")
public class picUtil {

    private static final CloseableHttpClient httpclient = HttpClientBuilder.create().build();

//    @GetMapping("/hentai")
    @Test
    public void getHentaiPics() {
        URI uri = null;
        try {
            uri = new URIBuilder().setScheme("https").setHost("scrolller.com").setPath("/api/pics").build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        for (int count = 1; count < 10000; count ++) {
            StringEntity stringEntity = new StringEntity("[[1178,9," + count * 50 + ",50]]","utf-8");
            HttpPost httpPost = new HttpPost(uri);
            httpPost.setEntity(stringEntity);
            httpPost.addHeader(HttpHeaders.CONTENT_TYPE,"application/json");
            httpPost.addHeader(HttpHeaders.REFERER,"https://scrolller.com/r/hentai-pics");
            httpPost.addHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36");
            httpPost.addHeader(HttpHeaders.ACCEPT, "*/*");
            httpPost.addHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
            httpPost.addHeader(HttpHeaders.HOST, "scrolller.com");
            httpPost.addHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate");
            httpPost.addHeader(HttpHeaders.CONNECTION, "keep-alive");
            CloseableHttpResponse response = null;
            ArrayList<String> picNameList = new ArrayList<>();
            try {
                response = httpclient.execute(httpPost);
                String bodyString = EntityUtils.toString(response.getEntity());
                JSONArray picListJSONArray = JSON.parseArray(bodyString);
                JSONArray picList2 = picListJSONArray.getJSONArray(0);
                JSONArray picList3 = picList2.getJSONArray(3);
                for (int i = 0; i < 50; i++) {
                    String picName = picList3.getJSONArray(i).getJSONArray(3).getJSONArray(0).getJSONArray(1).getJSONArray(0).getJSONArray(0).getString(1);
                    picNameList.add(picName);
                    downloadPic(null, picName);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void downloadPic(String urlString, String picName) throws IOException {

        URL url = new URL("https://scrolller.com/media/" + picName);
        URLConnection uc = url.openConnection();
        InputStream inputStream = uc.getInputStream();
        FileOutputStream out = new FileOutputStream("F:\\picHentai\\" + picName + ".jpg");
        int j = 0;
        while ((j = inputStream.read()) != -1) {
            out.write(j);
        }
        inputStream.close();

    }
}
    
