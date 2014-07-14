# como maximo el vector puede almacenar 10 numeros
# cuyas celdas de memoria son
# E6 = 230		EB = 235
# E7 = 231		EC = 236
# E8 = 232		ED = 237
# E9 = 233		EE = 238
# EA = 234		EF = 239
# pero ademas se requiere que la 11ava posicion de memoria posea un cero
# que indique donde termina el vector
#
# Si el usuario ingresa un 0, se considera el fin de los datos ingresados y el proximo
# valor determina la operacion
# Si el usuario ingresa los 10 valores, el proximo valor a ingresar automaticamente
#determina la operacion
#

# se inicializan los registros
ldi 0,00		# r0 = contador = 0  se usa solo para la carga de datos
ldi 1,01		# r1 = incremento =1 (*)
ldi 5,00 	# r5 = 0 	util en algunas operaciones, ahorra lineas al no repetir esta operacion (*)
# (*) esto indica los registros cuyos valores nuncan cambian


# inicializacion de algunos valores de la memoria
# debido a que los numeros se almacenan por desplazamiento de izquierda a derecha,
# es suficiente con inicializar el primer valor y el 11 avo valor (en caso se ingresen 10 numeros)
# el 11 avo valor esta en la memoria cuya posicion es F0 = 240
stm 0,E6
stm 0,F0

# **************
# ingreso y control de datos
tag_inicio:
ldm 2,FD	# se guarda el valor ingresado en r2

ldi 3,0A		# se guarda temporalmente en r3 un 10, A(hexa), para controlar la cant. de numeros ingresados
xor 3,3,0 	# si el contador es 10, entonces r3 valdrá 0
jpz 3,tag_controlDeOperando	# Salta si el valor ingresado supera el tope de 10 numeros

jpz 2,tag_controlDeOperando
add 0,0,1	# se incrementa el contador
jpz 5,tag_almacenar

# **************
# almacena los datos en el vector de 10 posiciones
tag_almacenar:
# se realiza un desplazamiento de izq. a derecha del vector
ldm 4,EE
stm 4,EF
ldm 4,ED
stm 4,EE
ldm 4,EC
stm 4,ED
ldm 4,E6
stm 4,EC
ldm 4,EA
stm 4,E6
ldm 4,E9
stm 4,EA
ldm 4,E8
stm 4,E9
ldm 4,E7
stm 4,E8
ldm 4,E6
stm 4,E7

stm 2,E6	# se almacena el valor ingresado por el usuario al inicio del vector
jpz 5, tag_inicio


# **************
tag_controlDeOperando:
# el valor que determina la operacion ya esta almacenado en el registro 2
# debe valer 0, para hallar el minimo, o debe valer 1, para hallar el maximo
jpz 2,tag_evaluar_operacion		# salta si el valor de r2 es cero

# si no salta, pudo haber sido 1 o basura, se determina si el valor ingresado fue 1
# 1 en binario es 0000 0001  y  -1 en complemento a 2 es 1111 1111 = FF
ldi 3,FF
add 4,3,2 	# r4 <-- r2 + r3;  r4 <-- r2 + (-1)

# si r2 fue 1  entonces r4 valdrá 0, (se busca el maximo)
jpz 4,tag_evaluar_operacion

# si r2 no fue 1 ni 0, se pide un nuevo numero
ldm 2,FD
jpz 5,tag_controlDeOperando

#**************
tag_evaluar_operacion:
# el registro 10 contendra el resultado del maximo o el minimo

ldm 10,E6 	# se obtiene valor de la 1ra posicion del vector y se considera como el resultado
jpz 10,fin	# si el primer valor vale 0, no se ingreso ningun valor y se va a fin
jpz 5,tag_ciclo_evaluar_operacion

#**************
tag_ciclo_evaluar_operacion:
# se realiza un desplazamiento de derecha a izq. de todo el vector incluyendo el 11 avo valor (0)
ldm 4,E7
stm 4,E6
ldm 4,E8
stm 4,E7
ldm 4,E9
stm 4,E8
ldm 4,EA
stm 4,E9
ldm 4,EB
stm 4,EA
ldm 4,EC
stm 4,EB
ldm 4,ED
stm 4,EC
ldm 4,EE
stm 4,ED
ldm 4,EF
stm 4,EE
ldm 4,F0
stm 4,EF

ldm 11,E6	# se lee el siguiente valor que ahora esta en la primera posicion del vector
jpz 11,fin	# si el valor leido es 0 entonces no hay mas que leer y se considera el valor
		# del registro 10 como el resultado

ldi 13,FF 	# a
xor 14,13,11 	# b
add 13,14,1 	# c 	a, b y c permite obtener el valor negativo del registro 11, guardandolo en el registro 13

add 14,10,13 	# r14 contiene la diferencia: r14 <--- r10 - r11

# la diferencia r10 - r11 puede ser negativa o positiva, dandose dos casos:
# caso I:  Si es positiva r10 es el maximo y r11 es el minimo
# caso II: Si es negativa r10 es el minimo y r11 es el maximo
# si fuera cero (son iguales) no se analiza, directamente se toma r10 como resultado

jpz 14,tag_ciclo_evaluar_operacion	# si r14 es cero, r10 y r11 son iguales

# se analizan los dos casos
ldi 13,80	# r13 = 1000 0000 = 80h
and 15,13,14 	# si r14 es negativo entonces r15 valdra 80h, si es positivo valdra 0

jpz 15,tag_primer_caso

# aqui se ENCUENTRA en el 2do CASO, recordar que r2 no se modifico
jpz 2,tag_ciclo_evaluar_operacion 	# si r2 vale 0, se busca el minimo y r10 ya es el minimo
cop 11,10 	# si r2 = 1, se copia el maximo a r10, quien siempre tiene el resultado
jpz 5,tag_ciclo_evaluar_operacion	#

#*************
tag_primer_caso:
jpz 2,tag_minimo_primer_caso
jpz 5,tag_ciclo_evaluar_operacion

#*************
tag_minimo_primer_caso:
cop 11,10
jpz 5,tag_ciclo_evaluar_operacion

#*************
fin:
# si no se ingreso ningun valor se mostrara 0, de lo contrario se mostrara el resultado obtenido
stm 10,FF
ret
