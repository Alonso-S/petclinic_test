# Guía de Instalación - Proyecto de Spring Boot con MySQL (XAMPP)

Este README te guiará para configurar y ejecutar el proyecto con MySQL usando **XAMPP**. Sigue los pasos y el proyecto debería funcionar sin problemas.

## Requisitos Previos

1. **Java JDK 17**  
   [Descargar JDK](https://adoptopenjdk.net/)

2. **Maven**  
   [Descargar Maven](https://maven.apache.org/download.cgi)

3. **XAMPP** (para MySQL y Apache)  
   [Descargar XAMPP](https://www.apachefriends.org/index.html)

4. **IDE de tu preferencia** (opcional)

---

## Pasos para la Instalación

### 1. Clonar el Repositorio

Clona el repositorio en tu máquina local:

```bash
git clone <link>
cd <directorio>

```
### 2. Configurar MySQL en XAMPP

1. Abre **XAMPP Control Panel** y asegúrate de que **Apache** y **MySQL** estén en ejecución. Haz clic en **Start** junto a **Apache** y **MySQL**.

2. Accede a **phpMyAdmin** a través de la URL [http://localhost/phpmyadmin](http://localhost/phpmyadmin).

3. Crea la base de datos `petclinic_db` desde phpMyAdmin:
    - En phpMyAdmin, selecciona "Bases de datos" en el menú superior.
    - En el campo **Nombre de la base de datos**, ingresa `petclinic_db` y haz clic en **Crear**.
    - Asegúrate de que la base de datos se haya creado correctamente.


### 3. Instalar Dependencias

Para asegurarte de que todas las dependencias del proyecto estén descargadas e instaladas correctamente, ejecuta el siguiente comando:

```bash
mvn clean install
```

### 4. Verificar la Conexión a la Base de Datos
Accede a phpMyAdmin (http://localhost/phpmyadmin) y verifica que las tablas estén en petclinic_db.
``` bash
USE petclinic_db;
SHOW TABLES;
```

### 5. Ejecutar los Tests

```
mvn test
```


