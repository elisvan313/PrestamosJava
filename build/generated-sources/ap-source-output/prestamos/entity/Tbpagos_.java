package prestamos.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-27T22:16:38")
@StaticMetamodel(Tbpagos.class)
public class Tbpagos_ { 

    public static volatile SingularAttribute<Tbpagos, Integer> saldoactual;
    public static volatile SingularAttribute<Tbpagos, Date> fechapago;
    public static volatile SingularAttribute<Tbpagos, Integer> cuotaspendientes;
    public static volatile SingularAttribute<Tbpagos, Integer> codigoprestamo;
    public static volatile SingularAttribute<Tbpagos, Integer> idpago;
    public static volatile SingularAttribute<Tbpagos, Integer> cuotaspagadas;
    public static volatile SingularAttribute<Tbpagos, String> nombrec;

}