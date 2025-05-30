Here's the cleaned-up and properly formatted `README.md` ready to copy into your project:

```markdown
# WeatherApp

WeatherApp is a simple Spring Boot web application that fetches weather data from OpenWeatherMap and provides clothing advice based on the weather.

## Setup Instructions

1. Generate a Spring Boot project from https://start.spring.io with the following:
   - Group: `com.example`
   - Artifact: `weatherApp`
   - Dependencies:
     - Spring Web
     - Thymeleaf
     - Spring Boot DevTools

2. Create the following Java package structure under `src/main/java/com/example/weatherApp`:
```

controller/WeatherController.java
service/WeatherService.java
model/WeatherResponse.java

```

3. Add an HTML file `index.html` in:
```

src/main/resources/templates/

```

4. Add configuration in `src/main/resources/application.properties`:
```

spring.application.name=weatherApp
weather.api.key=YOUR\_API\_KEY\_HERE

```
Replace `YOUR_API_KEY_HERE` with your OpenWeatherMap API key.

5. Run the application:
```

mvn spring-boot\:run

```

6. Open the application in your browser:
```

[http://localhost:8080](http://localhost:8080)

```

## Notes

- Add `application.properties` to `.gitignore` to avoid exposing your API key.
- You must register at https://openweathermap.org/api to get an API key.

## Author

Onduso Ombati - https://github.com/ondusoombati
```
