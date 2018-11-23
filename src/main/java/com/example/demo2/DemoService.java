package com.example.demo2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.DataInput;
import java.io.IOException;

@Service
public class DemoService {

    public void sendEmail() throws UnirestException, IOException {

        HttpResponse<String> response1 = Unirest.get("http://10.96.197.163:8080/WorkFlowAPI/webresources/ndbws/getSessionToken")
                .asString();
        System.out.println(response1.getBody());
        ObjectMapper mapper = new ObjectMapper();
        ResponseModel responseModel = mapper.readValue(response1.getBody(),ResponseModel.class);
        System.out.println(responseModel);

        HttpResponse<String> response2 = Unirest.get("http://10.96.197.163:8080/WorkFlowAPI/webresources/ndbws/getCustomerDetails?mnemonic=V870111800")
                .header("sessionkey", responseModel.getSessionToken())
                .asString();
        System.out.println(response2.getBody());

        HttpResponse<String> response3 = Unirest.get("http://10.96.197.163:8080/WorkFlowAPI/webresources/ndbws/closeSession")
                .header("sessionkey", responseModel.getSessionToken())
                .asString();
        System.out.println(response3.getBody());
    }

    public void sendTemp() throws UnirestException, IOException {

        HttpResponse<String> response = Unirest.get("http://ndb.devops.arimac.xyz/api/ndb/Currency/search/LKR")
                .asString();
        System.out.println(response.getBody());

//        ResponseEntity<String> response =
//                new ResponseEntity(gson.toString(),
//                        new MultiValueMap(),
//                        HttpStatus.OK);
        ObjectMapper mapper = new ObjectMapper();
        ResponseModel2 responseModel = mapper.readValue(response.getBody(),ResponseModel2.class);

        System.out.println(responseModel.getCurrency_id());
        System.out.println(responseModel.getCurrency());



//        RestTemplate restTemplate = new RestTemplate();
//        String fooResourceUrl
//                = "http://ndb.devops.arimac.xyz/api/ndb/staffRoles";
//        Object response6 = restTemplate.getForObject(fooResourceUrl + null, Object.class);
//
//        System.out.println(response6);
////        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));



//        RestTemplate restTemplate = new RestTemplate();
//        String fooResourceUrl
//                = "http://ndb.devops.arimac.xyz/api/ndb/staffRoles";
//        String response
//                = restTemplate.getForObject(fooResourceUrl + null, String.class);
//        System.out.println(response);

    }
}
