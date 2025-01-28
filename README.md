# Spring Students

## Opis

"Spring Students" to aplikacja napisana w języku Java z wykorzystaniem frameworka Spring, służąca do zarządzania danymi studentów. Aplikacja umożliwia wykonywanie operacji CRUD (tworzenie, odczyt, aktualizacja, usuwanie) na danych studentów przechowywanych w relacyjnej bazie danych.

## Wymagania

- Java 17
- Maven 3.8.1 lub nowszy
- Relacyjna baza danych (np. MySQL, PostgreSQL)

## Instalacja

1. Sklonuj repozytorium:

   ```bash
   git clone https://github.com/memqowsky/spring-students.git
   cd spring-students
   ```

2. Skonfiguruj połączenie z bazą danych w pliku `application.properties` lub `application.yml`, podając odpowiednie dane dostępowe.

3. Zbuduj projekt za pomocą Mavena:

   ```bash
   mvn clean install
   ```

## Uruchomienie

Po pomyślnym zbudowaniu projektu, uruchom aplikację za pomocą poniższego polecenia:

```bash
java -jar target/spring-students-0.0.1-SNAPSHOT.jar
```

Aplikacja będzie dostępna pod adresem `http://localhost:8080`.

## Użytkowanie

Aplikacja oferuje interfejs API REST do zarządzania danymi studentów. Możesz wykonywać operacje takie jak tworzenie nowego studenta, pobieranie listy studentów, aktualizacja danych studenta oraz usuwanie studenta.

## Wkład

Wszelkie uwagi, zgłoszenia błędów oraz propozycje usprawnień są mile widziane. Prosimy o otwieranie zgłoszeń (issues) lub tworzenie próśb o włączenie zmian (pull requests) w tym repozytorium.

## Licencja

Ten projekt jest licencjonowany na warunkach licencji MIT. Szczegółowe informacje znajdują się w pliku `LICENSE`.

