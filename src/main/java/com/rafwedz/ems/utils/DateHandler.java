package com.rafwedz.ems.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;


public class DateHandler extends StdDeserializer {

    public DateHandler() {
        this(null);
    }

    public DateHandler(Class<?> clazz) {
        super(clazz);
    }

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String date = jsonParser.getText();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            ZoneId defaultZoneId = ZoneId.systemDefault();
            return sdf.parse(date).toInstant().atZone(defaultZoneId).toLocalDate();

        } catch (Exception e) {
            System.out.println("EXCEPTION!");
            return null;
        }
    }
}
