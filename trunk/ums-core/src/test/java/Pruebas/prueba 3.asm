ldi 0,00
ldi 1,01
ldi 5,00
stm 0,E6
stm 0,F0
tag_inicio: ldm 2,FD
ldi 3,0A
xor 3,3,0
jpz 3,tag_controlDeOperando
jpz 2,tag_controlDeOperando
add 0,0,1
jpz 5,tag_almacenar
tag_almacenar: ldm 4,EE
stm 4,EF
ldm 4,ED
stm 4,EE
ldm 4,EC
stm 4,ED
ldm 4,EB
stm 4,EC
ldm 4,EA
stm 4,EB
ldm 4,E9
stm 4,EA
ldm 4,E8
stm 4,E9
ldm 4,E7
stm 4,E8
ldm 4,E6
stm 4,E7
stm 2,E6
jpz 5,tag_inicio
tag_controlDeOperando: ldm 2,FD
jpz 2,tag_evaluar_operacion
ldi 3,FF
add 4,3,2
jpz 4,tag_evaluar_operacion
ldm 2,FD
jpz 5,tag_controlDeOperando
tag_evaluar_operacion: ldm 10,E6
jpz 10,fin
jpz 5,tag_ciclo_evaluar_operacion
tag_ciclo_evaluar_operacion: ldm 4,E7
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
ldm 11,E6
jpz 11,fin
ldi 13,FF
xor 14,13,11
add 13,14,1
add 14,10,13
jpz 14,tag_ciclo_evaluar_operacion
ldi 13,80
and 15,13,14
jpz 15,tag_primer_caso
jpz 2,tag_ciclo_evaluar_operacion
cop 11,10
jpz 5,tag_ciclo_evaluar_operacion
tag_primer_caso: jpz 2,tag_minimo_primer_caso
jpz 5,tag_ciclo_evaluar_operacion
tag_minimo_primer_caso: cop 11,10
jpz 5,tag_ciclo_evaluar_operacion
fin: stm 10,FF
ret
