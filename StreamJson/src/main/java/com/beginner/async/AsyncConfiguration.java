package com.beginner.async;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

@Configuration
public class AsyncConfiguration {
    private final Logger log = LoggerFactory.getLogger(AsyncConfiguration.class);

    @Scheduled(fixedRate = 1000)
    public void work() {
        String PersonXML = "<Person>\n" +
                "    <name>Poppy</name>\n" +
                "    <city>9</city>\n" +
                "    <country>INDIA</country>\n" +
                "</Person>";

        XmlMapper xmlMapper = new XmlMapper();
        Person poppy = null;
        try {
            poppy = xmlMapper.readValue(PersonXML, Person.class);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(poppy);

            System.out.println("Json: " + json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
