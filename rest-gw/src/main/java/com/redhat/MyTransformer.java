/*
 * Copyright 2016 Red Hat, Inc.
 * <p>
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 *
 */
package com.redhat;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

/**
 * A sample transform
 */
@Component(value = "myTransformer")
public class MyTransformer {

    Logger log = Logger.getLogger(this.getClass().getName());



    Gson gson = new Gson();
    public void request(Exchange ex) {
        log.info("====================="+ex.getIn().getBody().toString());
        //Map<String, LinkedHashMap<String, LinkedHashMap>> map=(LinkedHashMap<String,LinkedHashMap<String, LinkedHashMap>>)ex.getIn().getBody();
        Map map=(Map)ex.getIn().getBody();
        log.info(""+map.get("ns:BusMsg"));
        String jsonString = gson.toJson(ex.getIn().getBody(), Map.class);
        JsonObject jo=gson.fromJson(jsonString, JsonObject.class);
        String docRef=jo.get("ns:BusMsg").getAsJsonObject().get("ns:AppHdr").getAsJsonObject().get("ns1:BizMsgIdr").getAsJsonObject().get("#text").getAsString();
        log.info("----"+ docRef);
        ex.getIn().setHeader("DOC_ID", docRef);
        log.info("OUTPUT"+jsonString);
        ex.getIn().setBody(jsonString);
        //log.info(""+map.get("ns:BusMsg"));
        //incoming is a json string
        //String json=ex.getIn().getBody().toString();

        //JsonObject jsonObject=gson.fromJson(json, JsonObject.class);
        //log.info("============================"+json);
        //log.info("============================"+jsonObject);
        //ex.getIn().setBody(jsonObject);
    }

    
}
