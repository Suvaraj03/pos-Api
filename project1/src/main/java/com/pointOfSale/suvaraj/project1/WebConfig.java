package com.pointOfSale.suvaraj.project1;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to all paths
                .allowedOrigins("http://localhost:4200/")  // Angular app URL (adjust port as needed)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed methods
                .allowedHeaders("Content-Type", "Authorization") // Allow Authorization header
                .allowCredentials(true); // Allow cookies or credentials if necessary
    }
}
    /*
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // Replace with your frontend origin
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // HTTP methods
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type")); // Allowed headers
        config.setAllowCredentials(true); // Allow cookies or authentication credentials if needed

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Apply CORS configuration to all paths
       FilterRegistrationBean<CorsFilter> bean  = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(-102);
    		   return bean;
    }
    
    */
