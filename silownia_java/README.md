# Aplikacja JAVA, uruchomienie:
# 1. Stawiamy bazę danych, ja to zrobiłem za pomocą wamp server, z użyciem phpMyAdmin
#	1.1 Instalujecie wamp server
#	1.2 Uruchamiacie go (ikonka będzie w trayu)
#	1.3 Przechodzicie na stronę localhost
#	1.4 Uruchamiacie phpMyAdmin
#	1.5 Import -> Wybierz plik -> baza_danych.sql -> nazywacie ją "silownia_baza"
# 2. Pobieramy na dysk cały projekt (git push)
# 3. Eclipse -> File -> Import -> General -> Existing Project into Workspace
# 4. Uruchamiamy projekt na Tomcacie lub GlassFishu, to bez znaczenia, ale moim zdaniem Tomcat działa szybciej
# 5. Pobieramy Chrome i instalujecie "Advanced Rest Client", on pozwala na łatwe wysyłanie zapytań Restowych do serwera
# 6. Włączamy Advanced Rest Client i gdy chcemy testować:
# 	6.1 Logowanie, to w polu URL wpisujemy: http://localhost:8080/silownia_java/rest/login/dologin 
#	6.2 Rejestrowanie, to w polu URL wpisujemy: http://localhost:8080/silownia_java/rest/register/doregister
#	6.3 Po tym klikamy na tę strzałeczkę po lewej od pola URL
#	6.4 Klikamy "Form" i wypełniamy pola "key" (logowanie ma pola 'username', 'password' rejestrowanie ma pola 'email', 'username', 'password') i wypełniamy pola "value" wartościami jakie chcemy wpisać do bazy
#	6.5 Klikamy "Send"
# 7. Jeśli wpisaliśmy poprawne dane to pojawi się odpowiedź w JSONie:
#	{
#	tag: "login"
#	status: true
#	}
# 8. Po "zarejestrowaniu" nowego użytkownika, w aplikacji phpMyAdmin pojawi się nowy użytkownik w bazie.
#
# 9. Jeśli nie chcecie się bawić w testowanie przez tę aplikację to można pisać zapytania tego typu:  http://localhost:8080/silownia_java/rest/login/dologin?username=admin&password=admin i wywoływać je w przeglądarce, to zwróci taki tekst: {"tag":"login","status":true} 


