package com.demo.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class XmlToJson {

    public static void main(String[] args) {
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

            System.out.println("Json: " +json);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
