## zadanie rekrutacyjne

## przygotowanie

aplikacja tworzona była przy wykorzystaniu serwera wildfly, jta-data-source jest ustawiony na domyślny dla wildfly. 
Jeśli używamy innego serwera musimy skonfigurować połączenie z bazą danych w persistence.xml, jeśli chcemy używać innego datasourc'a z wildfly to wystarczy zmienić jta-data-source na inny

## endpointy
adres aplikacji: [serwer,port]/recruitmentTask-1.0-SNAPSHOT/api

### metody POST
/url - przyjmuje obiekt typu json z polem "url", dodaje do bazy danych nowy rekord z url i dodaje url do kolejki pobierania

/url/list - przyjmuje listę obiektów jak wyżej

### metody GET
/url/all - zwraca wszystkie url z bazy danych

/url/{id} - zwraca url o podanym id

/url/downloading - zwraca url'e z kolejki pobierania 

## pobieranie zasobów
zasoby pobierane są pojedynczo, w kolejności dodania.

Jeśli pobieranie wszystkich zasobów nie zostanie dokończone przed wyłączeniem serwera, zostanie wznowione po uruchomieniu 

