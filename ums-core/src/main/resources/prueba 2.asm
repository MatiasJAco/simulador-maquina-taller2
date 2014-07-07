ldm 1,FD	# se carga el 1er patron de bits
ldm 2,FD	# se carga el 2do patron de bits
ldm 3,FD	# se carga el 3er patron de bits # agrupandose: 1er numero -> (1 2)	2do numero -> (3 4)
ldm 4,FD	# se carga el 4to patron de bits # 2 y 4 son las mitades menos significativas del numero (1 2) y (3 4)
ldi 5,00	# se inicializa el registro 5, contendra el carry
ldi 6,00	# se inicializa el registro 6, sirve para extraer el carry
ldi 7,01	# se inicializa el registro 7, sirve para extraer el bit de la suma
ldi 13,08	# se inicializa el registro 13, su valor permite finalizar el FOR
ldi 11,00	# se inicializa el registro 11, contendra la suma
ldi 14,00	# se inicializa el registro 14 a cero, es el contador
tag_inicio: and 8,2,7	# el registro 8 contiene ahora el 1er bit
and 9,4,7	# el registro 9 contiene ahora el 1er bit
add 8,8,5 	# se suma el carry a un operando
add 10,8,9	# se suman los bits y se guarda temporalmente en el registro 10
and 12,10,7	# se extrae el bit de la suma y se guarda temp. en el registro 12
rotd 10,1 	# se rota el resultado de la suma
and 5,10,7 	# se extrae el carry 
or 11,11,12	# se coloca el bit de la suma en la suma final
rotd 11,1 	# se rota la suma final para colocar despues el sgte bit
rotd 2,1 	# se rota el 1er operando de la suma para usar el sgte bit 
rotd 4,1	# se rota el 2do operando de la suma para usar el sgte bit
add 14,14,7	# incremente en uno el registro 14
ldi 12,00	# el registro 12 sera usado para determinar si salta o no
and 12,13,14	# si 12 contiene un 8, se hicieron 8 rotaciones y no salta mas # hasta aqui el registro 11 contiene la suma de las partes menos significativas y el registro 5 contiene el carry de la suma
jpz 12,tag_inicio
ldi 10,00	# se sumas las partes mas significativas con el carry usando suma complemento a 2 # el registro 10 vale 0, contendra la suma de las mitades mas significativas
add 10,1,5	# sumo la mitad mas significativa del 1er numero y el carry
add 10,10,3 # el registro 10 contiene la suma de las mitades mas significativas
stm 10,FF # se escriben en la pantalla, 1ro la mitad mmas significativa despues la menos significativa
stm 11,FF
ret
