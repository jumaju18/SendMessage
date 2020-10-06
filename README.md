# SendMessage
06/10
+Instalar el HolaMundo en el movil
+Activar opciones de desarrollador
-Activar depuracion y aceptar
-Adb -s [dispositivo a entrar] shell // para elegir
-Diferentes editores ver ReadMe
-Nuevo proyecto SendMessage, estructura en pizzara
-Borrar activity empty, y crear una basic con launch activado.
-Borrar Fragments y en layour dejar solo xml activity send message
-borrar     <include layout="@layout/content_send_message" /> del xml activity send message
-crear desde pallet constraintlayout en el XML a nivel de appbarlayout
-hacer un tv, tvUser, tv user desde design arriba e izquierda del padre, 16 por al izquierda separado y 80 de arriba (separado de arriba lo que queramos)
-plaintext a nivel tvUser, izq a la derecha e yvUser y la derecha de ED a la izquierda del padre, cick derecho show baseline y alinear con tvUser. android:id="@+id/edUser". de-> android:text="..."  a ->tools:text="..."
-alineó nuevo tv a tvuser y nuevo ed con el tv y desde el editor(entorno grafico) le pongo de nombre tvmessage al segundo tv
-android:labelFor="@+id/tvUser" en el primer ed,,, android:labelFor="@+id/tvMessage" en el segundo ed
-colores en resource manager, lógica de colores(teoria)
-volvemos al .java, tenemos que crear un objeto boundler
-creamos el intent y depués hacemos el startActivity
