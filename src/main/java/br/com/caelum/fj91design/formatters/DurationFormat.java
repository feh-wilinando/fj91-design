package br.com.caelum.fj91design.formatters;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.Duration;
import java.util.Locale;

@Configuration
public class DurationFormat implements Formatter<Duration> {

    @Override
    public Duration parse(String text, Locale locale) throws ParseException {
        long minutes = Long.parseLong(text);

        return Duration.ofMinutes(minutes);
    }

    @Override
    public String print(Duration object, Locale locale) {
        return String.valueOf(object.toMinutes());
    }
}
