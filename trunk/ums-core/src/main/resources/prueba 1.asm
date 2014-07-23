ldm 1,FD	# se carga el 1er patron de bits (primer float)
ldm 2,FD	# se carga el 2do patron de bits (segundo float)
ldi 3,80	# se carga mascara para extraer el signo
ldi 4,70	# se carga mascara para extraer el exponente
ldi 5,0F	# se carga mascara para extraer la mantisa
and 6,4,1	# se carga el exponente de primer operando
and 7,4,2	# se carga el exponente de segundo operando
and 8,3,1	# se carga el signo de primer operando
and 9,3,2	# se carga el signo de segundo operando
xor 15,8,9	# se calcula el signo del resultado
add 10,6,7	# inicia calculo de exponente
rotd 10,4
ldi 14,08	#constantes necesarias para decidir como restar el exceso
and 11,10,14
jpz 11,restar_exceso_chico	# saltar si no usa exceso extendido, sera 100
ldi 14,0C	#exceso a restar 1100
resta_de_exceso: add 10,14,10 #resta el exceso
ldi 14,18			#si en la posicion 4 y 3 hay bit -> overflow
and 11,14,10
xor 11,11,14
jpz 11,fin_overflow
ldi 14,40  # si los dos exponentes son negativos y el resultado positivo hay underflow
and 12,6,14 # signo de op 1
and 13,7,14 # signo de op 2
or 12,12,13
jpz 12,chequear_underflow
extraer: jpz 0,extraer_exponente
chequear_underflow: ldi 14,04  # si los dos exponentes son negativos y el resultado positivo hay underflow
and 11,10,14
jpz 11,extraer
jpz 0,fin_underflow
restar_exceso_chico: ldi 14,04
jpz 0,resta_de_exceso
extraer_exponente: rotd 10,4
and 10,10,4
ldi 8,10
and 6,1,5	# Se carga la mantisa 1 de los operandos al registro
add 6,6,8
and 7,2,5	# Se carga la mantisa 2 de los operandos al registro 
add 7,7,8
ldi 14,00	# se inicializa la mantisa final
ldi 13,01	# Patron para detectar LSB
loop_calculo_mantisa: rotd 14,1 #shift right mantisa final
ldi 11,7F
and 14,11,14
and 12,7,13	 # Ver si LSB es 1.
rotd 7,1	# Shift right mantisa2
ldi 11,1F
and 7,7,11	
jpz 12,loop_calculo_mantisa  #Si LSB es 0 no se hace nada.
add 14,6,14	 #Se suma mantisa1 a mantisa final
jpz 7,ajuste_exponente
jpz 0,loop_calculo_mantisa
ajuste_exponente: ldi 11,20 #si hay un 1 en la posicion 5 incrementar el exponente en 1
and 9,11,14
jpz 9,fin_calculo_mantisa
ldi 9,10
add 10,10,9   #incrementa exponente
ldi 1,80			#si en la posicion 7 hay bit -> overflow
and 2,1,10
xor 3,1,2
jpz 3,fin_overflow
rotd 14,1  # shift right de la mantisa final para ajustar
fin_calculo_mantisa: and 14,14,5
add 15,15,14  # se carga la mantisa final al registro del resultado
add 15,15,10  # se carga el exponente final al registro del resultado
stm 15,FF  #Se muestra resultado por pantalla.
fin: ret
fin_overflow: ldi 15,FF
stm 15,FF  #Se muestra  por pantalla FFFF por overflow.
stm 15,FF
jpz 0,fin
fin_underflow: ldi 15,00
stm 15,FF  #Se muestra resultado por pantalla 0000 por underflow.
stm 15,FF  
jpz 0,fin
