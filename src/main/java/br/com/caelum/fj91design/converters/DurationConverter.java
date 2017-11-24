package br.com.caelum.fj91design.converters;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.time.Duration;

@Configuration
public class DurationConverter {

    @Configuration
    public static class DurationToLong implements Converter<Duration, Long>{

        @Override
        public Long convert(Duration source) {
            return source.toMinutes();
        }
    }


    @Configuration
    public static class LongToDuration implements Converter<Long, Duration>{

        @Override
        public Duration convert(Long source) {
            return Duration.ofMinutes(source);
        }
    }

}
