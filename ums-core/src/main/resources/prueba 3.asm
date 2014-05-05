
# SUPOSICIONES

# por defecto 0 es la direccion de memoria donde se empieza a almacenar los numeros,
# COMO MAXIMO SE PUEDEN CARGAR 4 NUMEROS, podrian ser mas numeros lo que significa mas lineas
# de codigo porque faltan instrucciones y se tienen que repetir bloques de codigos... 
# -> despues del 4to numero cargado (tope),  el siguiente es considerado como el 2do patron que 
# determina que buscar.
# supongo que los numeros ingresados son enteros positivos

ldi 15,00	# se inicializa el registo 15 que es el contador
ldi 16,01	# se inicializa el registo 16, que se sumará al contador

ldm 1,FD	# se guarda en el registro 1 el numero ingresado por el usuario
jpz 1,tag_evaluar_condicion	# si el numero ingresado es 00h se evalua condic.
stm 1,0		# se almacena el patron de bits del registro 1 en la direc de memoria 0
add 15,15,16	# se incrementa el contador

ldm 1,FD
jpz 1,tag_evaluar_condicion
stm 1,1
add 15,15,16

ldm 1,FD
jpz 1,tag_evaluar_condicion
stm 1,2
add 15,15,16

ldm 1,FD
jpz 1,tag_evaluar_condicion
stm 1,3
add 15,15,16

tag_evaluar_condicion:

ldm 1,FD	# se lee el 2do patron de bits y se guarda en el registro 1
jpz 1,tag_minimo	# si el 2do valor ingresado es 00h se busca el minimo

# 1 en binario es 0000 0001  y  -1 en complemento a 2 es 1111 1111 = FF
ldi 2,FF	# cargo el registro 2 con -1 en complento a 2
add 3,2,1	

# si la suma (resta) es 00h el 2do valor ingresado era 0000 0001 = 01h
# por lo que se debe buscar el maximo
jpz 3,tag_maximo

# si no se ingreso 00h o 01h se repite la evaluacion de condicion
ldi 1,00
jpz 1,tag_evaluar_condicion


##########################################

# para determinar el maximo entre dos numeros a y b, se restan (a-b) 
# si el resultado es negativo b es mayor que a, si es positivo o cero a es mayor que b

tag_maximo:
ldi 10,00	# en caso que no se ingrese ningun numero se muestra cero
jpz 15,tag_imprimir	# si el contador (registro 15) vale 0 no hay mas que evaluar

ldi 14,00	# el registro 14 es un contador auxiliar que contiene la posicion de memoria
ldi 13,01	# el registro 13  contiene 1 para sumar y aumentar en uno
ldi 3,FF	# cargo el patron de bits FF en el registro 3

########
ldm 10,00	# cargo el registro 10 con el primer valor, asumiendo que es el maximo
add 14,14,13	# aumento_0

# se resta el contador y el contador auxiliar
xor 9,14,3	# se guarda en el registro 9 el complemento a 1 del numero que esta en el registro 14
add 8,9,13	# se suma 1 al registro 9 de modo que ahora el registro 8 contiene el negativo del registro 14
add 7,15,8	# se resta el contador y el contador auxiliar

jpz 7,tag_imprimir	# si la resta vale cero se imprime el maximo, solo habia un numero

########
ldm 11,01	# cargo el 2do valor en el registro 11

xor 9,11,3	# el negativo del 2do valor se guarda en el registro 8
add 8,9,13
add 7,8,10	# la resta se guarda en el registro 7

jpz 7,aumentar_1	# si la resta es cero son iguales, entonces no se hace nada porque 
# el registro 10 ya contenia el maximo, se continua con la busqueda
ldi 4,80	# cargo el registro 4 con el 80h = 1000 0000
and 5,7,4	# si el valor que esta en el registro 7 es negativo el registro 5 contendra 80h
# si es positivo contedra 00h
jpz 5,aumentar_1	# si el valor fue cero entonces el primer numero era mayor, que corresponde
 # al numero que ya estaba almacenado en el registro 10, se continua con la busqueda...

# la resta fue negativa
cop 11,10	# se actualiza el mayor 

aumentar_1:
add 14,14,13

# se resta el contador y el contador auxiliar
xor 9,14,3	
add 8,9,13	
add 7,15,8	
jpz 7,tag_imprimir

########
ldm 11,02

xor 9,11,3	
add 8,9,13
add 7,8,10	
jpz 7,aumentar_2
ldi 4,80
and 5,7,4
jpz 5,aumentar_2
cop 11,10

aumentar_2:
add 14,14,13

# se resta el contador y el contador auxiliar
xor 9,14,3	
add 8,9,13	
add 7,15,8	
jpz 7,tag_imprimir

########
ldm 11,03

xor 9,11,3	
add 8,9,13
add 7,8,10	
jpz 7,fin_maximo
ldi 4,80
and 5,7,4
jpz 5,fin_maximo
cop 11,10

fin_maximo:
ldi 5,00
jpz 5,tag_imprimir


##########################################
tag_minimo:
ldi 10,00	# en caso que no se ingrese ningun numero se muestra cero
jpz 15,tag_imprimir	# si el contador (registro 15) vale 0 no hay mas que evaluar

ldi 14,00	# el registro 14 es un contador auxiliar que contiene la posicion de memoria
ldi 13,01	# el registro 13  contiene 1 para sumar y aumentar en uno
ldi 3,FF	# cargo el patron de bits FF en el registro 3

########
ldm 10,00	# cargo el registro 10 con el primer valor, asumiendo que es el minimo
add 14,14,13	# aumento 0

# se resta el contador y el contador auxiliar
xor 9,14,3	# se guarda en el registro 9 el complemento a 1 del numero que esta en el registro 14
add 8,9,13	# se suma 1 al registro 9 de modo que ahora el registro 8 contiene el negativo del registro 14
add 7,15,8	# se resta el contador y el contador auxiliar

jpz 7,tag_imprimir	# si la resta vale cero se imprime el minimo, solo habia un numero

########
ldm 11,01	# cargo el 2do valor en el registro 11

xor 9,11,3	# el negativo del 2do valor se guarda en el registro 8
add 8,9,13
add 7,8,10	# la resta se guarda en el registro 7

jpz 7,aumentar_1	# si la resta es cero son iguales, entonces no se hace nada porque 
# el registro 10 ya contenia el minimo, se continua con la busqueda
ldi 4,80	# cargo el registro 4 con el 80h = 1000 0000
and 5,7,4	# si el valor que esta en el registro 7 es negativo el registro 5 contendra 80h
# si es positivo contedra 00h
jpz 5,swap_minimo_1	# si el valor fue cero entonces el primer numero era mayor, que corresponde
# al numero que ya estaba almacenado en el registro 10
# y el 2do numero (registro 11) es el menor, y se debe copiar al registro 10

# si el valor que estaba en el registro 7 fue negativo, el 1er numero(registro 10) es menor y 
# el 2do numero(registro 11) es mayor no se hace nada, se sigue con la busqueda

ldi 4,00
jpz 4,aumentar_1

swap_minimo_1:
cop 11,10	# se actualiza el mayor 

aumentar_1:
add 14,14,13

# se resta el contador y el contador auxiliar
xor 9,14,3	
add 8,9,13	
add 7,15,8	
jpz 7,tag_imprimir

########
ldm 11,02

xor 9,11,3	
add 8,9,13
add 7,8,10	
jpz 7,aumentar_2
ldi 4,80
and 5,7,4
jpz 5,swap_minimo_2
ldi 4,00
jpz 4,aumentar_2

swap_minimo_2:
cop 11,10

aumentar_2:
add 14,14,13

xor 9,14,3	
add 8,9,13	
add 7,15,8	
jpz 7,tag_imprimir

########
ldm 11,03

xor 9,11,3	
add 8,9,13
add 7,8,10	
jpz 7,fin_minimo
ldi 4,80
and 5,7,4
jpz 5,swap_minimo_3
ldi 4,00
jpz 4,fin_minimo

swap_minimo_3:
cop 11,10

fin_minimo:
ldi 5,00
jpz 5,tag_imprimir

#########################################

tag_imprimir:
stm 10,FF
ret













