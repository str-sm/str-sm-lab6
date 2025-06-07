# str-sm-lab6

## Exercițiul 1
Instalați Jamaica 3.0:
1. Download conținut director: https://drive.google.com/drive/folders/1RPnrCdbZAk2M9JTcZW9iB4gZvUSkWMn2?usp=drive_link
2. Urmați pașii de instalare din **README-Windows.txt** din directorul jamaica3.0
3. Pentru acest laborator se va folosi mediul de dezvoltare Eclipse. Dezarhivați eclipse-java-juno-SR2-win32-x86_64.zip
4. Dezarhivați OpenJDK8U-jdk_x64_windows_hotspot_8u412b08.zip și configurați Eclipse să folosească JDK-ul OpenJDK 8. Modifică eclipse.ini
5. Importați acest proiect în Eclipse:
   - File -> Import

## Exercițiul 2
Testați aplicații din pachetul `edu.tucn.str.exampleslecture6`.

## Exercițiul 3
Implementați o aplicație care să simuleze mecanismul *watchdog* prezent în cadrul unor sisteme de calcul (microcontrolere, PLC-uri etc.). 
Pe un fir de execuție se va simula un task care rulează la un interval de timp fix (de exemplu, 2 secunde) după care va reseta *watchdog*-ul.
Pentru watchdog se va folosi clasa *OneShotTimer* și pentru resetarea lui se va folosi metoda *reschedule()*.
După 5 rulări corecte se va simula o întârziere de 10 secunde, iar watchdog-ul va opri firul de execuție care rulează task-ul.

## Exercițiul 4
Implementați o aplicație RT Java care folosește *PeriodicTimer* pentru a face măsurători de la un senzor de temperatură simulat, la fiecare secundă, 
în total 20 de citiri: de fiecare dată când timer-ul se declanșează, handler-ul trebuie să obțină o valoare aleatoare de temperatură între 20 °C și 100 °C, 
să adauge un rând în fișierul *temperature.log* în formatul *Citire [n]: XX °C la <timestamp>* și, dacă temperatura depășește 75 °C, să afișeze imediat pe System.out mesajul 
*WARNING: Overheating detected la Citirea [n] (XX °C)*; după cele 20 de declanșări, timer-ul trebuie să se dezactiveze automat, iar aplicația să se încheie. 
Pentru dezactivarea time-rului se va folosi metoda *disable()*.

## Exercițiul 5
Implementați o aplicație RT Java care creează un RealtimeThread cu PeriodicParameters astfel încât să execute un task simplu de *heartbeat* la fiecare 500 ms: atunci când pornește, 
thread-ul ar trebui să ruleze exact 50 de perioade, iar în fiecare perioadă să citească un număr întreg aleatoriu între 1 și 100 (simulând, de exemplu, o valoare de la un senzor), 
să afișeze în System.out o linie de forma *Heartbeat [n]: value=<sensor> at <timestamp>*, și apoi să aștepte imediat următoarea perioadă. După ce completează 50 de perioade, 
thread-ul ar trebui să se încheie, iar aplicația să se oprească.

## Exercițiul 6
Implementați o aplicație RT Java care pornește două instanțe de *RealtimeThread* cu parametri periodici diferiți: Thread A trebui să ruleze la fiecare 500 ms pentru exact 40 de perioade și, 
de fiecare dată, să genereze o valoare aleatoare pentru un "senzor" (de exemplu, un număr întreg între 0 și 100) și să o stocheze într-o colecție thread-safe partajată; Thread B trebui să ruleze 
la fiecare 1 s pentru exact 20 de perioade și, de fiecare dată, să preia cea mai recentă valoare din acea colecție, să calculeze o medie simplă pentru ultimele două citiri și să afișeze în 
System.out o linie de forma: *Thread B [n]: avg_of_last_two = <value> at <timestamp>*
După ce Thread A își finalizează cele 40 de cicluri și Thread B cele 20 de cicluri, ambele thread-uri ar trebui să se încheie, iar programul să se închidă.