package br.com.caelum.fj91design.converters;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

@Configuration
public class LocalTimeConverter {

    static private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    @Configuration
    static class StringToLocalTime implements Converter<String, LocalTime>{

        @Override
        public LocalTime convert(String source) {
            TemporalAccessor parsed = formatter.parse(source);

            return LocalTime.from(parsed);
        }
    }


    @Configuration
    static class LocalTimeToString implements Converter<LocalTime, String>{

        @Override
        public String convert(LocalTime source) {
            return source.format(formatter);
        }
    }
}
