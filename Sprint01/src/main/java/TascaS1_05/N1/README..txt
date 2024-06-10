Tasca 1 nivel 1:
***Símbolo de sistemas

Ejercicio 1, 2 y 3:

1. Abre el menú de inicio de Windows y busca "Símbolo del sistema" y ejecutalo en modo administrador.
2. Ahora necesitas encontrar la carpeta donde guardaste tus archivos de código del ejercicio 1.
3. Una vez que encuentres la carpeta, entra en ella y dale click al ratón al botón derecho dentro de la carpeta
(no en el archivo) y pones abrir con terminal. o en el terminal que has ejecutado como administador añade este comando:
--> cd C:\Users\crist\IdeaProjects\Sprint01\src\main\java\TascaS1_05\N1\n1exercici1CristinaTomas

4. llegados a este punto hay que complilar el archivo es por ello que escribiremos este comando:
--> javac .\ListasDir.java

5. Ahora escribe el siguiemte comando  + la ruta del directorio que quieres listar, pero antes haria un list para poder
ver los archivos que se han creado, el ListasDir.class es el archivo que hemos creado y el listasDir.java el compilado.
--> java .\ListasDir.java C:\Users\crist\Documents\Curso Python

Ejercicio 4:

1. Abre la terminal de Windows.
2. Navega hasta el directorio donde se encuentra el archivo .java del ejercicio 4.
--> cd C:\Users\crist\IdeaProjects\Sprint01\src\main\java\TascaS1_05\N1\n1exercici4CristinaTomas
3. Compila el archivo .java usando el comando javac:
--> javac Llegir.java
4. Ejecuta el programa proporcionando la ruta del archivo TXT como argumento:
-->java Llegir.java "countries.txt"

Ejercicio 5:
1. Abre la terminal de Windows.
2. Navega hasta el directorio donde se encuentra el archivo .java del ejercicio 5.
--> cd C:\Users\crist\IdeaProjects\Sprint01\src\main\java
3. Compila el archivo .java usando el comando javac:
--> javac TascaS1_05/N1/n1exercici5CristinaTomas/*.java
4. Ejecuta el programa proporcionando dos argumentos: el nombre del objeto y el nombre del archivo donde se serializará el objeto:
-->java TascaS1_05.N1.n1exercici5CristinaTomas.Desserialitzar miObjeto datos.obj

