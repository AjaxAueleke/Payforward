package com.form.adminform.DateHandler;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateHandler extends StdDeserializer<Date> {
    public DateHandler() {
        this(null);
    }

    public DateHandler(Class<?> o) {
        super(o);
    }
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String date = jsonParser.getText();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            return sdf.parse(date);
        }
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
