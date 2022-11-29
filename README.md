## SOFKA TALLER CRUD SQL springboot 

## Descripción:
En este proyecto encontraras una agenda de contactos desarrollada en java spring boot el 
backend y su cliente en javascript.


## Configuración spring boot:

Aquí tendrás que configurar en la carpeta resourse src/main/resources/application.properties
* El usuario y contraseña para el servidor donde esta la BD.
* el nombre de la BD en el link de conexión.

<pre>

# Configuración para MySQL 8
spring.datasource.url=jdbc:mysql://localhost/agendaTel?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrival=true --AQUI--
			--Remplaza la palabra agendaTel por el nombre de tu BD--

# Usuario de base de datos
spring.datasource.username=root. --AQUI--

# Contraseña para usuario de base de datos
spring.datasource.password=123456789 --AQUI--
</pre>

## Configuración politicas CORS:

En este paso tendrás que cambiar el link desde donde estas consumiendo el servicio REST
el archivo esta en src/main/java/com/sofka/AgendaTel .

<pre>

@Bean
        public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:5500").allowedMethods("*").allowedHeaders("*");  --AQUI--
			}                                -- CAMBIA LA URL POR LA URL DE TU CLIENTE --
		};
	   }
     
</pre>

## contribuidor:
* Michael Arango Nieto - michaelarango0531@gmail.com

