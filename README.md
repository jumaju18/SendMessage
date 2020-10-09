# SendMessage
06/10
-Instalar el HolaMundo en el movil

-Activar opciones de desarrollador

-Activar depuracion y aceptar

-Adb -s [dispositivo a entrar] shell // para elegir

-Diferentes editores ver ReadMe

-Nuevo proyecto SendMessage, estructura en pizzara.

-Borrar activity empty, y crear una basic con launch activado.

-Borrar Fragments y en layour dejar solo xml activity send message

-borrar     <include layout="@layout/content_send_message" /> del xml activity send message

-crear desde pallet constraintlayout en el XML a nivel de appbarlayout

-hacer un tv, tvUser, tv user desde design arriba e izquierda del padre, 16 por al izquierda separado y 80 de arriba (separado de arriba lo que queramos)

-plaintext a nivel tvUser, izq a la derecha e yvUser y la derecha de ED a la izquierda del padre, cick derecho show baseline y alinear con tvUser. 
android:id="@+id/edUser". de-> android:text="..."  a ->tools:text="..."

-alineó nuevo tv a tvuser y nuevo ed con el tv y desde el editor(entorno grafico) le pongo de nombre tvmessage al segundo tv

-android:labelFor="@+id/tvUser" en el primer ed,,, android:labelFor="@+id/tvMessage" en el segundo ed

-colores en resource manager, lógica de colores(teoria)

-volvemos al .java, tenemos que crear un objeto boundler

-creamos el intent y depués hacemos el startActivity

07/10
7/10


1º
Documentacion clase /** */ (hemos documentado SendMessageActivity y ViewMessageActivity) esta en la teoría junto con los @link @see @author etc...

https://moronlu18.com/wordpress/courses/deint/178-1748


2º
Luego de documentar ir a Tools -> Generar JavaDoc

Dentro de Generar JavaDoc desactivar las opcion de Include test source

Añadir librerias JDK (donde salga JDK le damos a que lo agregue) (son las 2 opciones encima de elegir la ruta) (AÑADIR SOLO SI SE REFERENCIA CLASES JAVA ej: String)

También debajo de la ruta elegir @author @use etc... (Si no lo añadimos no se enseñara ni la versión ni el autor y otros elementos agregados)


El output directory elegir donde se guarda (la ruta que hemos escogido es el /app del proyecto Y CUANDO LE DAMOS A OK DEBEMOS AGREGAR AL FINAL DE LA RUTA /doc) Ej: /home/israelnavarrete/AndroidStudioProjects/SendMessage/app/doc


3º
Comentarios TODO

Normalmente no se usan en el propio codigo si no que en la carpeta app se crea un nuevo archivo llamado por ejemplo task.txt y ahí se escriben

https://moronlu18.com/wordpress/courses/deint/178-1748

4º
Todo sobre las actividades

PILA DE ACTIVIDADES (teoria)

Interfaz usuario (teoria) (Si no se entiende mirar jerarquia activity_send_activity y ahí se ve claramente si no preguntar por grupo)

https://moronlu18.com/wordpress/courses/deint/178-1570

5º
Ciclo de vida de una actividad

Estados activity (Running, paused etc...)

https://moronlu18.com/wordpress/courses/deint/178-1904

6º
Metodos Callback (al final de la teoria hay una imagen que explica el ciclo de vida)

Ir a Code -> Override methods
elegir Onstart, OnResume, Onpause, OnStop y OnDestroy

En el metodo OnStart usamos la clase Log para escribir un mensaje en el LogCat (abajo de la interfaz de android studio)
Copiamos el Log en el resto de métodos tanto en la clase SendMessageActivity como en ViewMessageActivity
(para el TAG que pide hay que crear una constante estatica de tipo String con el nombre de la clase,
 el mensaje da igual en nuestro caso usamos SendMessageActivity -> onStart()" cambiando el método según donde se escriba)

https://moronlu18.com/wordpress/courses/deint/178-1904

7º
Añadir librerias

Añadimos el logger (en la teoria esta el enlace del github)

Seguimos los pasos de instalacion (para la parte de download hay que ir a build.gralde (Module: app) y añadir la linea de github
y sincronizar)

Luego inicializamos la clase Logger y  usamos Logger.d();

Otra manera para agregar librerias es ir a File -> project Structure -> dependencies ->
darle al boton + donde salen todas las dependencias, elegir library y ahi escribir el nombre de la libreria

https://moronlu18.com/wordpress/courses/deint/178-1306


8º
INSTALACION MATERIALABOUT
(en el git esta todo)
Creamos clase nueva de java llamada AboutActivity

Sobreescribimos el metodo OnCreate(); y añadimos el contenido de github (Implementation)

Añadir esto al build.gradle (Project:SendMessage) maven { url "https://jitpack.io" }
luego al otro build.gradle y poner implementation 'com.github.jrvansuita:MaterialAbout:+' y sincronizar

Ir al manifiesto y añadir la nueva clase  <activity android:name=".AboutActivity"></activity>

https://moronlu18.com/wordpress/courses/deint/178-1306

9º
Seguimos con el ejercicio ahora en la clase ViewMessageActivity

Recogemos el intent con el metodo getIntent)(;

Recogemos el bundle con intent.getExtras();

Añadimos 2 textview al layout view_message

Asignamos los String a los textview con .setText();

9/10

1º
Refactorizamos el código

Creamos un método llamado SendMessage el cual será llamado en el método sobreescrito OnClick().

Cambiamos la construccion del intent al estar en un metodo dentro de la clase
(sin estar dentro de otro metodo) se puede poner directamente this sin especificar la clase

2º
Explicacion clase POJO. Son clases que representan directamente los datos de la base de datos, es decir,
si tuvieramos una tabla persona con 3 columnas (id,nombre,salario) la clase POJO es literalmente una representación
de estos valores (buscar en internet o preguntar si no se entiende).

3º
Creamos 2 packages nuevos para guardar las clases en com.example.sendmessage llamadas com.example.sendmessage.ui para los Activity
y com.example.sendmessage.model para las clases POJO.
(en com.example.sendmessage click derecho -> new -> Package)

Dentro de model creamos una nueva clase java para user llamada user en la cual creamos 3 variables y generamos
(Code -> Generate -> getter and setter y seleccionamos las 3 variables) y tambien generamos el metodo
ToString() para sobreescrbirlo (Control+O -> ToString()) y sobreescribimos y hacemos lo mismo con equals y HashCode y constructor
(Code -> Generate -> equals and hashcode)

Creamos otra clase Java llamada Message y creamos 3 variables (esta vez user es de tipo User)
y hacemos lo mismo que con la clase anterior
(generamos setter and getter, ToString, equals y hash y constructor
IMPORTANTE ESTA VEZ GENERAR EQUALS Y HASH CON INTELLJ se cambia donde pone java7+ esta arriba)

4º
Explicacion patron singleton (Es una clase que solo se instrancia una vez y dentro de si misma, buscar en wikipedia ejemplo java)
Crea un constructor vacio PRIVADO y se crea una variable estatica privada = null
Luego se hacen 2 metodos 1 de ellos para crear una instancia de la clase (metodo privado) si no hay ninguna otra instancia la crea y
otro metodo para coger esa instancia y crearla si no existe (este metodo es publico)

Esto asegura que solo se pueda acceder a la clase desde 1 unico punto global (usando el metodo publico)


5º
Creamos una nueva clase java fuera de los demas package llamada SendMessageApplication (hereda de Application)
sobreescribimos el metodo Oncreate y creamos un objeto user
(Podemos reformar el codigo para que sea mas cómodo de leer en Code -> reformat code)
Generamos el getter del user SOLO EL GETTER (setter no porque no vamos a modificar el usuario NUNCA)

Vamos al manifest y añadimos la clase (dentro de <Application>) android:name=".SendMessageApplication"


6º
Refactorizamos SendMessageActivity

Hacemos que el texto del usuario sea el de la clase POJO user, es decir, llamamos a nuestra clase Application (la clase singleton)
luego de ahi cogemos su getUser() y dentro de ese getUser seleccionamos getUser(); (es decir con estos 2 getuser en el primero
estamos en nuestra clase Application y cuando decimos ese getUser vamos a nuestra clase user y de ahi cogemos la variable user)
Ver comentario codigo si no queda claro (Esta en SendMessageActivity)

Impedimos que el EditText de user no sea editable

Ya hemos conseguido que el user no pueda ser nulo ahora toca editar message

Creamos un message (cuidado porque android importa su paquete message hay que cambiarlo al nuestro)

Saldra un error debido a que el constructor solo funciona con 3 parametros por ello vamos a la clase Message
y comentamos el constructor para ver que java por si solo crea el constructor vacio.

Creamos un constructor vacio

Finalmente creamos el message y añadimos los campos y ahroa añadimos el message al bundle

Serializamos message y lo añadimos al bundle (añadir la interfaz serializable a la clase Message)

Vamos a ViewMessageActivity y cambiamos el punto 3
(Puede ocurrir el mismo error a la hora de importar la clase Message)
ERROR NO SERIALIZABLE HAY QUE IMPLEMENTAR serializable A USER


7º
Controlar Errores

en el metodo Onclick() llamamos a otros 2 nuevos metodos que controlan el error de mensaje vacio (emptyMessage() y ShowErrors()).

Creamos un nuevo .xml en la carpeta res -> values (errors) y creamos un nuevo error de tipo string y en el metodo ShowErrors lo llamamos
