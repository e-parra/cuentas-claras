public void CalculaTotalaPagar()
  {
    if (!PersonasItems.isEmpty())
    {
      ResultadosItems.clear();
      double d1 = 0.0D;
      int i = 0;
      Object localObject1 = PersonasItems.iterator();
      Object localObject2;
      if (!((Iterator)localObject1).hasNext())
      {
        d1 /= i;
        localObject1 = new ArrayList();
        localObject2 = PersonasItems.iterator();
        label65:
        if (((Iterator)localObject2).hasNext()) {
          break label131;
        }
        i = 0;
      }
      label131:
      double d2;
      int j;
      for (;;)
      {
        if (i >= ((ArrayList)localObject1).size())
        {
          searchAdapter.notifyDataSetChanged();
          mUserAdapter.notifyDataSetChanged();
          return;
          d1 += ((persona)((Iterator)localObject1).next()).getImporte().doubleValue();
          i += 1;
          break;
          persona localPersona = (persona)((Iterator)localObject2).next();
          ((ArrayList)localObject1).add(new persona(localPersona.getDescripcion(), Double.valueOf(d1 - localPersona.getImporte().doubleValue())));
          break label65;
        }
        if (((persona)((ArrayList)localObject1).get(i)).getImporte().doubleValue() > 0.0D)
        {
          d2 = ((persona)((ArrayList)localObject1).get(i)).getImporte().doubleValue();
          j = 0;
          if ((j < ((ArrayList)localObject1).size()) && (d2 > 0.0D)) {
            break label243;
          }
        }
        i += 1;
      }
      label243:
      d1 = d2;
      if (i != j)
      {
        d1 = d2;
        if (((persona)((ArrayList)localObject1).get(j)).getImporte().doubleValue() < 0.0D)
        {
          if (((persona)((ArrayList)localObject1).get(j)).getImporte().doubleValue() + d2 > 0.0D) {
            break label438;
          }
          localObject2 = new persona(((persona)((ArrayList)localObject1).get(i)).getDescripcion() + " paga a " + ((persona)((ArrayList)localObject1).get(j)).getDescripcion(), Double.valueOf(redondear(d2, 2)));
          ((persona)((ArrayList)localObject1).get(j)).setImporte(Double.valueOf(((persona)((ArrayList)localObject1).get(j)).getImporte().doubleValue() + d2));
          d1 = 0.0D;
          ResultadosItems.add(localObject2);
        }
      }
      for (;;)
      {
        ((persona)((ArrayList)localObject1).get(i)).setImporte(Double.valueOf(0.0D));
        j += 1;
        d2 = d1;
        break;
        label438:
        localObject2 = new persona(((persona)((ArrayList)localObject1).get(i)).getDescripcion() + " paga a " + ((persona)((ArrayList)localObject1).get(j)).getDescripcion(), Double.valueOf(redondear(((persona)((ArrayList)localObject1).get(j)).getImporte().doubleValue() * -1.0D, 2)));
        d1 = d2 + ((persona)((ArrayList)localObject1).get(j)).getImporte().doubleValue();
        ((persona)((ArrayList)localObject1).get(j)).setImporte(Double.valueOf(0.0D));
        ResultadosItems.add(localObject2);
      }
    }
  }