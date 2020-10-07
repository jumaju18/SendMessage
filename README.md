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

