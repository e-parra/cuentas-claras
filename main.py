import requests


lista = []
status = True
while status == True:
    name = input('ingrese el nombre: ')
    if name == 'fin':
        status = False
    else:
        monto = input('ingrese el monto: ')
        lista.append((name,monto))   
    
print(lista)

# monto_total = 0
# for i in range(len(lista)):
#      monto_total += int(lista[i][1])

# print (f'el monto_total es de ${monto_total}')

# por_persona = monto_total/len(lista)

# print(f'cada persona debe pagar $ {por_persona}')

# i=0
# while i >= len(lista):
#     if lista[i][1] < por_persona:
#------------------------------------------------------------------

if lista:
    cant_personas = len(lista)
    monto_total = 0
    for i in range(len(lista)):
        monto_total += int(lista[i][1])

    monto_por_persona = monto_total/len(lista) 

    d2 = 0
    j = 0
    while j < len(lista):
        if i >= len(lista):
            break
        if lista[i].getImporte() > 0.0:
            d2 = lista[i].getImporte()
            j = 0
            while j < len(lista) and d2 > 0.0:
                if lista[j].getImporte() > 0.0:
                    break
                j += 1
            if j >= len(lista) or d2 <= 0.0:
                break
        i += 1

    monto = d2
    if i != j:
        monto = d2
        if lista[j].getImporte() < 0.0:
            if lista[j].getImporte() + d2 > 0.0:
                localObject2 = persona(lista[i].getDescripcion() + " paga a " + lista[j].getDescripcion(), round(d2, 2))
                lista[j].setImporte(lista[j].getImporte() + d2)
                monto = 0.0
                ResultadosItems.append(localObject2)
            else:
                localObject2 = persona(lista[i].getDescripcion() + " paga a " + lista[j].getDescripcion(), round(lista[j].getImporte() * -1.0, 2))
                monto = d2 + lista[j].getImporte()
                lista[j].setImporte(0.0)
                ResultadosItems.append(localObject2)
        i += 1
        
print()

