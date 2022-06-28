package prestamos.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-27T22:16:38")
@StaticMetamodel(Tbprestamo.class)
public class Tbprestamo_ { 

    public static volatile SingularAttribute<Tbprestamo, Integer> codigo;
    public static volatile SingularAttribute<Tbprestamo, Date> fechaprestamo;
    public static volatile SingularAttribute<Tbprestamo, Integer> ncuotas;
    public static volatile SingularAttribute<Tbprestamo, String> tipoprestamo;
    public static volatile SingularAttribute<Tbprestamo, Integer> valorcuota;
    public static volatile SingularAttribute<Tbprestamo, Date> fechavencer;
    public static volatile SingularAttribute<Tbprestamo, Integer> valorprestamo;
    public static volatile SingularAttribute<Tbprestamo, String> nombrec;
    public static volatile SingularAttribute<Tbprestamo, Integer> interes;

}