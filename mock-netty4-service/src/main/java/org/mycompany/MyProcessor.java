package org.mycompany;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyProcessor implements Processor {

	Logger log=LoggerFactory.getLogger(this.getClass());
	@Override
	public void process(Exchange exchange) throws Exception {
		log.info("In headers:"+exchange.getIn().getHeaders());

		String path="src/main/resources/input/tcpip_response.xml";
		
	
//		exchange.getIn().setBody(file);

//		String text = exchange.getIn().getBody(String.class);
//		byte[] bytes = exchange.getIn().getBody(byte[].class);
		
		//InputStream is = exchange.getIn().getBody(InputStream.class);
		String xml = Files.lines(Paths.get(path)).collect(Collectors.joining("\n"));

		exchange.getIn().setBody(xml);
	}

}
