ldm 1,FD
ldm 2,FD
ldm 3,FD
ldm 4,FD
ldi 5,00
ldi 6,00
ldi 7,01
ldi 13,08
ldi 11,00
ldi 14,00
tag_inicio: and 8,2,7
and 9,4,7
add 8,8,5
add 10,8,9
and 12,10,7
rotd 10,1
and 5,10,7
or 11,11,12
rotd 11,1
rotd 2,1
rotd 4,1
add 14,14,7
ldi 12,00
and 12,13,14
jpz 12,tag_inicio
ldi 10,00
add 10,1,5
add 10,10,3
stm 10,FF
stm 11,FF
ret
