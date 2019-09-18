package com.redhat;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component(value = "myProcessor")
public class MyProcessor {

    Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());
    Gson gson = new Gson();
    public void saveDocumentId(Exchange ex) {
        log.info("======saveDocumentId");

        //incoming is a json string
        String json=(String)ex.getIn().getBody();

        //JsonObject jsonObject=gson.fromJson(json, JsonObject.class);
        log.info("============================"+json);
        Cache cache=Cache.getInstance();
        cache.put((String)ex.getIn().getHeader("DOC_ID"),(String)ex.getIn().getHeader("JMSCorrelationID"));

    }

    public void processMsg(Exchange ex) {

		String xml=(String)ex.getIn().getBody();
		//nope... but poc
		ex.getIn().setBody(xml.replace("<o>", "").replace("</o>", ""));

    }

    public void retrieveJMSId(Exchange ex) {
        Cache cache=Cache.getInstance();
        String jmsid=(String)cache.get((String)ex.getIn().getHeader("DOC_ID"));
        ex.getIn().setHeader("JMSCorrelationID",jmsid);

    }
}